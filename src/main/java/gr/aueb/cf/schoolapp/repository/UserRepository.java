package gr.aueb.cf.schoolapp.repository;

//import gr.aueb.cf.schoolapp.core.enums.Role;
import gr.aueb.cf.schoolapp.model.User;
import gr.aueb.cf.schoolapp.model.auth.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByRole(Role role);
    Optional<User> findByUsername(String username);
}
