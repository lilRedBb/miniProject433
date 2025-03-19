package org.example.CheckOut;

import org.example.Other.Shipment;
import org.example.User.UserInfo;

public abstract class  CheckOut {

    UserInfo userInfo;


    double shipment;

    public CheckOut(UserInfo userInfo){
        this.userInfo = userInfo;

    }


    public double getFinalTotal(double currentTotal, String standardNot){
        if (standardNot.equals("nextDay")){shipment=Shipment.nextDayShipment;}
        if (currentTotal<50){shipment=Shipment.standardShipment;}


        if (currentTotal<1) {return 0;}
        else if (currentTotal > 99999.99) {return 100000;}
        currentTotal*= userInfo.getTaxRate();

        return applyDiscount(currentTotal);

    }

    public  abstract  double applyDiscount(double currentTotal);





}
