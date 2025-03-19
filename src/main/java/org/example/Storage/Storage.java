package org.example.Storage;

import org.example.Products.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class Storage {

    private final Map<Integer, Product> catalog;

    private int counter;

    public Storage(ProductFactory productFactory) {
        this.catalog = new ConcurrentHashMap<>();
        this.counter = 0;
        populateStorage(productFactory);
    }

     public void populateStorage(ProductFactory productFactory) {
        addProduct(productFactory.createLaptop());
        addProduct(productFactory.createTV());
        addProduct(productFactory.createProduce());
        addProduct(productFactory.createCleaningStuff());
    }



    public void addProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null");
        }
        if (counter == Integer.MAX_VALUE) {
            throw new IllegalStateException("Catalog is full");
        }
        catalog.put(++counter, product);
    }

    public Map<Integer, Product> getCatalog() {
        return Collections.unmodifiableMap(catalog);
    }

    public int getCounter() {
        return counter;
    }
    public void setCounter(Integer newCounter){counter=newCounter;}

    public boolean isWithinCatalogIndex(Integer indexOfOneProduct){
        return counter>=indexOfOneProduct;
    }




}
