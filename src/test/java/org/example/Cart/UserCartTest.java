package org.example.Cart;

import org.example.Other.AmountAndPrice;
import org.example.Other.DefaultProductInfo;
import org.example.Other.ElectronicInfo;
import org.example.Products.Laptop;
import org.example.Products.Produce;
import org.example.Products.Product;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class UserCartTest {

    private UserCart userCart;
    private Laptop laptop;
    private Produce potato;

    @Before
    public void setUp(){
        userCart = new UserCart();
        laptop = new Laptop.Builder().id("1").name("Acer").price(30000).warrantyInMonths(24).processor("AMD").build();
        potato = new Produce.Builder().id("2").name("russel").price(0.9).freshDay(5).build();

    }

    @Test
    public void testAddProduct(){
        userCart.addToCart(laptop);

        Map<String, AmountAndPrice> myCart = userCart.getMyCart();
        assertEquals(1, myCart.size());

    }

    @Test
    public void testPriceForOneProduct(){
        userCart.addToCart(laptop);
        assertEquals(30000, userCart.whatsMyTotal(),0.0001);
    }

    @Test
    public void testPriceForSecondProduct(){
        userCart.addToCart(laptop);
        userCart.addToCart(laptop);
        assertEquals(60000, userCart.whatsMyTotal(),0.0001);
    }

    @Test
    public void testPriceForDifferentProduct(){
        userCart.addToCart(laptop);
        userCart.addToCart(potato);
        assertEquals(30000.9, userCart.whatsMyTotal(),0.0001);
    }

    @Test
    public void testPriceForRemoveOneProduct(){
        userCart.addToCart(laptop);
        userCart.addToCart(potato);
        userCart.removeFromCart(laptop);
        assertEquals(0.9, userCart.whatsMyTotal(),0.0001);
    }

    @Test
    public void testPriceForRemoveSameProduct(){
        userCart.addToCart(laptop);
        userCart.removeFromCart(laptop);
        assertEquals(0, userCart.whatsMyTotal(),0.00001);
    }

    //test if product will be removed when amount==0
    @Test
    public void testUpdateCartQuantityZero() {
        userCart.addToCart(laptop);
        userCart.addToCart(laptop);
        userCart.removeFromCart(laptop);
        userCart.removeFromCart(laptop);
        assertFalse(userCart.getMyCart().containsKey("Acer"));
    }

    @Test
    public void testClearCart(){
        userCart.addToCart(laptop);
        userCart.addToCart(potato);


        userCart.clearCart();

        assertEquals(0.0, userCart.whatsMyTotal(),0.000001);
    }

    @Test
    public void testWhatsInCart() {
        // Add products to the cart
        userCart.addToCart(laptop);
        userCart.addToCart(potato);

        assertTrue(userCart.getMyCart().containsKey("Acer"));
        assertTrue(userCart.getMyCart().containsKey("russel"));

    }

    @Test
    public void testAddObserver(){
        userCart.addObserver(new CartDisplay());
        assertEquals(1, userCart.getObservers().size());
    }

    @Test
    public void testRemoveObserver(){
        CartDisplay cartDisplay = new CartDisplay();
        userCart.addObserver(cartDisplay);
        userCart.removeObserver(cartDisplay);
        assertEquals(0, userCart.getObservers().size());
    }

    @Test
    public void testGetObserver(){
        CartDisplay cartDisplay = new CartDisplay();
        userCart.addObserver(cartDisplay);

        assertTrue(userCart.getObservers().contains(cartDisplay));
    }


    @Test
    public void testNotifyObserver(){
        UserCart userCart = new UserCart();

        // Create a temporary CartObserver using a lambda function
        Map<String, AmountAndPrice> capturedCart = new HashMap<>();
        CartObserver tempObserver = (cart) -> capturedCart.putAll(cart); // Capture the cart passed to onCartUpdated

        // Add the observer to the UserCart
        userCart.addObserver(tempObserver);

        // Create a sample cart map
        Map<String, AmountAndPrice> sampleCart = new HashMap<>();
        sampleCart.put("Laptop", new DefaultProductInfo(1, 1000.0, "1"));
        sampleCart.put("Phone", new DefaultProductInfo(1, 500.0, "2"));

        // Call the notifyObservers method
        userCart.notifyObservers(sampleCart);
        assertEquals(sampleCart, capturedCart);

    }

    @Test
    public void testNotifyObserversOnCartUpdate() {
        CartObserver mockObserver = mock(CartObserver.class);
        userCart.addObserver(mockObserver);
        userCart.addToCart(laptop);
        verify(mockObserver, times(1)).onCartUpdated(anyMap());
    }

    @Test
    public void testWhatsInCart2(){
        UserCart userCart = new UserCart();
        userCart.whatsInCart();
        // Create a temporary CartObserver using a lambda function
        Map<String, AmountAndPrice> capturedCart = new HashMap<>();
        CartObserver tempObserver = (cart) -> capturedCart.putAll(cart); // Capture the cart passed to onCartUpdated

        // Add the observer to the UserCart
        userCart.addObserver(tempObserver);

        // Create a sample cart map
        Map<String, AmountAndPrice> sampleCart = new HashMap<>();
        sampleCart.put("Laptop", new DefaultProductInfo(1, 1000.0, "1"));
        sampleCart.put("Phone", new DefaultProductInfo(1, 500.0, "2"));

        // Call the notifyObservers method
        userCart.notifyObservers(sampleCart);
        assertEquals(sampleCart, capturedCart);

    }

    //test when amount or price == 0
    @Test
    public void testWhatsMyTotalWithZeroPrice() {
        Laptop freeLaptop = new Laptop.Builder().id("3").name("FreeLaptop").price(0).warrantyInMonths(12).processor("Intel").build();
        userCart.addToCart(freeLaptop);
        assertEquals(0, userCart.whatsMyTotal(), 0.0001);
    }

    //test createAmount method will return object accordingly
    @Test
    public void testCreateAmountAndPriceItemForElectronics() {
        AmountAndPrice item = userCart.createAmountAndPriceItem(laptop);
        assertTrue(item instanceof ElectronicInfo);
    }

    @Test
    public void testCreateAmountAndPriceItemForNonElectronics() {
        AmountAndPrice item = userCart.createAmountAndPriceItem(potato);
        assertTrue(item instanceof DefaultProductInfo);
    }



}
