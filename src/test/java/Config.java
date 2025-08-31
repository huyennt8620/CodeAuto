import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.config.RestAssuredConfig;

public class Config {
    public static String token;

    public static final String BASE_URL = "https://hotel.kiotviet.vn";
    public static final String AUTH_URL = "https://api-mobile-hotel.kiotviet.vn";

    public static final int BRANCH_ID = 309;
    public static final int RETAILER_ID = 200031628;
    public static final String RETAILER_CODE = "hotelz16";

    static {
        // Lấy token từ API xác thực
        token = ApiLogin.getToken();

        // Cấu hình RestAssured để xử lý ký tự tiếng Việt (UTF-8)
        RestAssured.config = RestAssuredConfig.config()
                .encoderConfig(EncoderConfig.encoderConfig()
                        .defaultContentCharset("UTF-8"));
    }
}