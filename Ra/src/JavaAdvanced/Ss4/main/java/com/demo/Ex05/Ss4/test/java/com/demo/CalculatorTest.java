package JavaAdvanced.Ss4.main.java.com.demo.Ex05.Ss4.test.java.com.demo;

import Session04.main.java.com.demo.Calculator;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {
    @Test
    @DisplayName("Test add 1 + 1 case")
    public void testAdd1Plus1(){
        int number1 = 1;
        int number2 = 1;
        int expected = 2;

        int actual = Calculator.add(number1, number2);
        assertEquals(expected, actual);
    }
}
