package com.example.Ss2.Ex4.controller;

import com.example.Ss2.Ex4.model.Event;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * EventController (Ex04)
 *
 * URL: /ex04/events/search?keyword=spring
 *
 * Chuc nang: Tim kiem su kien theo tu khoa
 */
@Controller
@RequestMapping("/Ex4")
public class EventController {

    @GetMapping("/events/search")
    public String search(
            @RequestParam(required = false, defaultValue = "") String keyword,
            Model model) {

        // Tao du lieu gia (dai dien tu database)
        List<Event> results = new ArrayList<>();

        results.add(new Event(1, "Hoi thao Spring Framework 2026",
                "2026-06-15", 250000.0, 50));

        results.add(new Event(2, "Workshop <script>alert('xss')</script>",
                "2026-07-20", 0.0, 0));

        results.add(new Event(3, "Tech Summit Ha Noi",
                "2026-08-10", 1500000.0, 200));

        results.add(new Event(4, "Java Conference 2026",
                "2026-09-05", 500000.0, 8));

        results.add(new Event(5, "Free Webinar: Web Development",
                "2026-04-20", 0.0, 100));

        // Loc theo keyword (case-insensitive)
        List<Event> filtered = results.stream()
                .filter(e -> e.getName().toLowerCase()
                        .contains(keyword.toLowerCase()))
                .collect(Collectors.toList());

        // Day du lieu vao Model
        model.addAttribute("events", filtered);
        model.addAttribute("keyword", keyword);
        model.addAttribute("totalFound", filtered.size());

        return "Ex4/events/search";
    }
}