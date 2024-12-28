package com.example.springapp.service;

import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    public void notify(String message) {
        System.out.println("Notification: " + message);
    }
}
