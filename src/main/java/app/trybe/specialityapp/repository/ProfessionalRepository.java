package app.trybe.specialityapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import app.trybe.specialityapp.model.Professional;

/**
 * Repository.
 */
@Repository
public interface ProfessionalRepository extends JpaRepository<Professional, Integer> {

}

