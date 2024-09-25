package com.userservice.Service;

import com.userservice.Model.User;
import com.userservice.Model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user) { return userRepository.save(user); }

    public User authenticateUser(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password)
                .orElse(null);
    }
}
