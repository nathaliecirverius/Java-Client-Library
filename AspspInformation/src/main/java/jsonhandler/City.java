package jsonhandler;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Class representation of Json "City" object.
 */
public class City
{
    private final String iId;
    private final String iName;

    public City(@JsonProperty("id") final String id,
                @JsonProperty("city") final String name)
    {
        iId = id;
        iName = name;
    }

    public String getId()
    {
        return iId;
    }

    public String getName()
    {
        return iName;
    }
}
