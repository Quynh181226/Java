package com.example.Ss2.config;


import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 *  Spring MVC Initializer
 *
 * Thay thế web.xml trong Servlet 3.0+
 *
 * Dùng để:
 * 1. Khởi tạo DispatcherServlet
 * 2. Cấu hình URL mapping
 * 3. Liên kết Config class (WebConfig)
 */
public class MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     * Root Application Context
     *
     * Dùng cho beans chia sẻ toàn cầu (Service, Repository, ...)
     * Trong bài này: null (không cần context riêng)
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    /**
     * Servlet Application Context (DispatcherServlet context)
     *
     * Dùng cho beans riêng của Spring MVC (Controller, ViewResolver, ...)
     * Liên kết WebConfig class
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] { WebConfig.class };
    }

    /**
     *  URL Mapping cho DispatcherServlet
     *
     *  LỖI CŨ: return new String[] { "/api/*" };
     *  SỬA MỚI: return new String[] { "/" };
     *
     * Giải thích:
     *
     * Wildcard patterns:
     *   "/" = Bắt TẤT CẢ URL (trừ static resources)
     *   "/api/*" = Chỉ bắt /api/* (SAI - không bắt /welcome)
     *   "/app/*" = Chỉ bắt /app/*
     *
     * Ví dụ:
     *   "/" bắt được:
     *      /welcome
     *      /report
     *      /login
     *      /api/users (cũng bị bắt)
     *
     *   "/api/*" bắt được:
     *      /api/users
     *      /api/products
     *      /welcome (KHÔNG bắt → 404)
     *      /report (KHÔNG bắt → 404)
     */
    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };  //  SỬA: Bắt tất cả URL
    }
}
