package Services;

import Data.CommercialContainers.RequstDataForGenericReports;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class GeneralReports extends GenericRequest {
    public GeneralReports() {
        super("API/api/Event/GetReports");
    }

    public Response makeApiCallWithFilter(String accessToken) {
        return given()
                .headers(setHeaders(accessToken))
                .baseUri(baseURI)
                .queryParam("pageSize", 5000)
                .basePath(endpoint)
                .body(setBodyForGenericReports())
                .post();
    }
    RequstDataForGenericReports setBodyForGenericReports() {
        return new RequstDataForGenericReports(
                null, "date_desc", 0, 1000, 5422, null, 0, 3, null, null, new int[]{1038}, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, -180
        );
    }
}
