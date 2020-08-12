package thurtimous.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@NoArgsConstructor
@Data
public class Receipt extends ThurtimousEntity {

    @Column(length = 500)
    private String link_to_picture;
    @Column(length = 500)
    private String link_to_receipt_site;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private User owner;

    public Receipt(String link_to_picture, String link_to_receipt_site, User owner) {
        this.link_to_picture = link_to_picture;
        this.link_to_receipt_site = link_to_receipt_site;
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Asset{" +
                "id=" + super.getId() +
                ", link_to_picture='" + link_to_picture + ", link_to_receipt_site='" + link_to_receipt_site + '\'' +
                '}';
    }

}
