import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import java.nio.charset.StandardCharsets;

public class CustomerApi {
    private static final ObjectMapper mapper = new ObjectMapper();
    public static Response addCustomer(Customer customer) {
        try {
            String customerJson = mapper.writeValueAsString(customer);
            RestAssured.baseURI = Config.BASE_URL;
            //String metadataJson = "{ \"FullAddress\":\"\" }";

            return given()
                    .header("authorization", Config.token)
                    .header("branchid", Config.BRANCH_ID)
                    .header("retailer", Config.RETAILER_CODE)
                    .header("x-retailer-code", Config.RETAILER_CODE)
                    .header("x-retailer-id", Config.RETAILER_ID)
                    .contentType(ContentType.MULTIPART)
                    .multiPart("Customer", customerJson.getBytes(StandardCharsets.UTF_8), "application/json")
                    //.multiPart("Metadata", metadataJson.getBytes(StandardCharsets.UTF_8), "application/json")
                    .when()
                    .post("/api/customers")
                    .then()
                    .log().all()
                    .extract().response();

        } catch (Exception e) {
            throw new RuntimeException("Error while serializing Customer object", e);
        }
    }
}
