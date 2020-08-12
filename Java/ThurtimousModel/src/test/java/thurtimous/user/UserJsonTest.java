package thurtimous.user;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;


class UserJsonTest {

    /*
    @Test
    public void createBuilderWithNull() {
        Assertions.assertThrows(NullPointerException.class, () -> UserDto.getUserBuilder(null));
    }


    @Test
    public void createBuilder() {
        UserDto userJson = UserDto.getUserBuilder(new User("erling", "Nikolai", "Ukkelberg")).build();
        Assertions.assertEquals("Erling", userJson.getFirstName());
        Assertions.assertEquals("Nikolai", userJson.getMiddleName());
        Assertions.assertEquals("Ukkelberg", userJson.getLastName());
    }

    @Test
    public void createBuilderWithAssets() {
        UserDto.UserJsonBuilder userBuilder = UserDto.getUserBuilder(new User("erling", "Nikolai", "Ukkelberg"));
        userBuilder.assets(new ArrayList<>());
        UserDto userJson = userBuilder.build();
        Assertions.assertEquals("Erling", userJson.getFirstName());
        Assertions.assertEquals("Nikolai", userJson.getMiddleName());
        Assertions.assertEquals("Ukkelberg", userJson.getLastName());
    }
*/
}