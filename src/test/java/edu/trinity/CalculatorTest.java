package edu.trinity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void add() {
        Calculator calc = new Calculator();
        assertEquals(5, calc.add(2, 3));

    }

    @Test
    void multiply() {
        Calculator calc = new Calculator();
        assertEquals(6, calc.multiply(2, 3));
    }
}