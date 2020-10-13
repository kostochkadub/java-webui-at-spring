package com.example.javawebuiatspring.controller;

import com.example.javawebuiatspring.model.User;
import com.example.javawebuiatspring.repository.PassportRepository;
import com.example.javawebuiatspring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private final UserRepository repository;
    private PassportRepository passportRepository;

    public UserController(UserRepository repository, PassportRepository passportRepository) {
        this.repository = repository;
        this.passportRepository = passportRepository;
    }


    @PostMapping("/user")
    public User create(@RequestBody User input){
        System.err.println("WEEEEHA!!!!!");
        return repository.save(input);
    }

}
