package com.fitnova.controller;

import com.fitnova.model.entity.User;
import com.fitnova.model.entity.UserSettings;
import com.fitnova.service.UserService;
import com.fitnova.model.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseVO createUser(@RequestBody User user) {
        Long userId = userService.createUser(user);
        return ResponseVO.success(String.valueOf(userId));
    }

    @GetMapping("/{id}")
    public ResponseVO<User> getUser(@PathVariable Long id) {
        User user = userService.findUserById(id);
        return user != null ? ResponseVO.success(user.toString()) : ResponseVO.error("User not found");
    }

    @PutMapping("/{id}")
    public ResponseVO<?> updateUser(@PathVariable Long id, @RequestBody User user) {
        user.setId(id);
        return userService.updateUser(user) ? ResponseVO.success("User updated") : ResponseVO.error("Update failed");
    }

    @DeleteMapping("/{id}")
    public ResponseVO<?> deleteUser(@PathVariable Long id) {
        return userService.deleteUser(id) ? ResponseVO.success("User deleted") : ResponseVO.error("Delete failed");
    }

    @GetMapping("/{userId}/settings")
    public ResponseVO getUserSettings(@PathVariable Long userId) {
        UserSettings settings = userService.getUserSettings(userId);
        return ResponseVO.success(String.valueOf(settings));
    }

    @PutMapping("/{userId}/settings")
    public ResponseVO<?> updateUserSettings(@PathVariable Long userId, @RequestBody UserSettings settings) {
        settings.setUserId(userId);
        return userService.updateUserSettings(settings) ? ResponseVO.success("Settings updated") : ResponseVO.error("Update failed");
    }
    @PutMapping("/{id}/status")
    public ResponseVO<?> updateOnlineStatus(@PathVariable Long id, @RequestParam Boolean status) {
        User user = userService.findUserById(id);
        if (user == null) {
            return ResponseVO.error("User not found");
        }
        user.setOnlineStatus(status);
        return userService.updateUser(user) ? ResponseVO.success("Status updated") : ResponseVO.error("Update failed");
}
}
