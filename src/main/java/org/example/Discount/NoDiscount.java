package org.example.Discount;

public class NoDiscount implements DiscountStretagy{

    @Override
    public double applyDiscount(double price) {
        return price;
    }
}
