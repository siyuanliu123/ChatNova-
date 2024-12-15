package service;

import com.fitnova.mapper.UserMapper;
import com.fitnova.mapper.UserSettingsMapper;
import com.fitnova.model.entity.User;
import com.fitnova.model.entity.UserSettings;
import com.fitnova.service.impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UserServiceTest {

    @Mock
    private UserMapper userMapper;

    @Mock
    private UserSettingsMapper userSettingsMapper;

    @InjectMocks
    private UserServiceImpl userService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testCreateUser() {
        User user = new User();
        user.setUsername("testUser");

        when(userMapper.insertUser(user)).thenReturn(1);

        Long userId = userService.createUser(user);
        assertEquals(1, userId);
        verify(userMapper, times(1)).insertUser(user);
    }

    @Test
    void testFindUserById() {
        User mockUser = new User();
        mockUser.setId(1L);
        mockUser.setUsername("testUser");

        when(userMapper.findUserById(1L)).thenReturn(mockUser);

        User result = userService.findUserById(1L);
        assertNotNull(result);
        assertEquals("testUser", result.getUsername());
    }

    @Test
    void testUpdateUser() {
        User mockUser = new User();
        mockUser.setId(1L);
        mockUser.setUsername("updateUser");

        when(userMapper.updateUser(mockUser)).thenReturn(1);

        boolean result = userService.updateUser(mockUser);
        assertTrue(result);
        verify(userMapper, times(1)).updateUser(mockUser);
    }

    @Test
    void testDeleteUser() {
        when(userMapper.deleteUser(1L)).thenReturn(1);

        boolean result = userService.deleteUser(1L);
        assertTrue(result);
        verify(userMapper, times(1)).deleteUser(1L);
    }

    @Test
    void testGetUserSettings() {
        UserSettings settings = new UserSettings();
        settings.setId(1L);
        settings.setUserId(1L);
        settings.setNotifications(true);
        settings.setLanguage("English");

        when(userSettingsMapper.findSettingsByUserId(1L)).thenReturn(settings);

        UserSettings result = userService.getUserSettings(1L);
        assertNotNull(result);
        assertEquals(1L, result.getUserId());
        assertEquals(true, result.getNotifications());
        assertEquals("English", result.getLanguage());
        verify(userSettingsMapper, times(1)).findSettingsByUserId(1L);
    }

    @Test
    void testUpdateUserSettings() {
        UserSettings settings = new UserSettings();
        settings.setId(1L);
        settings.setUserId(1L);
        settings.setNotifications(false);
        settings.setLanguage("Spanish");

        when(userSettingsMapper.updateUserSettings(settings)).thenReturn(1);

        boolean result = userService.updateUserSettings(settings);
        assertTrue(result);
        verify(userSettingsMapper, times(1)).updateUserSettings(settings);
    }

}
