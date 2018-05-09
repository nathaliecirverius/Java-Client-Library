package com.openpayments.platform.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Class representation of Json "Country" object.
 */
public class Country
{
    private final String iIsoCountryCode;
    private final String iName;

    public Country(@JsonProperty("isoCountryCode") final String isoCountryCode,
                   @JsonProperty("country") final String name)
    {
        iIsoCountryCode = isoCountryCode;
        iName = name;
    }

    public String getIsoCountryCode()
    {
        return iIsoCountryCode;
    }

    public String getName()
    {
        return iName;
    }
}
