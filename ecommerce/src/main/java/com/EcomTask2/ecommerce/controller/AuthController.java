package com.EcomTask2.ecommerce.controller;



import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.EcomTask2.ecommerce.repository.UserRepository;
import com.EcomTask2.ecommerce.model.User;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin
public class AuthController {

    @Autowired
    private UserRepository userRepo;

    @PostMapping("/login")
    public User login(@RequestBody User request){

        User user = userRepo.findByUsername(request.getUsername());

        if(user != null && user.getPassword().equals(request.getPassword())){
            return user;
        }

        return null;
    }
}