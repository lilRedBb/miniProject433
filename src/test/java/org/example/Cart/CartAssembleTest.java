package org.example.Cart;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class CartAssembleTest {

    private CartAssemble cartAssemble;

    @Before
    public void setUp() {
        cartAssemble = new CartAssemble();
    }

    @Test
    public void testCreatesUserCartNotNull() {

        UserCart cart = cartAssemble.genCart();

        // Assert: Verify that the returned cart is not null
        assertNotNull("cart is not null",cart);
    }
    @Test
    public void testAttachesCartDisplayObserver() {

        UserCart cart = cartAssemble.genCart();

        assertTrue( "The observer should be an instance of CartDisplay",cart.getObservers().get(0) instanceof CartDisplay);
    }


}
