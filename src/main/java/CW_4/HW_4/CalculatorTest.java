package CW_4.HW_4;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class CalculatorTest {
    @Test
    public void findOperator() throws Exception {
        Calculator calculator = new Calculator();
        assertEquals('*',calculator.findOperator("23.45*2.1"));
    }

    @Test
    public void findValue_1() throws Exception {
        Calculator calculator = new Calculator();
        assertEquals(2.545,calculator.findValue_1("2.545",'/'));
    }

    @Test
    public void findValue_2() throws Exception {
        Calculator calculator = new Calculator();
        assertEquals(2.545,calculator.findValue_2("2.545",'-'));
    }

    @Test
    public void multiply() throws Exception {
        Calculator calculator = new Calculator();
        double d = calculator.multiply(3.2, 2);
        assertEquals(6.4, d);
    }

    @Test
    public void divide() throws Exception {
        Calculator calculator = new Calculator();
        double d = calculator.divide(6.2, 2);
        assertEquals(3.1, d);
    }

    @Test
    public void plus() throws Exception {
        Calculator calculator = new Calculator();
        calculator.plus(3.2, 2.0);
        assertEquals(5.2, calculator.calc(3.2,2, '+'));
    }

    @Test
    public void minus() throws Exception {
        Calculator calculator = new Calculator();
        calculator.minus(3.2, 2.2);
        assertEquals(1.0, calculator.calc(3.2,2.2,'-'));
    }

}