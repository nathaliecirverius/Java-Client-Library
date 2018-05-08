package com.openpayments.platform.client;

import com.openpayments.platform.models.Aspsps;
import com.openpayments.platform.models.Cities;
import com.openpayments.platform.models.Countries;

import java.io.IOException;

public interface IAspspInformationClient
{
    Countries getCountries() throws IOException;
    Cities getCities(final String isoCountryCode) throws IOException;
    Aspsps getAspsps(final String isoCountryCode, final String cityID) throws IOException;
}
