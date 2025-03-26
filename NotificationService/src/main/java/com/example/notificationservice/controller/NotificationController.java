package com.example.notificationservice.controller;

import com.example.notificationservice.model.MessageDTO;
import com.example.notificationservice.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/send-notification")
    public void sendNotification(@RequestBody MessageDTO messageDTO) {
        emailService.sendEmail(messageDTO);
    }
}
