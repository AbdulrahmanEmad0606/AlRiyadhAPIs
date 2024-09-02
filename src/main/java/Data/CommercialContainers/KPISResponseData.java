package Data.CommercialContainers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class KPISResponseData {
    public Data data;
    public class Data{
        public int numberOfStreets;
        public int numberOfCommercialContainers;
        public int numberOfCommercialWasteContainers;
        public int numberOfCommercialRestorationContainers;
        public int numberOfViolationsForServiceProvider;

    }


}

