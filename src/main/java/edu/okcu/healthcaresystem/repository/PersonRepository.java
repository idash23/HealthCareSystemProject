package edu.okcu.healthcaresystem.repository;

import edu.okcu.healthcaresystem.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface PersonRepository extends JpaRepository<Person, Long> {
    @Transactional
    @Modifying
    @Query("UPDATE Person p SET p.DOB = ?1, p.fName = ?2, p.mName = ?3, p.lName= ?4, p.gender = ?5  where p.userID = ?6")
    void updatePerson(String DOB, String fName, String mName, String lName, String gender, Long userID);
}
