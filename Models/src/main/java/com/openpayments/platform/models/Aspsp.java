package com.openpayments.platform.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Class representation of Json "Aspsp" object (a bank).
 */
public class Aspsp
{
    private final String iId;
    private final String iBicFi;
    private final String iCompanyId;
    private final String iName;
    private final String iPhone;
    private final List<PostalAddress> iPostalAddressList;
    private final String iWebsiteUrl;
    private final String iLogoUrl;

    public Aspsp(@JsonProperty("id") final String id,
                 @JsonProperty("bicFi") final String bicFi,
                 @JsonProperty("companyId") final String companyId,
                 @JsonProperty("name") final String name,
                 @JsonProperty("phone") final String phone,
                 @JsonProperty("postalAddress") final List<PostalAddress> postalAddressList,
                 @JsonProperty("websiteUrl") final String websiteUrl,
                 @JsonProperty("logoUrl") final String logoUrl)
    {
        iId = id;
        iBicFi = bicFi;
        iCompanyId = companyId;
        iName = name;
        iPhone = phone;
        iPostalAddressList = postalAddressList;
        iWebsiteUrl = websiteUrl;
        iLogoUrl = logoUrl;
    }

    public String getId()
    {
        return iId;
    }

    public String getBicFi()
    {
        return iBicFi;
    }

    public String getCompanyId()
    {
        return iCompanyId;
    }

    public String getName()
    {
        return iName;
    }

    public String getPhone()
    {
        return iPhone;
    }

    public List<PostalAddress> getPostalAddressList()
    {
        return iPostalAddressList;
    }

    public String getWebsiteUrl()
    {
        return iWebsiteUrl;
    }

    public String getLogoUrl()
    {
        return iLogoUrl;
    }

    @Override
    public String toString()
    {
        return  "Id: " + iId + "\n" +
                "BicFi: " + iBicFi + "\n" +
                "CompanyId: " + iCompanyId + "\n" +
                "Name: " + iName + "\n" +
                "Phone: " + iPhone + "\n" +
                "PostalAddress: " + iPostalAddressList + "\n" +
                "WebsiteUrl: " + iWebsiteUrl + "\n" +
                "LogoUrl: " + iLogoUrl;
    }
}
