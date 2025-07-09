package gr.aueb.cf.schoolapp.model;

import gr.aueb.cf.schoolapp.model.static_data.Region;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "teachers")
public class Teacher extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String uuid;

    @Column(unique = true)
    private String vat;

    private String firstname;
    private String lastname;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id")
    private Region region;

    @PrePersist
    public void initializeUUID() {
        if (uuid == null) uuid = UUID.randomUUID().toString();
    }
}
