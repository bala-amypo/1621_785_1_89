
package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/auth")
// @Tag(name = "Authentication")
public class AuthController {

    private final UserService userService;

    // Constructor injection
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    // POST /auth/register
    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return userService.registerUser(user);
    }

    // POST /auth/login
    @PostMapping("/login")
    public User loginUser(@RequestBody User user) {
        return userService.findByEmail(user.getEmail());
    }
}
