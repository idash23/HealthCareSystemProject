package edu.okcu.healthcaresystem.repository;

import edu.okcu.healthcaresystem.models.Doctor;
import edu.okcu.healthcaresystem.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    @Query("SELECT d FROM Patient d WHERE d.fName LIKE %:keyword% OR d.lName LIKE  %:keyword%")
    List<Patient> findByKeyword(@Param("keyword") String keyword);
}
