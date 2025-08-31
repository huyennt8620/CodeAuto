import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class ApiLogin {

    private static final String RETAILER_CODE = "hotelz16";
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "123";

    public static String getToken() {
        Response response = given()
                .queryParam("provider", "credentials")
                .formParam("retailer", RETAILER_CODE)
                .formParam("username", USERNAME)
                .formParam("password", PASSWORD)
                .post(Config.AUTH_URL + "/auth"); // Gọi post đến URL đầy đủ

        response.then().statusCode(200);

        String token = response.jsonPath().getString("BearerToken");

        if (token == null || token.isEmpty()) {
            throw new RuntimeException("Login failed: token not found in response");
        }

        return "Bearer " + token;
    }
}