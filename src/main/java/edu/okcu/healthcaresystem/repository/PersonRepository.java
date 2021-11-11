package edu.okcu.healthcaresystem.repository;

import edu.okcu.healthcaresystem.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface PersonRepository extends JpaRepository<Person, Long> {
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO Person VALUES(?1, ?2, ?3, ?4, ?5)", nativeQuery = true)
    void insert(Long userID, String dob, String gender, String allergies, String insuranceInfo);

    @Transactional
    @Modifying
    @Query(value = "UPDATE Person p SET p.fName = ?1, p.lName= ?2, p.phoneNumber = ?3, p.address = ?4  where p.userID = ?5", nativeQuery = true)
    void updatePerson(String fName, String lName, String phoneNumber, String Address, Long userID);

    @Query(value = "SELECT p FROM Person p WHERE p.userID = ?1")
    Person findByUserID(Long userID);
}
