package Data.CommercialContainers;

import com.fasterxml.jackson.annotation.JsonProperty;

public class KPISResponseData {
        public int numberOfStreets;
        public int numberOfCommercialContainers;
        public int numberOfCommercialWasteContainers;
        public int numberOfCommercialRestorationContainers;
        public int numberOfViolationsForServiceProvider;

        public int getNumberOfStreets() {
            return numberOfStreets;
        }

        public void setNumberOfStreets(int numberOfStreets) {
            this.numberOfStreets = numberOfStreets;
        }

        public int getNumberOfCommercialContainers() {
            return numberOfCommercialContainers;
        }

        public void setNumberOfCommercialContainers(int numberOfCommercialContainers) {
            this.numberOfCommercialContainers = numberOfCommercialContainers;
        }

        public int getNumberOfCommercialWasteContainers() {
            return numberOfCommercialWasteContainers;
        }

        public void setNumberOfCommercialWasteContainers(int numberOfCommercialWasteContainers) {
            this.numberOfCommercialWasteContainers = numberOfCommercialWasteContainers;
        }

        public int getNumberOfCommercialRestorationContainers() {
            return numberOfCommercialRestorationContainers;
        }

        public void setNumberOfCommercialRestorationContainers(int numberOfCommercialRestorationContainers) {
            this.numberOfCommercialRestorationContainers = numberOfCommercialRestorationContainers;
        }

        public int getNumberOfViolationsForServiceProvider() {
            return numberOfViolationsForServiceProvider;
        }

        public void setNumberOfViolationsForServiceProvider(int numberOfViolationsForServiceProvider) {
            this.numberOfViolationsForServiceProvider = numberOfViolationsForServiceProvider;
        }
    }

