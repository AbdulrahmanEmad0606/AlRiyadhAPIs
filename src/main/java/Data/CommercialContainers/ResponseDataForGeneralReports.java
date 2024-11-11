package Data.CommercialContainers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseDataForGeneralReports {
    @JsonProperty("Data")
    public Data Data;
    @JsonIgnoreProperties(ignoreUnknown = true)
    public class Data{
        @JsonProperty("EventsCount")
        public int eventsCount;
    }
    }

