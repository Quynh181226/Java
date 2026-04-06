package com.example.Ss2.config;



import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * GlobalExceptionHandler (Ex05)
 *
 * Bat tat ca Exception va dua toi trang error chung
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ModelAndView handleException(Exception ex) {
        ModelAndView modelAndView = new ModelAndView("ex05/error");
        modelAndView.addObject("errorMessage", ex.getMessage());
        return modelAndView;
    }
}