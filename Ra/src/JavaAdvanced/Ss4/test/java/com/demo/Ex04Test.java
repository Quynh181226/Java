//package JavaAdvanced.Ss4.test.java.com.demo;
//
//import Session04.main.java.com.demo.Ex04;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//class Ex04Test {
//
//    private Ex04 passwordService;
//
//    @BeforeEach
//    void setUp() {
//        passwordService = new Ex04();
//    }
//
//    @Test
//    void testStrongPassword() {
//        String result = passwordService.evaluatePasswordStrength("Abc123!@");
//        assertEquals("Mạnh", result);
//    }
//
//    @Test
//    void testMissingUppercase() {
//        String result = passwordService.evaluatePasswordStrength("abc123!@");
//        assertEquals("Trung bình", result);
//    }
//
//    @Test
//    void testMissingLowercase() {
//        String result = passwordService.evaluatePasswordStrength("ABC123!@");
//        assertEquals("Trung bình", result);
//    }
//
//    @Test
//
//    void testMissingNumber() {
//        String result = passwordService.evaluatePasswordStrength("Abcdef!@");
//        assertEquals("Trung bình", result);
//    }
//
//    @Test
//    void testMissingSpecialCharacter() {
//        String result = passwordService.evaluatePasswordStrength("Abc12345");
//        assertEquals("Trung bình", result);
//    }
//
//    @Test
//    void testTooShortPassword() {
//        String result = passwordService.evaluatePasswordStrength("Ab1!");
//        assertEquals("Yếu", result);
//    }
//
//    @Test
//    void testOnlyLowercase() {
//        String result = passwordService.evaluatePasswordStrength("password");
//        assertEquals("Yếu", result);
//    }
//
//    @Test
//    void testUppercaseAndNumberOnly() {
//        String result = passwordService.evaluatePasswordStrength("ABC12345");
//        assertEquals("Trung bình", result);
//    }
//}