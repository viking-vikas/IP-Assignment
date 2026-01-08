package com.ems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ems.entity.User;
import com.ems.repository.UserRepository;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin
public class AuthController {

    @Autowired
    private UserRepository repo;

    @PostMapping("/login")
    public User login(@RequestBody User user) {
        return repo.findByEmailAndPassword(
                user.getEmail(),
                user.getPassword()
        );
    }
}
