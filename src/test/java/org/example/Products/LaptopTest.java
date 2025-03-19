package org.example.Products;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LaptopTest {
    private Laptop laptop;

    @Before
    public void setUp(){
        laptop = new Laptop.Builder().id("1").name("soap")
                .price(12).warrantyInMonths(12).processor("AMD").build();
    }

    @Test
    public void testGetWarranty(){
        assertEquals(12,laptop.getWarrantyInMonths());
    }
    @Test
    public void testGetProcessor(){
        assertEquals("AMD",laptop.getProcessor());
    }
    @Test
    public void testSetWarranty(){
        laptop.setWarrantyInMonths(24);
        assertEquals(24,laptop.getWarrantyInMonths());
    }



}
