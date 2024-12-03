package Data.CommercialContainers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RequestDataForReportInDashBoard {

    public String SearchString;
    public int[] UnitIds;
    public int[] CampaignIds;
    public int[] MunicipalityIds;
    public int[] DistrictIds;
    public int[] StreetIds;
    public int[] MajorStatusIds;
    public int[] EventStatusIds;
    public String[] SubFactorIds;
    public String[] ServiceProviderIds;
    public String[] ContainerTypeIds;
    public int[] ReporterIds;
    public String LastUpdateDateFrom;
    public String LastUpdateDateTo;
    public String SubmitionDateFrom;
    public String SubmitionDateTo;

    public RequestDataForReportInDashBoard
            (String searchString,
             int[] unitIds,
             int[] campaignIds,
             int[] municipalityIds,
             int[] districtIds,
             int[] streetIds,
             int[] majorStatusIds,
             int[] eventStatusIds,
             String[] subFactorIds,
             String[] serviceProviderIds,
             String[] containerTypeIds,
             int[] reporterIds,
             String lastUpdateDateFrom,
             String lastUpdateDateTo,
             String submitionDateFrom,
             String submitionDateTo) {
        SearchString = searchString;
        UnitIds = unitIds;
        CampaignIds = campaignIds;
        MunicipalityIds = municipalityIds;
        DistrictIds = districtIds;
        StreetIds = streetIds;
        MajorStatusIds = majorStatusIds;
        EventStatusIds = eventStatusIds;
        SubFactorIds = subFactorIds;
        ServiceProviderIds = serviceProviderIds;
        ContainerTypeIds = containerTypeIds;
        ReporterIds = reporterIds;
        LastUpdateDateFrom = lastUpdateDateFrom;
        LastUpdateDateTo = lastUpdateDateTo;
        SubmitionDateFrom = submitionDateFrom;
        SubmitionDateTo = submitionDateTo;
    }
}