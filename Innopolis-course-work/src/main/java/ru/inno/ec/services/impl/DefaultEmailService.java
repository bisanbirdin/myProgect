package ru.inno.ec.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import ru.inno.ec.services.EmailService;

@Service
public class DefaultEmailService implements EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void sendSimpleService(String toAddress, String subject, String body) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("isanbirdinb@gmail.com");
        message.setTo(toAddress);
        message.setText(body);
        message.setSubject(subject);

        mailSender.send(message);

        System.out.println("Mail Sent successfully...");
    }
}
