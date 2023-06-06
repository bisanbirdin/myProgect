package ru.inno.ec.services;

public interface EmailService {

    void sendSimpleService(String toAddress, String subject, String message);
}
