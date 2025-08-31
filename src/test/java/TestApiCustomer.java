import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Collections;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class TestApiCustomer {

    @Test
    public void testAddCustomer() {
        Customer customer = Customer.builder()
                .BranchId(Config.BRANCH_ID)
                .IsActive(true)
                .OldAddress("")
                .Type(0)
                .temploc("")
                .tempw("")
                .Gender(1)
                .Name(FakeData.randomName())
                .LocationName("")
                .WardName("")
                .CustomerGroupDetails(Collections.emptyList())
                .RetailerId(Config.RETAILER_ID)
                .Uuid(FakeData.randomUuid())
                .ModifiedDate(LocalDateTime.now().toString())
                .build();

        Response response = CustomerApi.addCustomer(customer);

        response.prettyPrint();

        assertThat(response.getStatusCode(), is(200));
        assertThat(response.jsonPath().getString("Name"), equalTo(customer.getName()));
    }
}
