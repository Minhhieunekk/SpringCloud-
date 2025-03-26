package com.example.notificationservice.service;

import com.example.notificationservice.model.MessageDTO;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

@Service
@Slf4j
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender javaMailSender;


    @Override
    public void sendEmail(MessageDTO messageDTO) {
        try {
            log.info("Start sending email");

            MimeMessage message=javaMailSender.createMimeMessage();
            MimeMessageHelper helper=new MimeMessageHelper(message, StandardCharsets.UTF_8.name());

            helper.setTo(messageDTO.getTo());
            helper.setFrom(messageDTO.getFrom());
            helper.setSubject(messageDTO.getSubject());
            helper.setText(messageDTO.getContent(), true);
            javaMailSender.send(message);
            log.info("Email sent successfully");

        } catch (MessagingException e) {
            log.error("Error sending email", e);
        }
    }
}
