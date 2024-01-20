package com.ecorn.webshop.config;

import com.ecorn.webshop.convertations.MultipartFileToImageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.format.FormatterRegistry;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
@ComponentScan("com.ecorn.webshop")
public class AppConfig implements WebMvcConfigurer {
    @Bean
    public MultipartResolver multipartResolver(){
        return new StandardServletMultipartResolver();
    }

    @Autowired
    private MultipartFileToImageConverter multipartFileToImageConverter;

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(multipartFileToImageConverter);
    }
}
