package edu.trinity;

public class Fibonacci {

    public static int calculate(int i)
    {
        int result = 0;
        int prev = result;
        while (i > 0)
        {
            if (result == 0)
            {
                prev = 0;
                result = 1;
            }
            else
            {
                result += prev;
                prev = result - prev;
            }
            i--;
        }
        return result;
    }
}
