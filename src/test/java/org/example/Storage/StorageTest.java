package org.example.Storage;

import org.example.Products.*;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class StorageTest {
    private Storage storage;
    private ProductFactory productFactory;

    @Before
    public void setUp() {
        productFactory = new DefaultProductFactory();
        storage = new Storage(productFactory);
    }
    @Test
    public void testConstructor() {
        // Assert
        assertNotNull(storage.getCatalog());
        assertEquals(4, storage.getCatalog().size());
        assertEquals(4, storage.getCounter());
    }

    @Test
    public void testPopulateStorage() {


        Map<Integer, Product> catalog = storage.getCatalog();
        boolean containsLaptop = catalog.values().stream().anyMatch(p -> p instanceof Laptop);
        boolean containsTV = catalog.values().stream().anyMatch(p -> p instanceof TV);
        boolean containsProduce = catalog.values().stream().anyMatch(p -> p instanceof Produce);
        boolean containsCleaningStuff = catalog.values().stream().anyMatch(p -> p instanceof CleaningStuff);

        assertTrue(containsLaptop); // Verify laptop is in the catalog
        assertTrue(containsTV); // Verify TV is in the catalog
        assertTrue(containsProduce); // Verify produce is in the catalog
        assertTrue(containsCleaningStuff); // Verify cleaningStuff is in the catalog
    }

    @Test
    public void testAddNullAsProduct(){
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> storage.addProduct(null) // 传入 null
        );

        // Verify the exception message
        assertEquals("Product cannot be null", exception.getMessage());
    }

    @Test
    public void testProductIndexFull(){
        Laptop laptop = mock(Laptop.class);
        storage.setCounter(Integer.MAX_VALUE);

        IllegalStateException exception = assertThrows(
                IllegalStateException.class,
                () -> storage.addProduct(laptop) // 传入 null
        );

        // Verify the exception message
        assertEquals("Catalog is full", exception.getMessage());
    }

    @Test
    public void testIsWithinIndex(){
        assertFalse(storage.isWithinCatalogIndex(5));
    }

    @Test
    public void testIsWithinIndexForMaxBoundary(){
        assertTrue(storage.isWithinCatalogIndex(4));
    }

}
