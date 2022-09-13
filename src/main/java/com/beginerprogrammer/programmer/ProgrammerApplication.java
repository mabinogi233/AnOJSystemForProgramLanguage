package com.beginerprogrammer.programmer;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@MapperScan("com.beginerprogrammer.programmer.dao")
public class ProgrammerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProgrammerApplication.class, args);
    }

}
