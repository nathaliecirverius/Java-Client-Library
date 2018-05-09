package com.openpayments.platform.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Class representation of Json "Countries" object (List of all countries).
 */
public class Countries
{
    private final List<Country> iCountryList;
    private final String iTime;

    public Countries(@JsonProperty("data") final List<Country> countryList,
                     @JsonProperty("time") final String time)
    {
        iCountryList = countryList;
        iTime = time;
    }

    public List<Country> getCountryList()
    {
        return iCountryList;
    }

    public String getTime()
    {
        return iTime;
    }
}
