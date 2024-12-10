package com.fitnova.service.impl;

import com.fitnova.mapper.UserMapper;
import com.fitnova.mapper.UserSettingsMapper;
import com.fitnova.model.entity.User;
import com.fitnova.model.entity.UserSettings;
import com.fitnova.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserSettingsMapper userSettingsMapper;

    @Override
    public Long createUser(User user) {
        user.setIsActive(true); // 默认用户激活
        user.setOnlineStatus(false); // 默认离线
        user.setAvatar("/default/avatar.png"); // 默认头像路径
        userMapper.insertUser(user);

        userMapper.insertUser(user);
        // Initialize user settings with default values
        UserSettings defaultSettings = new UserSettings();
        defaultSettings.setUserId(user.getId());
//        defaultSettings.setDarkMode(false);
        defaultSettings.setNotifications(true);
        defaultSettings.setLanguage("en");
        userSettingsMapper.insertUserSettings(defaultSettings);
        return user.getId();
    }

    @Override
    public User findUserById(Long id) {
        return userMapper.findUserById(id);
    }

    @Override
    public boolean updateUser(User user) {
        return userMapper.updateUser(user) > 0;
    }

    @Override
    public boolean deleteUser(Long id) {
        return userMapper.deleteUser(id) > 0;
    }

    @Override
    public UserSettings getUserSettings(Long userId) {
        return userSettingsMapper.findSettingsByUserId(userId);
    }

    @Override
    public boolean updateUserSettings(UserSettings userSettings) {
        return userSettingsMapper.updateUserSettings(userSettings) > 0;
    }
}
