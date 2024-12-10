package com.fitnova.mapper;

import com.fitnova.model.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Insert("INSERT INTO Users (username, email, password, profile_picture, bio, is_active, user_type, create_time, update_time) " +
            "VALUES (#{username}, #{email}, #{password}, #{profilePicture}, #{bio}, #{isActive}, #{userType}, NOW(), NOW())")
    @Options(useGeneratedKeys = true, keyProperty = "userId")
    int insertUser(User user);

    @Select("SELECT * FROM Users WHERE user_id = #{userId}")
    User findUserById(Long userId);

    @Update("UPDATE Users SET username = #{username}, email = #{email}, profile_picture = #{profilePicture}, " +
            "bio = #{bio}, is_active = #{isActive}, user_type = #{userType}, update_time = NOW() WHERE user_id = #{userId}")
    int updateUser(User user);

    @Delete("DELETE FROM Users WHERE user_id = #{userId}")
    int deleteUser(Long userId);
}

