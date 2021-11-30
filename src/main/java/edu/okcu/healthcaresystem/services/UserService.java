package edu.okcu.healthcaresystem.services;

import edu.okcu.healthcaresystem.models.Doctor;
import edu.okcu.healthcaresystem.models.Person;
import edu.okcu.healthcaresystem.models.User;
import edu.okcu.healthcaresystem.repository.DoctorRepository;
import edu.okcu.healthcaresystem.repository.PersonRepository;
import edu.okcu.healthcaresystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.ZonedDateTime;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private PersonRepository personRepo;


    public User login(String email, String password) {
        //User user = repo.findByEmailAndPassword(email, password);
        User user = repo.findByEmail(email);
        String hashedPassword = user.getPassword();
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        if(passwordEncoder.matches(password, hashedPassword)){
            return user;
        }else{
            return null;
        }

    }

    public String userTypeByEmail(String email) {
        String userType = repo.findUserTypeByEmail(email);
        return userType;
    }

    public String userTypeByID(Long id) {
        String userType = repo.findUserTypeByID(id);
        return userType;
    }

    public Long userID(String email) {
        Long userID = repo.findUserID(email);
        System.out.println(userID);
        return userID;
    }

    public void save(User user) {
        user.setUserID(0L);
        user.setPasswordAndHash(user.getPassword());
        user.setToken("token to create");
        user.setLastLogin(new Timestamp(System.currentTimeMillis()));
        user.setTokenExpDate(new Timestamp(System.currentTimeMillis()));
        user.setCountFailedLogin(0);

        repo.save(user);
    }

    public void savePerson(Person p) {
        personRepo.save(p);
    }


    public void updatePerson(Person p) {
        personRepo.updatePerson(p.getfName(), p.getlName(), p.getPhoneNumber(), p.getAddress(), p.getUserID());
    }
}