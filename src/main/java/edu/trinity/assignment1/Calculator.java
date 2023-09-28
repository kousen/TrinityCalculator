package edu.trinity.assignment1;

import java.util.List;

public class Calculator {

    public double sumNumbers(List<Double> numbers) {
        return numbers.stream().mapToDouble(Double::doubleValue).sum();
    }

    public double add(double arg1, double arg2) {
        return arg1 + arg2;
    }

    public double multiply(double arg1, double arg2) {
        return arg1 * arg2;
    }
}
