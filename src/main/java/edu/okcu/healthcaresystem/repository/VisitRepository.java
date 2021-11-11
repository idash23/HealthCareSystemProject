package edu.okcu.healthcaresystem.repository;

import edu.okcu.healthcaresystem.models.Doctor;
import edu.okcu.healthcaresystem.models.Patient;
import edu.okcu.healthcaresystem.models.Visit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface VisitRepository extends JpaRepository<Visit, Long> {

    @Query("SELECT v FROM Visit v WHERE v.userID = ?1")
    Visit findByUserID(Long userID);

    @Transactional
    @Modifying
    @Query(value = "UPDATE Visit v SET v.userID = ?1, v.reason = ?2, v.date = ?3, v.note = ?4 where v.visitID = ?5", nativeQuery = true)
    void updateVisit(Long userID, String reason, String date, String note, Long visitID);

    @Query(value = "SELECT * FROM Visit v WHERE v.userID = ?1", nativeQuery = true)
    List<Visit> findAllByUserID(Long userID);
}
