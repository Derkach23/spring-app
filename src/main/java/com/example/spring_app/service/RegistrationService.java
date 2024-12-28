package com.example.springapp.service;

import com.example.springapp.model.User;
import com.example.springapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    private final UserRepository userRepository;
    private final NotificationService notificationService;

    @Autowired
    public RegistrationService(UserRepository userRepository, NotificationService notificationService) {
        this.userRepository = userRepository;
        this.notificationService = notificationService;
    }

    public User processRegistration(String name, int age) {
        User user = new User();
        user.setName(name);
        user.setAge(age);
        userRepository.save(user);
        notificationService.notify("User registered: " + user.getName());
        return user;
    }
}