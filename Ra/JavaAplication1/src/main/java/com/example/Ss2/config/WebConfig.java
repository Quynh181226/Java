package com.example.Ss2.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 *  Spring MVC Configuration
 *
 *  LỖI CŨ: @ComponentScan(basePackages = "com.demo.service")
 *  SỬA MỚI: @ComponentScan(basePackages = "org.example.session02")
 *
 * Giải thích:
 * - Spring quét toàn bộ package org.example.session02
 * - Tìm @Controller, @Service, @Component, v.v.
 * - WelcomeController nằm ở org.example.session02.ex01.controller
 *   → Được tìm thấy
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.example.Ss2")
public class WebConfig {

    /**
     *  ViewResolver Bean
     *
     * Dùng để giải phóng logical view name thành file JSP vật lý
     *
     * Ví dụ:
     *   - Controller trả về: "ex01/welcome"
     *   - ViewResolver ghép:
     *     prefix: /WEB-INF/views/
     *     view name: ex01/welcome
     *     suffix: .jsp
     *   - Kết quả: /WEB-INF/views/ex01/welcome.jsp
     */
    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }
}