package app;

public class DiscountPolicy {
    private static final double DISCOUNT_RATE = 0.1;

    public static double calculateDiscount(double amount) {
        return amount * DISCOUNT_RATE;
    }
}