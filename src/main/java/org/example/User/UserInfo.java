package org.example.User;

import org.example.Other.USState;

public abstract class UserInfo {


    private double taxRate = 1;

    private USState userState;


    public UserInfo(){
        USState randomState = USState.getRandomState();
        userState = randomState;
        if (randomState.equals(USState.NEW_YORK) ||
                randomState.equals(USState.ILLINOIS) ||
                randomState.equals(USState.CALIFORNIA)) {
            setTaxRate(1.06);
        }

    }



    public void setTaxRate(double stateTaxRate){
        this.taxRate = stateTaxRate;
    }

    public double getTaxRate(){
        return taxRate;
    }

    public USState getUserState(){return userState;}

}
