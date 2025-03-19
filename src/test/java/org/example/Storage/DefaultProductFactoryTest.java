package org.example.Storage;

import org.example.Products.*;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class DefaultProductFactoryTest {
    private DefaultProductFactory factory;

    @Before
    public void setUp() {
        factory = new DefaultProductFactory();
    }

    @Test
    public void testCreateLaptop() {
        // Act
        Laptop laptop = (factory.createLaptop());


        // Assert

        assertEquals("1", laptop.getId());
        assertEquals("Dell XPS", laptop.getName());
        assertEquals(200, laptop.getPrice(), 0.001);
        assertEquals(24, (laptop).getWarrantyInMonths());

    }

    @Test
    public void testCreateTV() {
        // Act
        TV tv = factory.createTV();

        // Assert

        assertEquals("2", tv.getId());
        assertEquals("LG OASIS", tv.getName());
        assertEquals(1200, tv.getPrice(), 0.001);
        assertEquals(36, (tv).getWarrantyInMonths());

    }

    @Test
    public void testCreateProduce() {
        // Act
        Produce produce = factory.createProduce();

        // Assert

        assertEquals("3", produce.getId());
        assertEquals("Potato", produce.getName());
        assertEquals(0.9, produce.getPrice(), 0.001);
        assertEquals(7, produce.getFreshDay());
    }

    @Test
    public void testCreateCleaningStuff() {
        // Act
        CleaningStuff cleaningStuff = factory.createCleaningStuff();

        // Assert

        assertEquals("4", cleaningStuff.getId());
        assertEquals("Hand soap", cleaningStuff.getName());
        assertEquals(30000, cleaningStuff.getPrice(), 0.001);
        assertEquals("Aloe", cleaningStuff.getIngredient());
    }
}
