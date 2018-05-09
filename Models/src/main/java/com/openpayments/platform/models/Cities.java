package com.openpayments.platform.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Class representation of Json "Cities" object (List of all cities in given country).
 */
public class Cities
{
    private final List<City> iCityList;
    private final String iTime;

    public Cities(@JsonProperty("data") final List<City> cityList,
                  @JsonProperty("time") final String time)
    {
        iCityList = cityList;
        iTime = time;
    }

    public List<City> getCityList()
    {
        return iCityList;
    }

    public String getTime()
    {
        return iTime;
    }
}
