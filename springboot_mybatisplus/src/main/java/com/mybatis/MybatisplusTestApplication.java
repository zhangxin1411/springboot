package com.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.mybatis.mapper")
@SpringBootApplication
public class MybatisplusTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisplusTestApplication.class, args);
    }

}
