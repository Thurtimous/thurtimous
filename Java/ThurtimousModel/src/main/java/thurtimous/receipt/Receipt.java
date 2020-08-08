package thurtimous.receipt;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import thurtimous.user.User;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
public class Receipt {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @Column(length = 500)
    private String link_to_picture;
    @Column(length = 500)
    private String link_to_receipt_site;

    @JsonIgnore
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
                "id=" + id +
                ", link_to_picture='" + link_to_picture + ", link_to_receipt_site='" + link_to_receipt_site + '\'' +
                '}';
    }

}
