package com.fitnova.service;

import com.fitnova.model.dto.LoginRequest;
import com.fitnova.model.dto.UserDto;

public interface UserService {
    void register(UserDto userDto);
    String login(LoginRequest loginRequest);
    void verifyEmail(String token);
}
