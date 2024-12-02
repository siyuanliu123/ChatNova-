package com.fitnova.service;

import com.fitnova.model.dto.LoginRequest;
import com.fitnova.model.dto.UserDto;

import com.fitnova.model.entity.User;
import com.fitnova.model.entity.UserSettings;

public interface UserService {
    //leon
    Long createUser(User user);
    User findUserById(Long id);
    boolean updateUser(User user);
    boolean deleteUser(Long id);

    UserSettings getUserSettings(Long userId);
    boolean updateUserSettings(UserSettings userSettings);
}
