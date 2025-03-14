package org.example.Discount;

public class PercentageDiscount implements DiscountStretagy{

    private final double percentage;

    public PercentageDiscount(double percentage){
        this.percentage = percentage;
    }
    @Override
    public double applyDiscount(double price) {
        return price - (price * percentage / 100);
    }


}
