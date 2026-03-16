package JavaAdvanced.Ss4.main.java.com.demo.Ex05.Ss4.test.java.com.demo;

import Session04.main.java.com.demo.Ex02;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class Ex02Test {

    Ex02 userService = new Ex02();

    @Test
    @DisplayName("Kiểm tra tuổi hợp lệ")
    void testAge18(){
        int age = 18;
        boolean result = userService.checkRegistrationAge(age);
        assertEquals(true, result);
    }

    @Test
    @DisplayName("Kiểm tra tuổi không hợp lệ")
    void testAge17(){
        int age = 17;
        boolean result = userService.checkRegistrationAge(age);
        assertEquals(false, result);
    }

    @Test
    @DisplayName("Kiểm tra tuổi âm")
    void testNegativeAge(){
        int age = -1;
        assertThrows(IllegalArgumentException.class, () -> userService.checkRegistrationAge(age));
    }
}