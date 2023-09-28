package edu.trinity.assignment1;

public class Fibonacci {

    // Recursive, so issues with stack overflow if the number is too large
    public static int calculate(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n must be non-negative");
        }
        if (n <= 1) {
            return n;
        }
        return calculate(n - 1) + calculate(n - 2);
    }
}
