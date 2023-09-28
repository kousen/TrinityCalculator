package edu.trinity.assignment1;

import java.util.EmptyStackException;
import java.util.Stack;

public class RPNCalculator {
    public static double evaluate(String expression) {
        Stack<Double> stack = new Stack<>();
        String[] tokens = expression.split("\\s+");

        for (String token : tokens) {
            if (isOperator(token) && stack.size() >= 2) {
                double operand2 = stack.pop();
                double operand1 = stack.pop();
                double result = applyOperation(token, operand1, operand2);
                stack.push(result);
            } else if(isNumeric(token)) {
                stack.push(Double.parseDouble(token));
            } else if (stack.size() < 2) {
                // Note: this is an example of over-specifying in a test. The
                // "insufficientOperands" test should not check for an EmptyStackException,
                // because that's an implementation detail.
                //
                // IllegalArgumentException is the correct exception to throw here, and the
                // test should not care about the specific exception type. It would also
                // allow us to combine this block with the "else" block below.

                // Unfortunately, we have to live with what was requested, but this
                // is a potential problem to watch out for in tests.

                throw new EmptyStackException();
            } else {

                throw new IllegalArgumentException("Invalid input: " + token);
            }
        }

        if (stack.size() > 1) {
            // Remove any excessive operands, leaving only the result of the most recent computation
            while (stack.size() > 1) {
                stack.pop();
            }
        }

        return stack.pop();
    }

    private static boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") ||
               token.equals("*") || token.equals("/");
    }

    // The Character class has a static method called isDigit, but that only works for single characters.
    // Generalizing that to strings is a bit more complicated, so just use a regular expression instead.
    // Alternatively, you can call Double.parseDouble(String) and catch the NumberFormatException, but
    // it's generally not got practice to use exceptions for control flow.
    private static boolean isNumeric(String token) {
        return token.matches("[-+]?[0-9]*\\.?[0-9]+([eE][-+]?[0-9]+)?");
    }

    private static double applyOperation(String operator, double operand1, double operand2) {
        return switch (operator) {
            case "+" -> operand1 + operand2;
            case "-" -> operand1 - operand2;
            case "*" -> operand1 * operand2;
            case "/" -> {
                if (operand2 == 0) {
                    throw new IllegalArgumentException("Division by zero");
                }
                yield operand1 / operand2;
            }
            default -> throw new IllegalArgumentException("Invalid operator: " + operator);
        };
    }
}
