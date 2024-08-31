package Data.Lighting;

public class ReportData2 {
    public String SearchString;
    public int[] UnitIds;
    public int[] CampaignIds;
    public int[] MunicipalityIds;
    public int[] DistrictIds;
    public int[] StreetIds;
    public int[] MajorStatusIds;
    public int[] EventStatusIds;
    public int[] ReporterIds;
    public String LastUpdateDateFrom;
    public String LastUpdateDateTo;
    public String SubmitionDateFrom;
    public String SubmitionDateTo;
    public String ProcessingDateFrom;
    public String ProcessingDateTo;

    public ReportData2(
            String searchString,
            int[] unitIds,
            int[] campaignIds,
            int[] municipalityIds,
            int[] districtIds,
            int[] streetIds,
            int[] majorStatusIds,
            int[] eventStatusIds,
            int[] reporterIds,
            String lastUpdateDateFrom,
            String lastUpdateDateTo,
            String submitionDateFrom,
            String submitionDateTo,
            String processingDateFrom,
            String processingDateTo) {
        SearchString = searchString;
        UnitIds = unitIds;
        CampaignIds = campaignIds;
        MunicipalityIds = municipalityIds;
        DistrictIds = districtIds;
        StreetIds = streetIds;
        MajorStatusIds = majorStatusIds;
        EventStatusIds = eventStatusIds;
        ReporterIds = reporterIds;
        LastUpdateDateFrom = lastUpdateDateFrom;
        LastUpdateDateTo = lastUpdateDateTo;
        SubmitionDateFrom = submitionDateFrom;
        SubmitionDateTo = submitionDateTo;
        ProcessingDateFrom = processingDateFrom;
        ProcessingDateTo = processingDateTo;
    }
}




