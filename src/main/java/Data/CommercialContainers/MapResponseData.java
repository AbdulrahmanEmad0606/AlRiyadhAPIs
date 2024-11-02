package Data.CommercialContainers;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Date;

public class MapResponseData {
    public class Data{
        @JsonProperty("PageIndex")
        public int pageIndex;
        @JsonProperty("TotalCount")
        public int totalCount;
        @JsonProperty("ReportData")
        public ArrayList<ReportDatum> reportData;
    }

    public class ReportDatum{
        @JsonProperty("Latitude")
        public String latitude;
        @JsonProperty("Longitude")
        public String longitude;
        @JsonProperty("EventId")
        public int eventId;
        @JsonProperty("EventNo")
        public String eventNo;
        @JsonProperty("CampaignId")
        public Object campaignId;
        @JsonProperty("CampaignName")
        public Object campaignName;
        @JsonProperty("SupervisorId")
        public Object supervisorId;
        @JsonProperty("SupervisorName")
        public Object supervisorName;
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
