package Data.CommercialContainers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class KPISResponseData {

    @JsonProperty("Data")
    public Data data;
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Data{
        public int NumberOfStreets;
        public int NumberOfCommercialContainers;
        public int NumberOfCommercialWasteContainers;
        public int NumberOfCommercialRestorationContainers;
        public int NumberOfViolationsForServiceProvider;
    }



}

