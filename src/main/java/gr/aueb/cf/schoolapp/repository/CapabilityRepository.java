package gr.aueb.cf.schoolapp.repository;

import gr.aueb.cf.schoolapp.model.auth.Capability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CapabilityRepository extends JpaRepository<Capability, Long> {
}
