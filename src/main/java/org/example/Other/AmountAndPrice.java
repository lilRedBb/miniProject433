package org.example.Other;

public class AmountAndPrice {
    private Integer amount;
    private double price;

    private String productID;

    public AmountAndPrice(Integer amount, double price, String productID){
        this.amount = amount;
        this.price = price;
        this.productID = productID;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getAmount() {
        return amount;
    }

    public double getPrice() {
        return price;
    }

    public String getProductID(){
        return productID;
    }
}
