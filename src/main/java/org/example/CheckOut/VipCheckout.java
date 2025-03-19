package org.example.CheckOut;

import org.example.User.UserInfo;

public class VipCheckout extends CheckOut{


    public VipCheckout(UserInfo userInfo) {
        super(userInfo);

    }

    @Override
    public double applyDiscount(double currentTotal) {
        if (currentTotal<=0)return 0;
        return currentTotal*0.8+shipment;
    }
}
