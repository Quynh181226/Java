package JavaAdvanced.Ss4.main.java.com.demo.Ex05.Ss4.test.java.com.demo;

import Session04.main.java.com.demo.Ex01;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Ex01Test {

    Ex01 validator = new Ex01();

    @Test
    @DisplayName("Username hợp lệ")
    void isValidUsername() {
        String username = "user123";
        boolean result = validator.isValidUsername(username);
        assertTrue(result);
    }

    @Test
    @DisplayName("Username quá ngắn")
    void isValidUsernameTooShort() {
        String username = "abc";
        boolean result = validator.isValidUsername(username);
        assertFalse(result);
    }

    @Test
    @DisplayName("Username chứa khoảng trắng")
    void testUsernameContainsSpace() {
        String username = "user name";
        boolean result = validator.isValidUsername(username);
        assertFalse(result);
    }
}