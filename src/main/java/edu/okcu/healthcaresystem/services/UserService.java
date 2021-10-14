package edu.okcu.healthcaresystem.services;

import edu.okcu.healthcaresystem.models.User;
import edu.okcu.healthcaresystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public User login(String email, String password) {
        User user = repo.findByEmailAndPassword(email, password);
        return user;
    }

    public void save(User user) {
        repo.save(user);
    }
}