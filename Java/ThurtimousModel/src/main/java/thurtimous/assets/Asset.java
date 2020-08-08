package thurtimous.assets;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import thurtimous.user.User;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
public class Asset {

    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private User owner;

    private String text;

    public Asset(String text, User owner) {
        this.text = text;
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Asset{" +
                "id=" + id +
                ", text='" + text + '\'' +
                '}';
    }
}

