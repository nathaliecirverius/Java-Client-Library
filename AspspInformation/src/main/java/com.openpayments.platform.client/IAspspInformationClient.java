package com.openpayments.platform.client;

import jsonhandler.Aspsps;
import jsonhandler.Cities;
import jsonhandler.Countries;

import java.io.IOException;

public interface IAspspInformationClient
{
    Countries getCountries() throws IOException;
    Cities getCities(final String isoCountryCode) throws IOException;
    Aspsps getAspsps(final String isoCountryCode, final String cityID) throws IOException;
}
