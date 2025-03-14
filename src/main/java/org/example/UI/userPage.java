package org.example.UI;

import org.example.Cart.UserCart;
import org.example.Products.Product;
import org.example.Storage.Storage;

import java.util.Map;

public class userPage {

    public static void main(String[] args) {
        Map<Integer,Product> allItems = Storage.getAllItems();
        productBanner.showBanner(allItems);
        UserGuide.printGuide();

        UserInput userInput = new UserInput();
        userInput.inputInterface();



    }





}
