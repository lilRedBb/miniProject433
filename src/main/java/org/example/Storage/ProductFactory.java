package org.example.Storage;
import org.example.Products.Product;
public interface ProductFactory {


        Product createLaptop();
        Product createTV();
        Product createProduce();
        Product createCleaningStuff();

}
