package com.example.Ss2.Ex3.controller;

import com.example.Ss2.Ex3.model.Order;
import com.example.Ss2.Ex3.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * OrderController (Ex03)
 *
 * URL: /ex03/orders
 *
 * Chuc nang:
 * 1. Kiem tra session (da dang nhap chua?)
 * 2. Tao danh sach don hang
 * 3. Cap nhat bộ đếm toàn cuc (Application Scope)
 */
@Controller
@RequestMapping("/Ex3")
public class OrderController {

    // Lock object de sync (chong Race Condition)
    private static final Object lock = new Object();

    @GetMapping("/orders")
    public String getOrders(
            Model model,
            HttpSession session,
            ServletContext application) {

        // Kiem tra session: da dang nhap chua?
        User loggedUser = (User) session.getAttribute("loggedUser");
        if (loggedUser == null) {
            // Chua dang nhap -> redirect ve login
            return "redirect:/Ex3/login";
        }

        // Tao danh sach don hang (gia lap)
        List<Order> orders = createSampleOrders();

        // Day vao MODEL (Request Scope)
        model.addAttribute("orders", orders);

        // Cap nhat bộ đếm toàn cuc (Application Scope) - THREAD-SAFE
        synchronized (lock) {
            AtomicInteger counter =
                    (AtomicInteger) application.getAttribute("totalViewCount");
            if (counter == null) {
                counter = new AtomicInteger(0);
            }
            int currentCount = counter.incrementAndGet();
            application.setAttribute("totalViewCount", counter);
            model.addAttribute("totalViewCount", currentCount);
        }

        return "ex03/orders";
    }

    /**
     * Tao danh sach don hang gia lap
     */
    private List<Order> createSampleOrders() {
        List<Order> orders = new ArrayList<>();
        Calendar cal = Calendar.getInstance();

        cal.set(2026, Calendar.APRIL, 1);
        orders.add(new Order("ORD001", "Laptop Dell XPS 13",
                25000000, cal.getTime()));

        cal.set(2026, Calendar.APRIL, 2);
        orders.add(new Order("ORD002", "Chuot Logitech MX Master 3",
                1500000, cal.getTime()));

        cal.set(2026, Calendar.APRIL, 3);
        orders.add(new Order("ORD003", "Ban phim Mechanical RGB",
                3500000, cal.getTime()));

        cal.set(2026, Calendar.APRIL, 4);
        orders.add(new Order("ORD004", "Monitor LG 27 inch 4K",
                12000000, cal.getTime()));

        cal.set(2026, Calendar.APRIL, 5);
        orders.add(new Order("ORD005", "USB-C Hub 10in1",
                2800000, cal.getTime()));

        return orders;
    }
}