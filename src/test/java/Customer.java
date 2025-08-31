import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {
    private int BranchId;
    private boolean IsActive;
    private String OldAddress;
    private int Type;
    private String temploc;
    private String tempw;
    private int Gender;
    private String Name;
    private String LocationName;
    private String WardName;
    private List<String> CustomerGroupDetails;
    private int RetailerId;
    private String Uuid;
    private String ModifiedDate;
}
