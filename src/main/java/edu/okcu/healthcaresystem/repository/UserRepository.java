package edu.okcu.healthcaresystem.repository;

import edu.okcu.healthcaresystem.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE u.email = ?1")
    User findByEmail(String email);

    @Query("SELECT u FROM User u WHERE u.email = ?1 AND u.password = ?2")
    User findByEmailAndPassword(String email, String password);

    @Query("SELECT u.personType FROM User u WHERE u.email = ?1")
    String findUserTypeByEmail(String email);

    @Query("SELECT u.personType FROM User u WHERE u.userID = ?1")
    String findUserTypeByID(Long id);

    @Query("SELECT u.userID FROM User u WHERE u.email = ?1")
    Long findUserID(String email);

    @Query("SELECT u FROM User u WHERE u.userID = ?1")
    User findByUserID(Long userID);

    @Query("SELECT u.userID FROM User u WHERE u.personType='doctor'")
    List<Long> findDoctorID();
}


