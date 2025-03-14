package org.example.Cart;

import org.example.Other.AmountAndPrice;
import org.example.Products.Product;

import java.util.HashMap;
import java.util.Map;

public class UserCart {

    private Map<String, AmountAndPrice> myCart = new HashMap<>();


    public void addToCart(Product product){
        //int idToAdd = Integer.parseInt(product.getId());
        if (product==null)return;

        String productName = product.getName();
        if (myCart.containsKey(productName)){
            Integer currentAmount = myCart.get(productName).getAmount();
            myCart.get(productName).setAmount(currentAmount+1);
        }else {
            myCart.put(productName,new AmountAndPrice(1,product.getPrice(), product.getId()));
        }


    }

    public void removeFromCart(Product product){
        //int idToAdd = Integer.parseInt(product.getId());
        if (product==null)return;

        String productName = product.getName();
        if (myCart.containsKey(productName)){
            if (myCart.get(productName).getAmount()>1){
                Integer currentAmount = myCart.get(productName).getAmount();
                myCart.get(productName).setAmount(currentAmount-1);

            } else if(myCart.get(productName).getAmount() == 1) {

                myCart.remove(productName);

            }

        }


    }

    private double whatsMyTotal(){
        double currentTotal = 0;
        for (AmountAndPrice amountAndPrice : myCart.values()) {
            currentTotal += (amountAndPrice.getAmount()*amountAndPrice.getPrice());
        }
        return currentTotal;

    }


    public void whatsInCart() {
        // Print the header with correct format specifiers
        System.out.printf("%-15s %-15s %-10s %-15s%n", "Product Name", "Amount", "Price", "Product ID");

        // Print the actual cart contents
        myCart.forEach((productName, amountAndPrice) ->
                System.out.printf("%-15s %-15d %-10.2f %-15s%n",
                        productName,
                        amountAndPrice.getAmount(),
                        amountAndPrice.getPrice(),
                        amountAndPrice.getProductID()
                )
        );

        System.out.println("your current total is: "+ whatsMyTotal());
    }








}
