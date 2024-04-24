package ru.ecodil.shop.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*") // Разрешаем запросы только с localhost:8080
                .allowedMethods("GET", "POST") // Разрешаем только GET и POST запросы
                .allowedHeaders("Content-Type"); // Разрешаем только заголовок Content-Type
    }
}