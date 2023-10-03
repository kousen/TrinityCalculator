package edu.trinity.assignment1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FibonacciTest {
    @Test
    void testFibonacciEdgeCases() {
        assertEquals(0, Fibonacci.calculate(0));
        assertEquals(1, Fibonacci.calculate(1));
    }

    @Test
    void testFibonacciNormalCases() {
        assertEquals(1, Fibonacci.calculate(2));
        assertEquals(2, Fibonacci.calculate(3));
        assertEquals(5, Fibonacci.calculate(5));
    }

    @Test
    void testForNegativeArgument() {
        assertThrows(IllegalArgumentException.class, () -> Fibonacci.calculate(-1));
    }
}
