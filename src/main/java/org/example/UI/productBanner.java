package org.example.UI;

import org.example.Products.Product;

import java.util.Map;

public class productBanner {

    public static void showBanner(Map<Integer,Product> allItems){
        System.out.printf("%-15s %-20s  %-10s%n", "Product ID", "Product Name", "Price");
        System.out.println("------------------------------------------------------------------------");

        // Print table rows
        allItems.forEach((id,product) ->
                System.out.printf("%-15s %-20s  %-10.2f%n",
                        product.getId(),
                        product.getName(),
                        product.getPrice())
        );
    }

}
