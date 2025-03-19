package org.example.CheckOut;

import org.example.Cart.UserCart;
import org.example.User.UserInfo;

public class DefaultCheckout extends CheckOut{
    public DefaultCheckout(UserInfo userInfo) {
        super(userInfo);
    }

    @Override
    public double applyDiscount(double currentTotal) {
        return currentTotal+shipment;
    }
}
