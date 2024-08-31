package MainRequests;


import io.restassured.http.ContentType;

public class PostRequest extends Request {
    public PostRequest(String endPoint) {
        super(endPoint);
    }
    public void setContentType(){
        requestSpecification.contentType(ContentType.JSON);
    }
    public void setRequestBody(String requestBody){
        requestSpecification.body(requestBody);
    }
}
