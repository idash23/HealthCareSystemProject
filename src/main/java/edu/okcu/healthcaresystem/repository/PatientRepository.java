package edu.okcu.healthcaresystem.repository;

import edu.okcu.healthcaresystem.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    @Transactional
    @Modifying
    @Query(value = "UPDATE Patient p SET p.DOB = ?1, p.gender = ?2, p.allergies = ?3, p.insuranceInfo= ?4 where p.userID = ?5", nativeQuery = true)
    void updatePatient(String dob, String gender, String allergies, String insuranceInfo, Long userID);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO Patient VALUES(?1, ?2, ?3, ?4, ?5)", nativeQuery = true)
    void insert(Long userID, String dob, String gender, String allergies, String insuranceInfo);

    @Query("SELECT d FROM Patient d WHERE d.fName LIKE %:keyword% OR d.lName LIKE  %:keyword%")
    List<Patient> findByKeyword(@Param("keyword") String keyword);

    @Query("SELECT d FROM Patient d WHERE d.userID=?2 AND (d.fName LIKE %?1% OR d.lName LIKE  %?1%)")
    Patient findMyPatientByKeyword(String keyword, long userID);

    @Query("SELECT p FROM Patient p WHERE p.userID = ?1")
    Patient findByUserID(Long userID);

    @Query("SELECT p.gender FROM Patient p WHERE p.userID = ?1")
    String getGender(Long userID);

    @Query("SELECT p.DOB FROM Patient p WHERE p.userID = ?1")
    String getDOB(Long userID);

    @Query("SELECT p.allergies FROM Patient p WHERE p.userID = ?1")
    String getAllergies(Long userID);

    @Query("SELECT p.insuranceInfo FROM Patient p WHERE p.userID = ?1")
    String getInsurance(Long userID);
}
