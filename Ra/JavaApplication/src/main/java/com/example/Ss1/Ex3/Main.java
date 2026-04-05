package com.example.Ss1.Ex3;

import com.example.Ss1.Ex3.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        OrderFoodService os = context.getBean(OrderFoodService.class);
        os.orderFood("thanhVIP", "Pizza", 2, 8.99);
        os.orderFood("hoa69", "Burger", 3, 5.99);
        os.orderFood("phuocMatChim", "Sushi", 1, 12.99);
        context.close();
    }
}
