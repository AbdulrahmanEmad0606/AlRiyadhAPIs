package Services;

import Data.CommercialContainers.ResponseDataForDashBoard;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;

public class CommercialContainersReports extends GenericRequest {
    public CommercialContainersReports() {
        super("API/api/RiyadhReports/CommercialContainersReport");
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