package org.example.Storage;

import org.example.Products.*;

public class DefaultProductFactory implements ProductFactory {
    @Override
    public Laptop createLaptop() {
        return new Laptop.Builder()
                .id("1")
                .name("Dell XPS")
                .price(200)
                .warrantyInMonths(24)
                .processor("AMD x329")
                .build();
    }

    @Override
    public TV createTV() {
        return new TV.Builder()
                .id("2")
                .name("LG OASIS")
                .price(1200)
                .warrantyInMonths(36)
                .screenSize("70 Inch")
                .build();
    }

    @Override
    public Produce createProduce() {
        return new Produce.Builder()
                .id("3")
                .name("Potato")
                .price(0.9)
                .freshDay(7)
                .build();
    }

    @Override
    public CleaningStuff createCleaningStuff() {
        return new CleaningStuff.Builder()
                .id("4")
                .name("Hand soap")
                .price(30000)
                .ingredient("Aloe")
                .build();
    }
}