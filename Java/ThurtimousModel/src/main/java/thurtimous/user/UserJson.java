package thurtimous.user;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import thurtimous.assets.Asset;
import java.util.List;



@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserJson {

    private final long id;
    private final String firstName;
    private final String middleName;
    private final String lastName;
    private final List<Asset> assets;


    public UserJson(User user, List<Asset> assets) {
        this.id = user.getId();
        this.firstName = user.getFirstName();
        this.middleName = user.getMiddleName();
        this.lastName = user.getLastName();
        this.assets = assets;
    }


    public UserJson(User user) {
        this(user, null);
    }
}
