package org.example.Other;

public class ElectronicInfo extends AmountAndPrice{

    private int warrantyPeriod;
    public ElectronicInfo(Integer amount, double price, String productID,int warrantyPeriod)
    {
        super(amount, price, productID);
        this.warrantyPeriod = warrantyPeriod;
    }

    public int getWarrantyPeriod() {
        return warrantyPeriod;
    }


    public String displayProductInfo(){

        return String.format(" %-15d %-10.2f %-15s %-10d",

                this.getAmount(),
                this.getPrice(),
                this.getProductID(),
                this.getWarrantyPeriod()
        );
    }
}
