package Data.CommercialContainers;

import com.fasterxml.jackson.annotation.JsonProperty;

public class KPISResponseData {
    public Data data;
    public class Data{
        @JsonProperty("NumberOfStreets")
        public int numberOfStreets;
        @JsonProperty("NumberOfCommercialContainers")
        public int numberOfCommercialContainers;
        @JsonProperty("NumberOfCommercialWasteContainers")
        public int numberOfCommercialWasteContainers;
        @JsonProperty("NumberOfCommercialRestorationContainers")
        public int numberOfCommercialRestorationContainers;
        @JsonProperty("NumberOfViolationsForServiceProvider")
        public int numberOfViolationsForServiceProvider;
    }


}

