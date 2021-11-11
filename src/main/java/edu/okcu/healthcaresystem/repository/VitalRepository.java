package edu.okcu.healthcaresystem.repository;

import edu.okcu.healthcaresystem.models.Visit;
import edu.okcu.healthcaresystem.models.Vital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VitalRepository extends JpaRepository<Vital, Long> {

    @Query(value = "SELECT * FROM Vital v WHERE v.userID = ?1", nativeQuery = true)
    List<Vital> findAllByUserID(Long userID);
}
