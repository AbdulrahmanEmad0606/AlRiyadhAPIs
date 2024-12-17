package Services;

import Data.CommercialContainers.RequestDataForReportInDashBoard;
import Data.CommercialContainers.ResponseDataForDashBoard;
import io.restassured.response.Response;

import java.util.List;

import static io.restassured.RestAssured.given;

public class CommercialContainersReports extends GenericRequest {
    public CommercialContainersReports() {
        super("API/api/RiyadhReports/CommercialContainersReport");
    }
    public static RequestDataForReportInDashBoard setBodyForCommercialContainers() {
        return new RequestDataForReportInDashBoard(
                "", new int[]{}, new int[]{}, new int[]{}, new int[]{}, new int[]{}, new int[]{}, new int[]{}, new String[]{}, new String[]{}, new String[]{}, new int[]{}, "", "", "", ""
        );
    }
    public static RequestDataForReportInDashBoard filterByUnitName() {
        return new RequestDataForReportInDashBoard(
                "", new int[]{1076}, new int[]{}, new int[]{}, new int[]{}, new int[]{}, new int[]{}, new int[]{}, new String[]{}, new String[]{}, new String[]{}, new int[]{}, "", "", "", ""
        );
    }













    public Response callWithPagination(String accessToken, int pageIndex) {
        return given()
                .headers(setHeaders(accessToken))
                .baseUri(baseURI)
                .queryParam("pageSize", 10)
                .queryParam("pageIndex", pageIndex)
                .queryParam("sortKey", "submitDate_desc")
                .basePath(endpoint)
                .body(setBodyForCommercialContainers())
                .post();
    }
    public int getLastPageIndex(Response initialResponse) {
        List<ResponseDataForDashBoard.ReportData> reportDataList1 = initialResponse.as(ResponseDataForDashBoard.class).data.reportData;
        int totalCount =  reportDataList1.size();

        // Calculate the last page index
        int pageSize = 10; // Assuming page size is 10
        int lastPageIndex = (int) Math.ceil((double) totalCount / pageSize)-1;

        System.out.println(lastPageIndex + " "+ (int) Math.ceil((double) totalCount ));
        return lastPageIndex;

    }
    public int getLastPageSize(Response lastPageResponse){
       // Response lastPageResponse = this.callWithPagination(accessToken,);
        List<ResponseDataForDashBoard.ReportData> reportDataList2 = lastPageResponse.as(ResponseDataForDashBoard.class).data.reportData;
        return reportDataList2.size();
    }


}