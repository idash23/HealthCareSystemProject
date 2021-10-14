package edu.okcu.healthcaresystem.repository;

import edu.okcu.healthcaresystem.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}