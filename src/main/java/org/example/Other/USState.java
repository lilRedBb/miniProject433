package org.example.Other;

import java.util.Random;

public enum USState {

    CALIFORNIA,
    ILLINOIS,
    INDIANA,

    NEW_YORK,

    WYOMING;

    private static final USState[] VALUES = values();
    //values is built in method for Enum obj, for make the enums an array
    private static final Random RANDOM = new Random();

    // Method to get a random state
    public static USState getRandomState() {
        return VALUES[RANDOM.nextInt(VALUES.length)];
    }
}
