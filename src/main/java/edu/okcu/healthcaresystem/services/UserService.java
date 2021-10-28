package edu.okcu.healthcaresystem.services;

import edu.okcu.healthcaresystem.models.Doctor;
import edu.okcu.healthcaresystem.models.User;
import edu.okcu.healthcaresystem.repository.DoctorRepository;
import edu.okcu.healthcaresystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }
    @Autowired
    private UserRepository repo;

    @Autowired
    private DoctorRepository doctorRepository;

    public User login(String email, String password) {
        User user = repo.findByEmailAndPassword(email, password);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return user;
    }

    public String userType(String email) {
        String userType = repo.findUserType(email);
        return userType;
    }

    public Long userID(String email) {
        Long userID = repo.findUserID(email);
        return userID;
    }

    public void save(User user) {

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setUserID(0L);
       //user.setSalt("add salt");
        user.setSalt(user.getSalt());

        repo.save(user);



}
    public void saveDoc(Doctor doc) {
        doctorRepository.save(doc);
    }

    public void updateDoc(Doctor doctor) {
        doctorRepository.updateDoctor(doctor.getDOB(), doctor.getfName(), doctor.getmName(), doctor.getlName(),
                doctor.getGender(), doctor.getEmail());



    }




}