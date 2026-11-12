package com.ttknpdev.ecomercebackend.services.security;

import com.ttknpdev.ecomercebackend.entities.security.User;
import com.ttknpdev.ecomercebackend.repositories.security.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;
    private PasswordEncoder bcryptEncoder;

    @Autowired
    public UserService(UserRepository repository, @Qualifier("bcryptEncoder") PasswordEncoder bcryptEncoder) {
        this.userRepository = repository;
        this.bcryptEncoder = bcryptEncoder;
    }

    public Boolean create(String username, String password) {
        if (read(username) == null) {
            User newUser = new User();
            newUser.setUsername(username);
            newUser.setPassword(bcryptEncoder.encode(password));
            userRepository.addUser(newUser.getUsername(), newUser.getPassword());
            return true;
        }
        return false;
    }

    public User read(String username) {
        return userRepository.findByUsername(username);
    }
}
