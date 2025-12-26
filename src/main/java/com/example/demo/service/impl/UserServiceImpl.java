// package com.example.demo.service.impl;
// import org.springframework.stereotype.Service;
// import com.example.demo.service.UserService;
// import com.example.demo.model.User;
// import com.example.demo.repository.UserRepository;
// import com.example.demo.exception.ResourceNotFoundException;
// import java.util.List;
// @Service
// public class UserServiceImpl implements UserService {

//     private final UserRepository userRepository;

//     public UserServiceImpl(UserRepository userRepository) {
//         this.userRepository = userRepository;
//     }

//     @Override
//     public User registerUser(User user) {
//         if(userRepository.existsById(user.getId())){
//             throw new ResourceNotFoundException("UserId already exists");
//         }
//         return userRepository.save(user);
//     }

//     @Override
//     public User findByEmail(String email) {
//         return userRepository.findByEmail(email).orElse(null);
//     }

//     @Override
//     public List<User> getAllUsers() {
//         return userRepository.findAll();
//     }
//     @Override
//     public User getUserById(Long id) {
//     return userRepository.findById(id).orElse(null);
// }


// }



