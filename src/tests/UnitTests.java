package tests;

import calculator.Calc;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UnitTest {

    private Calc calculator;

    @Before
    public void setUp() {
        calculator = new Calc();
    }

    @Test
    public void testAddition() {
        calculator.handleInput("2");
        calculator.handleInput("+");
        calculator.handleInput("3");
        calculator.performOperation();
        assertEquals("5.0", calculator.display.getText());
    }

    @Test
    public void testSubtraction() {
        calculator.handleInput("5");
        calculator.handleInput("-");
        calculator.handleInput("3");
        calculator.performOperation();
        assertEquals("2.0", calculator.display.getText());
    }

    @Test
    public void testMultiplication() {
        calculator.handleInput("2");
        calculator.handleInput("*");
        calculator.handleInput("3");
        calculator.performOperation();
        assertEquals("6.0", calculator.display.getText());
    }

    @Test
    public void testDivision() {
        calculator.handleInput("6");
        calculator.handleInput("/");
        calculator.handleInput("2");
        calculator.performOperation();
        assertEquals("3.0", calculator.display.getText());
    }

    @Test
    public void testDivisionByZero() {
        calculator.handleInput("5");
        calculator.handleInput("/");
        calculator.handleInput("0");
        calculator.performOperation();
        assertEquals("Error", calculator.display.getText());
    }

    @Test
    public void testBackspace() {
        calculator.handleInput("1");
        calculator.handleInput("2");
        calculator.handleInput("3");
        calculator.handleBackspace();
        assertEquals("12", calculator.display.getText());
    }

    @Test
    public void testClearCalculator() {
        calculator.handleInput("1");
        calculator.handleInput("2");
        calculator.handleInput("3");
        calculator.clearCalculator();
        assertEquals("", calculator.display.getText());
        assertEquals(0.0, calculator.result, 0.0);
        assertEquals("", calculator.lastOperation);
        assertEquals("", calculator.currentInput);
    }
}
