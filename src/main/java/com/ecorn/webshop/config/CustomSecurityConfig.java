package com.ecorn.webshop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Класс конфигурации, который не позволяет быть циклу
 * между PasswordEncoder и UserServiceImpl
 */
@Configuration
public class CustomSecurityConfig {

    @Bean
    public PasswordEncoder methodCrypt(){
        return new BCryptPasswordEncoder();
    }
}
