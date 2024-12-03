package MainRequests;

import Data.CommercialContainers.UserData;
import Services.GenericRequest;
import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class RequestSetup {
    GenericRequest genericRequest = new GenericRequest("API/token");
    protected String accessToken=genericRequest.accessToken;
    UserData userData = new UserData();

    @BeforeTest
    protected void login() {
        Response response = given()
                .headers(Map.of(
                        "Allow-Headers", "Authorization, Content-Type, Allow-Origin",
                        "Enabled", "true",
                        "DNT", "1",
                        "User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/126.0.0.0 Safari/537.36",
                        "Authorization", "bearer undefined",
                        "Allow-Origin", "*",
                        "Content-Type", "application/json",
                        "Accept", "application/json",
                        "Referer", "http://yxdemo.eastus.cloudapp.azure.com/CHECK/Demo/AlRiyadh/Site/login?prevUrl=home"
                ))
                .baseUri(genericRequest.baseURI)
                .basePath(genericRequest.endpoint)
                .body("username=" + userData.username + "&password=" + userData.password + "&grant_type=password")
                .post();

        accessToken = response.jsonPath().getString("access_token");
          }
}