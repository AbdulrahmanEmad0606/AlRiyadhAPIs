package Data.CommercialContainers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class KPISResponseData {

    public Data Data;
    public class Data{
        public int NumberOfStreets;
        public int NumberOfCommercialContainers;
        public int NumberOfCommercialWasteContainers;
        public int NumberOfCommercialRestorationContainers;
        public int NumberOfViolationsForServiceProvider;

    }


}

