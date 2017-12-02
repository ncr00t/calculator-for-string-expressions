package tests;

import calculator.Calculator;
import org.junit.Assert;
import org.junit.Test;

public class CalculatorTests extends Assert {
    private Calculator calculator = new Calculator();

    @Test
    public void sum_abcPlusxyz_abcxyzReturned(){
        String result = calculator.sum("abc" , "xyz");
        assertEquals("abcxyz", result );
    }

    @Test
    public void sum_xyzPlusabc_xyzabcReturned(){
        String result = calculator.sum("xyz" , "abc");
        assertEquals("xyzabc", result);
    }

    @Test
    public void subtraction_abcxyzMinusxyz_abcReturned(){
        String result = calculator.subtraction("abcxyz" , "xyz");
        assertEquals("abc", result);
    }

    @Test
    public void subtraction_abcMinusxyz_abcReturned(){
        String result = calculator.subtraction("abc" , "xyz");
        assertEquals("abc", result);
    }

    @Test
    public void subtraction_abcxyzdMinusxyz_abcxyzdReturned(){
        String result = calculator.subtraction("abcxyzd" , "xyz");
        assertEquals("abcxyzd", result);
    }

    @Test
    public void multiply_abcMultiplyxyz_axbyczReturned(){
        String result = calculator.multiply("abc" , "xyz");
        assertEquals("axbycz", result);
    }

    @Test
    public void multiply_abcMultiplyxyzps_axbyczsReturned(){
        String result = calculator.multiply("abc" , "xyzps");
        assertEquals("axbyczps", result);
    }

    @Test
    public void multiply_abcdeMultiplyxyz_axbyczdeReturned(){
        String result = calculator.multiply("abcde" , "xyz");
        assertEquals("axbyczde", result);
    }

    @Test
    public void divide_abcDivxyz_abcReturned(){
        String result = calculator.divide("abc" , "xyzps");
        assertEquals("abc", result);
    }

    @Test
    public void divide_axbyczDivxyz_abcReturned(){
        String result = calculator.divide("axbycz" , "xyz");
        assertEquals("abc", result);
    }

    @Test
    public void divide_axbyczpsDivxyz_abcpsReturned(){
        String result = calculator.divide("axbyczps" , "xyz");
        assertEquals("abcps", result);
    }
}
