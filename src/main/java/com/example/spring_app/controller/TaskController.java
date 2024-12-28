package com.example.springapp.controller;

import com.example.springapp.model.User;
import com.example.springapp.repository.UserRepository;
import com.example.springapp.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class TaskController {

    private final RegistrationService registrationService;
    private final UserRepository userRepository;

    @Autowired
    public TaskController(RegistrationService registrationService, UserRepository userRepository) {
        this.registrationService = registrationService;
        this.userRepository = userRepository;
    }

    @PostMapping("/register")
    public User registerUser(@RequestParam String name, @RequestParam int age) {
        return registrationService.processRegistration(name, age);
    }

    @GetMapping("/filter/{age}")
    public List<User> filterUsersByAge(@PathVariable int age) {
        return userRepository.findByAgeGreaterThanEqual(age);
    }

    @GetMapping("/calc")
    public double calculateAverageAge() {
        List<User> users = userRepository.findAll();
        return users.stream().mapToInt(User::getAge).average().orElse(0.0);
    }
}