package thurtimous.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@NoArgsConstructor
@Data
public class Asset extends ThurtimousEntity {


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
                "id=" + super.getId() +
                ", text='" + text + '\'' +
                '}';
    }
}

