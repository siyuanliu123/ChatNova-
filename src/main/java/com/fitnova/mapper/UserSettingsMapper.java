package com.fitnova.mapper;

import com.fitnova.model.entity.UserSettings;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserSettingsMapper {

    @Insert("INSERT INTO tb_user_settings (user_id, dark_mode, notifications, language, create_time, update_time) VALUES (#{userId}, #{darkMode}, #{notifications}, #{language}, NOW(), NOW())")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertUserSettings(UserSettings userSettings);

    @Select("SELECT * FROM tb_user_settings WHERE user_id = #{userId}")
    UserSettings findSettingsByUserId(Long userId);

    @Update("UPDATE tb_user_settings SET  notifications = #{notifications}, language = #{language}, update_time = NOW() WHERE user_id = #{userId}")
    int updateUserSettings(UserSettings userSettings);
}
