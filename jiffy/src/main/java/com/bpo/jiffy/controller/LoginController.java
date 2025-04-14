package com.bpo.jiffy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.bpo.jiffy.entity.User;
import com.bpo.jiffy.repository.UserRepository;

@RestController
@RequestMapping("/api")
public class LoginController {

    @Autowired
    private UserRepository userRepo;

    // Register with JSON
    @PostMapping("/register")
    public String register(@RequestBody User user) {
        if(userRepo.findByUsername(user.getUsername()) != null) {
            return "Username already exists!";
        }
        userRepo.save(user);
        return "User registered successfully!";
    }

    // Login with JSON
    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {
        User user = userRepo.findByUsername(request.getUsername());
        if (user != null && user.getPassword().equals(request.getPassword())) {
            return "Login successful!";
        }
        return "Invalid credentials!";
    }
}

// Add this class inside the same file
class LoginRequest {
    private String username;
    private String password;
    
    // Getters and setters (or use Lombok @Data)
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}