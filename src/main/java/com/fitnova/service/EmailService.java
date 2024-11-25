package com.fitnova.service;

public interface EmailService {
    void sendEmailVerification(String email, String token);
}
