package com.sd22.dbproject.services;

import com.sd22.dbproject.entities.User;
import com.sd22.dbproject.repositories.UserRepository;
import com.sd22.dbproject.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    public boolean existsByUsername(String email) {
        return userRepository.existsByEmail(email);
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public User findUserById(int id) {
        return userRepository.findById(id).orElseThrow(()-> new NotFoundException());
    }

    public void deleteUserById(int id) {
        userRepository.deleteById(id);
    }

    public User updateUser(User user){
        return userRepository.save(user);
    }
}
