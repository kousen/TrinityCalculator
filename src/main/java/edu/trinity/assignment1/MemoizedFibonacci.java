package edu.trinity.assignment1;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Optional;

// The first Fibonacci number that overflows a Java int is 2971215073,
// which is the 47th Fibonacci number.

// The first Fibonacci number that overflows a Java long is 12200160415121876738,
// which is the 93rd Fibonacci number.

// Therefore use java.lang.BigInteger to store the Fibonacci numbers.

@SuppressWarnings({"unchecked", "OptionalGetWithoutIsPresent"})
public class MemoizedFibonacci {
    private final Optional<BigInteger>[] memo;

    public MemoizedFibonacci(int n) {
        // Create an Optional array, filled with empty Optionals
        //
        // Please note, because of Java's type erasure, you cannot directly create an
        // array of a generic type (like Optional<BigInteger>[]). That's why it's
        // unavoidable to use an unchecked cast (Optional<BigInteger>[]) new Optional[n + 1];.
        // This unchecked cast is safe in this case because we are not leaking this
        // reference outside of the class.

        memo = (Optional<BigInteger>[]) new Optional[n + 1];
        Arrays.fill(memo, Optional.empty());

        // Base cases
        memo[0] = Optional.of(BigInteger.ZERO);
        if (n > 0)
            memo[1] = Optional.of(BigInteger.ONE);
    }

    public BigInteger calculate(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n must be non-negative");
        }

        if (memo[n].isPresent()) return memo[n].get();

        memo[n] = Optional.of( calculate(n - 1).add(calculate(n - 2)) );
        return memo[n].get();
    }
}