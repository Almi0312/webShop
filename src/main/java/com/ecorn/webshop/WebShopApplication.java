package com.ecorn.webshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class WebShopApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext app = SpringApplication.run(WebShopApplication.class, args);
        PasswordEncoder encoder = app.getBean(PasswordEncoder.class);
        System.out.println(encoder.encode("pass"));
    }

}
