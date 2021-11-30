package edu.okcu.healthcaresystem.repository;

import edu.okcu.healthcaresystem.models.DocPat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DocPatRepository extends JpaRepository<DocPat, Long> {

    @Query("SELECT d.patID FROM DocPat d WHERE d.docID = ?1")
    long[] findPatientID(long userID);
}
