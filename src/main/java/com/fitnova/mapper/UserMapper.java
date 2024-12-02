package com.fitnova.mapper;

import com.fitnova.model.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
//    @Select("SELECT * FROM users WHERE id = #{id}")
//    User getUserById(Long id);
//
//    @Insert("INSERT INTO users(username, password, email, phone, is_email_verified, created_at, updated_at) " +
//            "VALUES(#{username}, #{password}, #{email}, #{phone}, #{isEmailVerified}, #{createdAt}, #{updatedAt})")
//    @Options(useGeneratedKeys = true, keyProperty = "id")
//    void insertUser(User user);
//
//    @Update("UPDATE users SET username=#{username}, password=#{password}, email=#{email}, phone=#{phone}, " +
//            "is_email_verified=#{isEmailVerified}, updated_at=#{updatedAt} WHERE id=#{id}")
//    void updateUser(User user);
//
//    @Delete("DELETE FROM users WHERE id=#{id}")
//    void deleteUser(Long id);
//
//    @Select("SELECT * FROM users")
//    List<User> getAllUsers();

    //
    @Insert("INSERT INTO tb_users (username, email, password, create_time, update_time) VALUES (#{username}, #{email}, #{password}, NOW(), NOW())")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertUser(User user);

    @Select("SELECT * FROM tb_users WHERE id = #{id}")
    User findUserById(Long id);

    @Select("SELECT * FROM tb_users WHERE email = #{email}")
    User findUserByEmail(String email);

    @Update("UPDATE tb_users SET username = #{username}, email = #{email}, update_time = NOW() WHERE id = #{id}")
    int updateUser(User user);

    @Delete("DELETE FROM tb_users WHERE id = #{id}")
    int deleteUser(Long id);
}
