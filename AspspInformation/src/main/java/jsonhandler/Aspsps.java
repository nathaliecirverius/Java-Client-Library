package jsonhandler;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Class representation of Json "Aspsps" object (List of all banks in given city).
 */
public class Aspsps
{
    private final List<Aspsp> iAspsps;
    private final String iTime;

    public Aspsps(@JsonProperty("data") final List<Aspsp> bankList,
                  @JsonProperty("time") final String time)
    {
        iAspsps = bankList;
        iTime = time;
    }

    public List<Aspsp> getAspsps()
    {
        return iAspsps;
    }

    public String getTime()
    {
        return iTime;
    }
}
