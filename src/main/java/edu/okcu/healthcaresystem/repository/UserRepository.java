package edu.okcu.healthcaresystem.repository;

import edu.okcu.healthcaresystem.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE u.email = ?1 AND u.password = ?2")
    User findByEmailAndPassword(String email, String password);

    @Query("SELECT u.userType FROM User u WHERE u.email = ?1")
    String findUserType(String email);
}
