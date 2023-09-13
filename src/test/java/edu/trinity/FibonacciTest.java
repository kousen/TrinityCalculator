package edu.trinity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}
