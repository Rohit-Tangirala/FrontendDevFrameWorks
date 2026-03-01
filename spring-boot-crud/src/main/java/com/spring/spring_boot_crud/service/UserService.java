package com.spring.spring_boot_crud.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.spring_boot_crud.model.User;
import com.spring.spring_boot_crud.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public void saveUser(User user) {
        repo.save(user);
    }

    public List<User> getAllUsers() {
        return repo.findAll();
    }

    public void deleteUser(int rollno) {
        repo.deleteById(rollno);
    }
}