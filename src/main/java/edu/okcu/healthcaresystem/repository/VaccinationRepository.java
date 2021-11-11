package edu.okcu.healthcaresystem.repository;

import edu.okcu.healthcaresystem.models.Vaccination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VaccinationRepository extends JpaRepository<Vaccination, Long> {
    @Query(value = "SELECT * FROM Vaccination v WHERE v.userID = ?1", nativeQuery = true)
    List<Vaccination> findAllByUserID(Long userID);
}
