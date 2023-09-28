package edu.trinity.assignment1;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    public void add() {
        Calculator calc = new Calculator();
        assertEquals(5, calc.add(2, 3));

    }

    @Test
    void multiply() {
        Calculator calc = new Calculator();
        assertEquals(6, calc.multiply(2, 3));
    }

    @Test
    void sumNumbers() {
        Calculator calc = new Calculator();
        assertEquals(6, calc.sumNumbers(List.of(1.0, 2.0, 3.0)));
    }
}