package org.example.Products;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProductTest {

    private CleaningStuff cleaningStuff;

    @Before
    public void setUp(){
       cleaningStuff = new CleaningStuff.Builder().id("1").name("soap")
               .price(12).ingredient("chemical").build();
    }

    @Test
    public void testGetId() {
        // Act
        String id = cleaningStuff.getId();

        // Assert
        assertEquals("1", id);
    }

    @Test
    public void testGetName() {
        // Act
        String name = cleaningStuff.getName();

        // Assert
        assertEquals("soap", name);
    }

    @Test
    public void testGetPrice() {
        // Act
        double price = cleaningStuff.getPrice();

        // Assert
        assertEquals(12, price, 0.001);
    }

    @Test
    public void testSetId() {
        // Act
        cleaningStuff.setId("456");

        // Assert
        assertEquals("456", cleaningStuff.getId());
    }

    @Test
    public void testSetName() {
        // Act
        cleaningStuff.setName("Updated Product");

        // Assert
        assertEquals("Updated Product", cleaningStuff.getName());
    }

    @Test
    public void testSetPrice() {
        // Act
        cleaningStuff.setPrice(29.99);

        // Assert
        assertEquals(29.99, cleaningStuff.getPrice(), 0.001);
    }



}
