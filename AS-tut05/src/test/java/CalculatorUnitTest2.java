import org.example.JUnit.Calculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class CalculatorUnitTest2 {
    private static Calculator calc;

    @BeforeEach
    public void setUp(){
        calc = new Calculator();
    }

    @Test
    public void testAdd(){
        assertEquals(7,calc.add(5,2));
    }


    @Test
    public void testSubstract(){
        assertEquals(5, calc.subtract(10,5));
    }

    @Test
    public void testDivide(){
        assertEquals(2,calc.divide(10,5));
        assertThrows(IllegalArgumentException.class, () -> calc.divide(7,0));
    }

    @Test
    public void testIsEven(){
        assertTrue(calc.isEven(6));
    }





}
