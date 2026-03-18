//package JavaAdvanced.Ss4.test.java.com.demo;
//
//import Session04.main.java.com.demo.Ex03;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//
//class Ex03Test {
//
//    private Ex03 processor;
//
//    @BeforeEach
//    void setUp() {
//        processor = new Ex03();
//    }
//
//    @Test
//    @DisplayName("Kiểm tra email hợp lệ")
//    void testValidEmail(){
//        String email = "user@gmail.com";
//        String result = processor.processEmail(email);
//        assertEquals("user@gmail.com", result);
//    }
//
//    @Test
//    @DisplayName("Kiểm tra email thiếu ký tự @")
//    void testEmailMissingAtSymbol() {
//        assertThrows(IllegalArgumentException.class, () -> {
//            processor.processEmail("usergmail.com");
//        });
//    }
//
//    @Test
//    @DisplayName("Kiểm tra email thiếu phần domain")
//    void testEmailMissingDomain() {
//        assertThrows(IllegalArgumentException.class, () -> {
//            processor.processEmail("user@");
//        });
//    }
//
//    @Test
//    @DisplayName("Kiểm tra email đã được chuẩn hóa về chữ thường")
//    void testEmailNormalizationToLowercase() {
//        String result = processor.processEmail("Example@Gmail.com");
//        assertEquals("example@gmail.com", result);
//    }
//}