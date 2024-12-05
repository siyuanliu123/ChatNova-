package com.fitnova;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, MybatisAutoConfiguration.class})
@SpringBootApplication
@MapperScan("com.fitnova.mapper") // 指定 Mapper 接口所在的包路径
public class ChatNovaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChatNovaApplication.class, args);
    }
}

