package Data.CommercialContainers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseDataForDashBoard {

    @JsonProperty("Data")
    public Data data;

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Data {
        @JsonProperty("PageIndex")
        public int pageIndex;

        @JsonProperty("TotalCount")
        public int totalCount;

        @JsonProperty("ReportData")
        public ArrayList<ReportData> reportData;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ReportData {
        @JsonProperty("UnitId")
        public int unitId;

        @JsonProperty("UnitName")
        public String unitName;

        @JsonProperty("SubFactorId")
        public String subFactorId;

        @JsonProperty("SubFactorName")
        public String subFactorName;

        @JsonProperty("MainFactorId")
        public String mainFactorId;

        @JsonProperty("MainFactorName")
        public String mainFactorName;

        @JsonProperty("MunicipalityId")
        public int municipalityId;

        @JsonProperty("MunicipalityName")
        public String municipalityName;

        @JsonProperty("DistrictId")
        public int districtId;

        @JsonProperty("DistrictName")
        public String districtName;

        @JsonProperty("StreetId")
        public int streetId;

        @JsonProperty("StreetName")
        public String streetName;

        @JsonProperty("ServiceProviderId")
        public String serviceProviderId;

        @JsonProperty("ServiceProviderName")
        public String serviceProviderName;

        @JsonProperty("ContainerTypeId")
        public String containerTypeId;

        @JsonProperty("ContainerTypeName")
        public String   containerTypeName;

        @JsonProperty("ProcessingOwnerId")
        public Object processingOwnerId;

        @JsonProperty("ProcessingOwner")
        public Object processingOwner;

        @JsonProperty("ProcessingDate")
        public Object processingDate;

        @JsonProperty("LastUpdateDate")
        public Date lastUpdateDate;

        @JsonProperty("ClosedDate")
        public Date closedDate;

        @JsonProperty("EventId")
        public int eventId;

        @JsonProperty("EventNo")
        public String eventNo;

        @JsonProperty("CampaignId")
        public int campaignId;

        @JsonProperty("CampaignName")
        public Object campaignName;

        @JsonProperty("SupervisorId")
        public int supervisorId;

        @JsonProperty("SupervisorName")
        public String supervisorName;

        @JsonProperty("ReporterId")
        public int reporterId;

        @JsonProperty("ReporterName")
        public String reporterName;

        @JsonProperty("SubmitionDate")
        public Date submitionDate;

        @JsonProperty("MajorStatusId")
        public int majorStatusId;

        @JsonProperty("MajorStatusName")
        public String majorStatusName;

        @JsonProperty("EventStatusId")
        public int eventStatusId;

        @JsonProperty("EventStatusName")
        public String eventStatusName;
    }
}
