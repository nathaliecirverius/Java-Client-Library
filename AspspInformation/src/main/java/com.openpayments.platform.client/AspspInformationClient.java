package com.openpayments.platform.client;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpContent;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.UrlEncodedContent;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.common.collect.ImmutableList;
import com.openpayments.platform.models.Aspsps;
import com.openpayments.platform.models.Cities;
import com.openpayments.platform.models.Countries;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;


/**
 * Singleton class representation of a information client.
 */
public class AspspInformationClient implements IAspspInformationClient
{
    private static AspspInformationClient iAspspInformationClient;

    private static AspspInformationClientOptions iAspspInformationClientOptions;

    private static Token iToken;

    /**
     * HttpRequestFactory to build requests to server.
     */
    private final HttpRequestFactory iRequestFactory = new NetHttpTransport().createRequestFactory(httpRequest ->
            httpRequest.setParser(new JsonObjectParser(JacksonFactory.getDefaultInstance())));

    /**
     * Part of the URL used for request calls to server.
     */
    private final String iUrlBase = "/aspspinformation/v1/aspsps/";

    private AspspInformationClient(final AspspInformationClientOptions aspspInformationClientOptions)
    {
        iAspspInformationClientOptions = aspspInformationClientOptions;
    }

    /**
     * @param aspspInformationClientOptions (client id, client secret, api, authority).
     * @param tokenURL url for token request.
     * @return only instance of AspspInformationClient.
     */
    public static AspspInformationClient getInstance(final AspspInformationClientOptions aspspInformationClientOptions, final String tokenURL)
    {
        if (iAspspInformationClient == null)
        {
            try
            {
                iAspspInformationClient = new AspspInformationClient(aspspInformationClientOptions);
                iToken = getToken(iAspspInformationClientOptions.getClientId(), iAspspInformationClientOptions.getClientSecret(), tokenURL);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        return iAspspInformationClient;
    }

    /**
     * @param clientId to identify the client.
     * @param clientSecret to identify the client.
     * @param getTokenUrl to authorize the client.
     * @return Token object (accessToken, expiresIn, tokenType)
     * @throws Exception
     */
    private static Token getToken(final String clientId, final String clientSecret, final String getTokenUrl) throws Exception
    {
        final GenericUrl url = new GenericUrl(getTokenUrl);

        final HttpRequestFactory requestFactory = new NetHttpTransport().createRequestFactory(httpRequest ->
                httpRequest.setParser(new JsonObjectParser(JacksonFactory.getDefaultInstance())));

        // Create Map to hold key and value for body parameters.
        //
        final Map<String, String> parameters = new HashMap<>();
        parameters.put("client_id", clientId);
        parameters.put("client_secret", clientSecret);
        parameters.put("grant_type", "client_credentials");
        parameters.put("scope", "aspspinformation");

        // Set map as content.
        //
        final HttpContent bodyContent = new UrlEncodedContent(parameters);

        // Build POST request with url and content.
        //
        final HttpResponse response = requestFactory
                .buildPostRequest(url, bodyContent)
                .execute();

        // Read the response.
        //
        final InputStream inputStream = response.getContent();

        int read = inputStream.read();
        final StringBuilder tokenString = new StringBuilder();

        // Build a String from the output.
        //
        while (read != -1)
        {
            tokenString.append((char) read);
            read = inputStream.read();
        }

        // Map String to Token object.
        //
        final ObjectMapper objectMapper = new ObjectMapper();
        final TypeReference<Token> tokenTypeReference = new TypeReference<>() {};
        final Token token = objectMapper.readValue(tokenString.toString(), tokenTypeReference);

        return token;
    }

    /**
     * @return Countries object with list of countries.
     * @throws IOException
     */
    public Countries getCountries() throws IOException
    {
        final String getCountries = iAspspInformationClientOptions.getApi() + iUrlBase + "countries";

        final GenericUrl genericUrl = new GenericUrl(getCountries);

        // Use token in header for authorization.
        //
        final HttpHeaders headers = new HttpHeaders();
        headers.put("Authorization", ImmutableList.of("Bearer " + iToken.getAccessToken()));

        // Build GET request with url and header.
        //
        final HttpResponse response = iRequestFactory
                .buildGetRequest(genericUrl)
                .setHeaders(headers)
                .execute();

        // Read the response and make it a string.
        //
        final InputStream inputStream = response.getContent();
        int read = inputStream.read();
        final StringBuilder countriesString = new StringBuilder();

        while (read != -1)
        {
            countriesString.append((char) read);
            read = inputStream.read();
        }

        // Convert string to countries object.
        //
        final TypeReference<Countries> tokenTypeReference = new TypeReference<>() {};
        final Countries countries = new ObjectMapper().readValue(countriesString.toString(), tokenTypeReference);

        return countries;
    }

    /**
     * @param isoCountryCode iso code of given country.
     * @return Cities object with list of cities.
     * @throws IOException
     */
    public Cities getCities(final String isoCountryCode) throws IOException
    {
        final String getCities = iAspspInformationClientOptions.getApi() + iUrlBase + isoCountryCode + "/cities";

        final GenericUrl genericUrl = new GenericUrl(getCities);

        // Use token in header for authorization.
        //
        final HttpHeaders headers = new HttpHeaders();
        headers.put("Authorization", ImmutableList.of("Bearer " + iToken.getAccessToken()));

        // Build GET request with url and header.
        //
        final HttpResponse response = iRequestFactory
                .buildGetRequest(genericUrl)
                .setHeaders(headers)
                .execute();

        // Read the response and make it a string.
        //
        final InputStream inputStream = response.getContent();
        int read = inputStream.read();
        final StringBuilder citiesString = new StringBuilder();

        while (read != -1)
        {
            citiesString.append((char) read);
            read = inputStream.read();
        }

        // Convert string to cities object.
        //
        final TypeReference<Cities> tokenTypeReference = new TypeReference<>() {};
        final Cities cities = new ObjectMapper().readValue(citiesString.toString(), tokenTypeReference);

        return cities;
    }

    /**
     * @param isoCountryCode iso code of given country.
     * @param cityId id of given city.
     * @return Aspsps object with list of Aspsps.
     * @throws IOException
     */
    public Aspsps getAspsps(final String isoCountryCode, final String cityId) throws IOException
    {
        final String getBanksByCityIdUrl = iAspspInformationClientOptions.getApi() + iUrlBase + isoCountryCode + "/cities/" + cityId;

        final GenericUrl genericUrl = new GenericUrl(getBanksByCityIdUrl);

        // Use token in header for authorization.
        //
        final HttpHeaders headers = new HttpHeaders();
        headers.put("Authorization", ImmutableList.of("Bearer " + iToken.getAccessToken()));

        // Build GET request with url and header.
        //
        final HttpResponse response = iRequestFactory
                .buildGetRequest(genericUrl)
                .setHeaders(headers)
                .execute();

        // Read the response and make it a string.
        //
        final InputStream inputStream = response.getContent();
        int read = inputStream.read();
        final StringBuilder aspspsString = new StringBuilder();

        while (read != -1)
        {
            aspspsString.append((char) read);
            read = inputStream.read();
        }

        // Create a ObjectMapper to convert your response to an object.
        // Must be enabled for single values, otherwise it casts a JsonMappingException.
        //
        final ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);

        // Convert string to Aspsps object.
        //
        final TypeReference<Aspsps> banksTypeReference = new TypeReference<>() {};
        final Aspsps aspsps = objectMapper.readValue(aspspsString.toString(), banksTypeReference);

        return aspsps;
    }

    private class Token
    {
        private final String iAccessToken;
        private final int iExpiresIn;
        private final String iTokenType;

        public Token(@JsonProperty("access_token") String accessToken,
                     @JsonProperty("expires_in") int expiresIn,
                     @JsonProperty("token_type") String tokenType)
        {
            iAccessToken = accessToken;
            iExpiresIn = expiresIn;
            iTokenType = tokenType;
        }

        public String getAccessToken()
        {
            return iAccessToken;
        }

        public int getExpiresIn()
        {
            return iExpiresIn;
        }

        public String getTokenType()
        {
            return iTokenType;
        }
    }
}
