package edu.trinity.assignment1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class RPNCalculatorTest {

    @Test
    public void testAddition() {
        assertEquals(7.0, RPNCalculator.evaluate("3 4 +"), 0.001);
    }

    @Test
    public void testSubtraction() {
        assertEquals(1.0, RPNCalculator.evaluate("5 4 -"), 0.001);
    }

    @Test
    public void testMultiplication() {
        assertEquals(12.0, RPNCalculator.evaluate("3 4 *"), 0.001);
    }

    @Test
    public void testDivision() {
        assertEquals(2.0, RPNCalculator.evaluate("8 4 /"), 0.001);
    }

    @Test
    public void testComplexExpression() {
        assertEquals(2.0, RPNCalculator.evaluate("3 4 + 2 * 7 /"), 0.001);
    }

    @Test
    public void testDivisionByZero() {
        assertThrows(IllegalArgumentException.class, () -> RPNCalculator.evaluate("3 0 /"));
    }

    @Test
    public void testInvalidOperator() {
        assertThrows(IllegalArgumentException.class, () -> RPNCalculator.evaluate("3 4 ^"));
    }

    @Test
    public void testInsufficientOperands() {
        assertThrows(java.util.EmptyStackException.class, () -> RPNCalculator.evaluate("3 +"));
    }

    @Test
    public void testExcessiveOperands() {
        assertEquals(7.0, RPNCalculator.evaluate("3 4 + 5"), 0.001);
    }
}
