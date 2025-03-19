package org.example.Other;

import org.junit.Before;
import org.junit.Test;


import java.io.PrintStream;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;


public class AmountAndPriceTest {
    private ElectronicInfo amountAndPrice;



    @Before
    public void setUp(){
        amountAndPrice = new ElectronicInfo(10, 19.99, "12", 24);

    }

    @Test
    public void testGetAmount() {
        // Act
        int amount = amountAndPrice.getAmount();

        // Assert
        assertEquals(10, amount,0.1);
    }

    @Test
    public void testGetPrice() {
        // Act
        double price = amountAndPrice.getPrice();

        // Assert
        assertEquals(19.99, price, 0.001);
    }

    @Test
    public void testGetProductID() {
        // Act
        String productID = amountAndPrice.getProductID();

        // Assert
        assertEquals("12", productID);
    }

    @Test
    public void testSetAmount() {
        // Act
        amountAndPrice.setAmount(20);

        // Assert
        assertEquals(20, (int) amountAndPrice.getAmount());
    }

    @Test
    public void testDisplayProductInfo(){

        String display = amountAndPrice.displayProductInfo();
        assertTrue(display.contains("10"));
        assertTrue(display.contains("19.99"));
        assertTrue(display.contains("12"));
        assertTrue(display.contains("24"));



    }




}
