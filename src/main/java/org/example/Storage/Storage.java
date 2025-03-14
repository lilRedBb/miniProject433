package org.example.Storage;

import org.example.Products.*;

import java.util.HashMap;
import java.util.Map;


public class Storage {

    private static Map<Integer,Product> allItems = new HashMap<>();

    private static int counter = 1;

    static {populateStorage();}

    private static void populateStorage() {
        Product laptop = new Laptop.Builder().id("1").name("Dell XPS")
                .price(200).warrantyInMonths(24).processor("AMD x329").build();
        Product TV = new TV.Builder().id("2").name("LG OASIS")
                .price(1200).warrantyInMonths(36).screenSize("70 Inch").build();
        Product produce = new Produce.Builder().id("3").name("Potato").price(0.9).freshDay(7).build();

        Product cleaningStuff = new CleaningStuff.Builder().id("4").name("Hand soap").price(3).ingredient("Aloe").build();

        addProduct(laptop);
        addProduct(TV);
        addProduct(produce);
        addProduct(cleaningStuff);
    }

    public static void addProduct(Product product) {
        allItems.put(counter++,product);
    }

    public static Map<Integer,Product> getAllItems(){
        return allItems;
    }

    public static int getCounter(){
        return counter;
    }






}
