package com.openpayments.platform.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Class representation of Json "postal address" object to given Aspsp.
 */
public class PostalAddress
{
    private final String iStreetAddress;
    private final String iPostalCode;
    private final String iCity;
    private final String iCityId;
    private final String iIsoCountryCode;
    private final String iCountry;

    public PostalAddress(@JsonProperty("streetAddress") final String streetAddress,
                         @JsonProperty("postalCode") final String postalCode,
                         @JsonProperty("city") final String city,
                         @JsonProperty("cityId") final String cityId,
                         @JsonProperty("isoCountryCode") final String isoCountryCode,
                         @JsonProperty("country") final String country)
    {
        iStreetAddress = streetAddress;
        iPostalCode = postalCode;
        iCity = city;
        iCityId = cityId;
        iIsoCountryCode = isoCountryCode;
        iCountry = country;
    }

    public String getStreetAddress()
    {
        return iStreetAddress;
    }

    public String getPostalCode()
    {
        return iPostalCode;
    }

    public String getCity()
    {
        return iCity;
    }

    public String getCityId()
    {
        return iCityId;
    }

    public String getIsoCountryCode()
    {
        return iIsoCountryCode;
    }

    public String getCountry()
    {
        return iCountry;
    }
}
