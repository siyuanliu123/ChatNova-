package com.fitnova.service.impl;

import com.fitnova.service.EmailService;
import com.fitnova.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmailService emailService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void register(UserDto userDto) {
        // Check if user already exists
        if (userRepository.findByEmail(userDto.getEmail()).isPresent()) {
            throw new IllegalStateException("Email is already registered");
        }

        // Save user to the database
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setEmail(userDto.getEmail());
        user.setPhone(userDto.getPhone());
        user.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        user.setUpdatedAt(new Timestamp(System.currentTimeMillis()));

        userRepository.save(user);

        // Send verification email
        String token = UUID.randomUUID().toString();
        emailService.sendEmailVerification(user.getEmail(), token);
    }

    @Override
    public String login(LoginRequest loginRequest) {
        User user = userRepository.findByUsername(loginRequest.getUsername())
                .orElseThrow(() -> new IllegalStateException("User not found"));

        if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            throw new IllegalStateException("Invalid credentials");
        }

        // Return a simple token (for real apps, use JWT or OAuth)
        return "TOKEN-" + UUID.randomUUID().toString();
    }

    @Override
    public void verifyEmail(String token) {
        // Logic to verify the token
        // For simplicity, assume token verification succeeds
        System.out.println("Email verification succeeded for token: " + token);
    }
}
