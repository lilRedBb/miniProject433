package org.example.Cart;

import org.example.Cart.CartDisplay;
import org.example.Other.AmountAndPrice;
import org.example.Other.DefaultProductInfo;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class CartDisplayTest {

    private CartDisplay cartDisplay;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUp() {

        cartDisplay = new CartDisplay();


        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testCurrentTotalCostInCart() {

        Map<String, AmountAndPrice> sampleCart = new HashMap<>();
        sampleCart.put("Laptop", new DefaultProductInfo(1, 1000.0, "1"));
        sampleCart.put("Phone", new DefaultProductInfo(1, 500.0, "2"));


        double total = cartDisplay.currentTotalCostInCart(sampleCart);


        assertEquals(1500.0, total,0.00001);
    }



    @Test
    public void testCurrentTotalCostInCart_EmptyCart() {

        Map<String, AmountAndPrice> emptyCart = new HashMap<>();


        double total = cartDisplay.currentTotalCostInCart(emptyCart);


        assertEquals(0.0, total, 0.00001);
    }


    @Test
    public void testOnCartUpdated_PrintsCorrectly() {

        Map<String, AmountAndPrice> sampleCart = new HashMap<>();
        sampleCart.put("Laptop", new DefaultProductInfo(1, 1000.0, "1"));
        sampleCart.put("Phone", new DefaultProductInfo(1, 500.0, "2"));


        cartDisplay.onCartUpdated(sampleCart);


        String output = outContent.toString();


        assertTrue(output.contains("Laptop"));
        assertTrue(output.contains("Amount"));
        assertTrue(output.contains("Price"));
        assertTrue(output.contains("Phone"));
        assertTrue(output.contains("Price"));



    }



    @org.junit.After
    public void restoreStreams() {
        System.setOut(originalOut);
    }
}