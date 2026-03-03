package com.redhat.simple.calculator;

import java.util.Random;

/**
 * Basic calculator that provides arithmetic operations.
 */
public final class BasicCalculator {

    /**
     * Divides two integers.
     *
     * @param dividend the number to be divided
     * @param divisor the number to divide by
     * @return the division result or Integer.MAX_VALUE if divisor is zero
     */
    public int divide(final int dividend, final int divisor) {
        if (divisor == 0) {
            return Integer.MAX_VALUE;
        } else {
            return dividend / divisor;
        }
    }

    /**
     * Subtracts one number from another.
     *
     * @param minuend the number from which another number is subtracted
     * @param subtrahend the number to subtract
     * @return the subtraction result
     */
    public int subs(final int minuend, final int subtrahend) {
        return minuend - subtrahend;
    }

    /**
     * Adds two numbers.
     *
     * @param addendA first number
     * @param addendB second number
     * @return the sum of both numbers
     */
    public int sum(final int addendA, final int addendB) {
        return addendA + addendB;
    }

    /**
     * Multiplies two numbers.
     *
     * @param multiplicand first number
     * @param multiplier second number
     * @return the multiplication result
     */
    public int multiply(final int multiplicand, final int multiplier) {
        return multiplicand * multiplier;
    }

    /**
     * Generates a random integer.
     *
     * @return a random integer value
     */
    public int random() {
        final Random random = new Random();
        return random.nextInt();
    }
}
