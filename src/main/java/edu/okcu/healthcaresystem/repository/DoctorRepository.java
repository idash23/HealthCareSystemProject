package edu.okcu.healthcaresystem.repository;

import edu.okcu.healthcaresystem.models.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface DoctorRepository extends JpaRepository<Doctor, Long> {


    @Transactional
    @Modifying
    @Query("UPDATE Doctor d SET d.DOB = ?1, d.fName = ?2, d.mName = ?3, d.lName= ?4, d.gender = ?5  where d.email = ?6")
    void updateDoctor(String DOB, String fName, String mName, String lName, String gender, String email);

    @Query(value = "select * from Doctor d where d.fName like %:keyword% or d.lName like  %:keyword%" , nativeQuery = true)
    List<Doctor> findByKeyword(@Param("keyword") String keyword);




    }


