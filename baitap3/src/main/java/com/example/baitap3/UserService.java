package com.example.baitap3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public  void saveOrUpdate(UserModel user) {
        userRepository.save(user);
    }

    public List<UserModel> getAllUsers() {
        return userRepository.findAll();
    }

    public UserModel getUserById(int id) {
        return userRepository.findById(id).orElse(null);  // Ensure this method is correct
    }
}
