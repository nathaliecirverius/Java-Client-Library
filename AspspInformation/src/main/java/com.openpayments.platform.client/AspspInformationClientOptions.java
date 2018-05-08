package com.openpayments.platform.client;

public class AspspInformationClientOptions
{
    private final String iClientId;
    private final String iClientSecret;
    private final String iApi;
    private final String iAuthority;

    public AspspInformationClientOptions(final String clientid,
                                         final String clientSecret,
                                         final String api,
                                         final String authority)
    {
        iClientId = clientid;
        iClientSecret = clientSecret;
        iApi = api;
        iAuthority = authority;
    }

    public String getClientId()
    {
        return iClientId;
    }

    public String getClientSecret()
    {
        return iClientSecret;
    }

    public String getApi()
    {
        return iApi;
    }

    public String getAuthority()
    {
        return iAuthority;
    }
}

