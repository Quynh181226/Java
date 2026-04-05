package com.example.Ss1.Ex5;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.example.Ss1.Ex5.config.AppConfig;
import com.example.Ss1.Ex5.model.SystemConfig;




public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        SystemConfig config = context.getBean(SystemConfig.class);
        config.displayinfo();
        context.registerShutdownHook();
    }
}
