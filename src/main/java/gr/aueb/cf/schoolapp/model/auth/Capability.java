package gr.aueb.cf.schoolapp.model.auth;

import jakarta.persistence.*;
import jdk.jfr.SettingDefinition;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "capabilities")
public class Capability {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;
    private String description;

    @ManyToMany(mappedBy = "capabilities", fetch = FetchType.EAGER)
    private Set<Role> roles = new HashSet<>();

    // Helper Methods
    public void addRole(Role role) {
        this.roles.add(role);
        role.getCapabilities().add(this);
    }

    public void removeRole(Role role) {
        this.roles.remove(role);
        role.getCapabilities().remove(this);
    }
}
