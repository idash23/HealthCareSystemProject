package edu.okcu.healthcaresystem.services;

import edu.okcu.healthcaresystem.models.Doctor;
import edu.okcu.healthcaresystem.models.User;
import edu.okcu.healthcaresystem.repository.DoctorRepository;
import edu.okcu.healthcaresystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    @Autowired
    private DoctorRepository doctorRepo;

    public User login(String email, String password) {
        User user = repo.findByEmailAndPassword(email, password);
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
        user.setUserID(0L);
        user.setSalt("add salt");
        repo.save(user);
    }

    public void saveDoc(Doctor doc) {
        doctorRepo.save(doc);
    }

    public void updateDoc(Doctor doctor) {
        doctorRepo.updateDoctor(doctor.getDOB(), doctor.getfName(), doctor.getmName(), doctor.getlName(),
                doctor.getGender(), doctor.getEmail());
    }
}