import com.github.javafaker.Faker;

import java.util.Locale;
import java.util.UUID;

public class FakeData {
    public static Faker faker = new Faker(new Locale("vi"));

    public static String randomName(){
        return faker.name().fullName();
    }

    public static String randomEmail(){
        return faker.internet().emailAddress();
    }

    public static String randomUuid() {
        return UUID.randomUUID().toString();
    }
}
