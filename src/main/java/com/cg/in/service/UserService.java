package com.cg.in.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cg.in.Repository.StudentRepository;
import com.cg.in.Repository.UserRepository;
import com.cg.in.entity.Student;
import com.cg.in.entity.User;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Student getStudentDetailsByUsername(String username) {
        User user = userRepository.findByUsername(username).orElse(null);
        if (user != null) {
            return user.getStudent();
        }
        return null;
    }

    public User saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword())); // Encode the password
        return userRepository.save(user);
    }
}
