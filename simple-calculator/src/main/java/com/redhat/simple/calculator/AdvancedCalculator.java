package com.redhat.simple.calculator;

/**
 * Provides advanced mathematical and business-related calculations.
 */
public final class AdvancedCalculator {

    /** Value of PI constant. */
    private static final double PI = 3.14;

    /** Discount for low purchase amounts. */
    private static final double LOW_DISCOUNT_AMOUNT = 0.10;

    /** Discount for mid purchase amounts. */
    private static final double MID_DISCOUNT_AMOUNT = 0.15;

    /** Discount for high purchase amounts. */
    private static final double HIGH_DISCOUNT_AMOUNT = 0.20;

    /** Discount for VIP customers. */
    private static final double VIP_DISCOUNT_AMOUNT = 0.25;

    /** Minimum purchase amount required for discount eligibility. */
    private static final double MINIMUM_PURCHASE_AMOUNT = 10;

    /** Threshold for low purchase amount. */
    private static final double LOW_PURCHASE_AMOUNT = 100;

    /** Threshold for high purchase amount. */
    private static final double HIGH_PURCHASE_AMOUNT = 3000;

    /** Bronze customer segment identifier. */
    private static final int BRONZE_CUSTOMER_SEGMENT = 1;

    /** Silver customer segment identifier. */
    private static final int SILVER_CUSTOMER_SEGMENT = 2;

    /** Gold customer segment identifier. */
    private static final int GOLD_CUSTOMER_SEGMENT = 3;

    /**
     * Divides two integers.
     *
     * @param dividend number to be divided
     * @param divisor number to divide by
     * @return division result or Integer.MAX_VALUE if divisor is zero
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
     * @param minuend number from which another number is subtracted
     * @param subtrahend number to subtract
     * @return subtraction result
     */
    public int subs(final int minuend, final int subtrahend) {
        return minuend - subtrahend;
    }

    /**
     * Adds two numbers.
     *
     * @param addendA first number
     * @param addendB second number
     * @return sum of the numbers
     */
    public int sum(final int addendA, final int addendB) {
        return addendA + addendB;
    }

    /**
     * Multiplies two numbers.
     *
     * @param multiplicand first number
     * @param multiplier second number
     * @return multiplication result
     */
    public int multiply(final int multiplicand, final int multiplier) {
        return multiplicand * multiplier;
    }

    /**
     * Calculates the circumference of a circle.
     *
     * @param r radius of the circle
     * @return circumference value
     */
    public double circumference(final int r) {
        return 2 * PI * r;
    }

    /**
     * Checks if one number is greater than another.
     *
     * @param a first number
     * @param b second number
     * @return true if a is greater than b, otherwise false
     */
    public boolean isGreaterThan(final int a, final int b) {
        return a > b;
    }

    /**
     * Calculates discount based on sale amount, customer seniority and type.
     *
     * @param saleAmount total sale amount
     * @param yearsAsCustomer number of years as customer
     * @param isBusiness indicates if the customer is a business
     * @return discount percentage value
     */
    public double discount(final double saleAmount,
                           final int yearsAsCustomer,
                           final boolean isBusiness) {

        double discount = 0;

        if (saleAmount < MINIMUM_PURCHASE_AMOUNT
                || yearsAsCustomer < BRONZE_CUSTOMER_SEGMENT) {
            return 0;
        }

        if (saleAmount < LOW_PURCHASE_AMOUNT) {
            if (isBusiness) {
                discount = LOW_DISCOUNT_AMOUNT;
            } else {
                if (yearsAsCustomer > GOLD_CUSTOMER_SEGMENT) {
                    discount = MID_DISCOUNT_AMOUNT;
                } else {
                    discount = LOW_DISCOUNT_AMOUNT;
                }
            }
        } else if (saleAmount > HIGH_PURCHASE_AMOUNT) {
            if (isBusiness) {
                discount = VIP_DISCOUNT_AMOUNT;
            } else {
                switch (yearsAsCustomer) {
                    case BRONZE_CUSTOMER_SEGMENT:
                        discount = LOW_DISCOUNT_AMOUNT;
                        break;
                    case SILVER_CUSTOMER_SEGMENT:
                        discount = MID_DISCOUNT_AMOUNT;
                        break;
                    case GOLD_CUSTOMER_SEGMENT:
                        discount = HIGH_DISCOUNT_AMOUNT;
                        break;
                    default:
                        discount = VIP_DISCOUNT_AMOUNT;
                        break;
                }
            }
        }

        return discount;
    }
}