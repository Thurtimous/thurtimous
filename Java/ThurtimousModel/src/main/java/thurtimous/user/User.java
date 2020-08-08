package thurtimous.user;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import thurtimous.assets.Asset;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static org.apache.commons.lang3.StringUtils.capitalize;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {

    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    long id;


    @Column(length = 32)
    private String firstName;
    @Column(length = 32)
    private String middleName;
    @Column(length = 64)
    private String lastName;


    @OneToMany(
            mappedBy = "owner",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Asset> assets = new ArrayList<>();



    public User(String firstName, String middleName, String lastName) {
        this.firstName = capitalize(firstName);
        this.middleName = capitalize(middleName);
        this.lastName = capitalize(lastName);
    }

    public User(String firstName, String LastName){
        this(firstName, null, LastName);
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
