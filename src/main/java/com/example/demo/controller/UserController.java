// package com.example.demo.controller;

// import org.springframework.web.bind.annotation.RestController;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.RequestBody;

// import java.util.List;

// import com.example.demo.model.User;
// import com.example.demo.service.UserService;

// @RestController
// public class UserController {

//     private final UserService userService;

//     // Constructor Injection
//     public UserController(UserService userService) {
//         this.userService = userService;
//     }

//     // POST /register
//     @PostMapping("/register")
//     public User registerUser(@RequestBody User user) {
//         return userService.registerUser(user);
//     }

//     // GET /all
//     @GetMapping("/all")
//     public List<User> getAllUsers() {
//         return userService.getAllUsers();
//     }

//     // GET /get/{id}
//     @GetMapping("/get/{id}")
//     public User getUserById(@PathVariable Long id) {
//         return userService.getUserById(id);
//     }
// }



package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;
import com.example.demo.service.UserService;
import com.example.demo.model.User;

@RestController
@RequestMapping("/api/users")


public class UserController {

    private final UserService userService;

    // Constructor Injection
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return userService.registerUser(user);
    }

    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/get{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }
}
