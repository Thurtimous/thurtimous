package thurtimous.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class UserDto extends ThurtimousDto{
    private String firstName;
    private String middleName;
    private String lastName;
}
