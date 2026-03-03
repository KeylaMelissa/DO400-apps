package com.redhat.simple.calculator;

public final class AdvancedCalculator {
    public static final double PI = 3.14;
    public static final double LOW_DISCOUNT_AMOUNT = 0.10;
    public static final double MID_DISCOUNT_AMOUNT = 0.15;
    public static final double HIGH_DISCOUNT_AMOUNT = 0.20;
    public static final double VIP_DISCOUNT_AMOUNT = 0.25;
    public static final double MINIMUM_PURCHASE_AMOUNT = 10;
    public static final double LOW_PURCHASE_AMOUNT = 100;
    public static final double HIGH_PURCHASE_AMOUNT = 3000;
    public static final int BRONZE_CUSTOMER_SEGMENT = 1;
    public static final int SILVER_CUSTOMER_SEGMENT = 2;
    public static final int GOLD_CUSTOMER_SEGMENT = 3;

    public int divide(final int dividend, final int divisor) {
        if (divisor == 0) {
            return Integer.MAX_VALUE;
        } else {
            return dividend / divisor;
        }
    }

    public int subs(final int minuend, final int subtrahend) {
        return minuend - subtrahend;
    }

    public int sum(final int addendA, final int addendB) {
        return addendA + addendB;
    }

    public int multiply(final int multiplicand, final int multiplier) {
        return multiplicand * multiplier;
    }

    public double circumference(final int r) {
        return 2 * PI * r;
    }

    public boolean isGreaterThan(final int a, final int b) {
        return a > b;
    }

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
