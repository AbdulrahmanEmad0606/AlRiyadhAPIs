package CommercialContainers;

import MainRequests.RequestSetup;
import Services.CommercialContainersReports;
import org.testng.annotations.Test;

public class FilterTCs extends RequestSetup {
    final CommercialContainersReports reports = new CommercialContainersReports();
    @Test
    public void checkFilterByUnitName() {
        reports.makeApiCallWithFilter(accessToken).then().assertThat().statusCode(200).extract().response().prettyPrint();

    }
}
