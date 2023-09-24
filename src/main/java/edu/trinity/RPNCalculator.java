package edu.trinity;
import java.util.*;

public class RPNCalculator {
    public static double evaluate(String expr) {
        int tracker;
        float result = 0;
        String[] tokens = expr.split(" ");
        Stack<Float> operands = new Stack<>();
        char operator;

        for (tracker = 0; tracker < tokens.length; tracker++)
        {
            if (tokens[tracker].equals("+"))
            {
                result = operands.pop() + operands.pop();
                operands.push(result);
            }
            else if (tokens[tracker].equals("*"))
            {
                result = operands.pop() * operands.pop();
                operands.push(result);
            }
            else if (tokens[tracker].equals("-"))
            {
                float temp = operands.pop();
                result = operands.pop() - temp;
                operands.push(result);
            }
            else if (tokens[tracker].equals("/"))
            {
                if (operands.peek() == 0)
                    throw new IllegalArgumentException();

                float temp = operands.pop();
                result = operands.pop() / temp;
                operands.push(result);
            }
            else
            {
                operands.push(Float.parseFloat(tokens[tracker]));
            }
        }
        return result;
    }
}
