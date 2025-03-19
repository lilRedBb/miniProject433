package org.example.Cart;

import org.example.Other.AmountAndPrice;

import java.util.Map;

public class CartDisplay implements CartObserver{

    public void onCartUpdated(Map<String, AmountAndPrice> cart) {
        // Print the header
        System.out.printf("%-15s %-15s %-10s %-15s %-10s%n", "Product Name", "Amount", "Price", "Product ID","Details");

        // Print the cart contents
        cart.forEach((productName, amountAndPrice) ->
                System.out.printf("%-15s %-30s%n",
                        productName,
                        amountAndPrice.displayProductInfo()

                )
        );

        // Print the total
//        double total = cart.values().stream()
//                .mapToDouble(item -> item.getAmount() * item.getPrice())
//                .sum();

      //  System.out.println("Your current total is: " + currentTotal);
    }

    public double currentTotalCostInCart(Map<String, AmountAndPrice> myCart){
        double currentTotal = 0;
        for (AmountAndPrice amountAndPrice : myCart.values()) {
            currentTotal += (amountAndPrice.getAmount()*amountAndPrice.getPrice());
        }
        return currentTotal;
    }
}
