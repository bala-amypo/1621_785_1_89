// package com.example.demo.service;
// import java.util.List;
// import com.example.demo.model.User;
// public interface UserService {
//     User registerUser(User user);
//     User findByEmail(String email);
//     List<User> getAllUsers();
//     User getUserById(Long id);
// }




package com.example.demo.service;

import com.example.demo.model.User;
import java.util.List;

public interface UserService {

    User registerUser(User user);

    User findByEmail(String email);

    List<User> getAllUsers();
}
