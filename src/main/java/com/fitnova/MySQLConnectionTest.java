package com.fitnova;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLConnectionTest {
    public static void main(String[] args) {
        String url = "jdbc:mysql://172.16.178.128:3306/my_database?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
        String username = "remote_user";
        String password = "password";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connection successful!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

