package edu.trinity.assignment1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MemoizedFibonacciTest {
    private final MemoizedFibonacci fibonacci = new MemoizedFibonacci(100);

    // JUnit 5 introduced parameterized tests, which allow you to run the
    // same test with different inputs.

    // Use a CSV file as the source of the test data. This CSV file is located
    // in src/test/resources/fibonacci_numbers.csv. The first line of the CSV
    // file is a header line, which is skipped by setting numLinesToSkip = 1.

    @ParameterizedTest(name = "Fibonacci({0}) == {1}")
    @CsvFileSource(resources = "/fibonacci_numbers.csv", numLinesToSkip = 1)
    void testFibonacci(int n, BigInteger expected) {
        assertEquals(expected, fibonacci.calculate(n));
    }
}
