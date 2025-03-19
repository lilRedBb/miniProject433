package org.example.CheckOut;

import org.example.User.RegularUser;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VipCheckoutTest {

    private VipCheckout checkout = new VipCheckout(new RegularUser());

    @Test
    public void testApplyDiscountForVIP(){
        assertEquals(720,checkout.applyDiscount(900),0.0001);
    }
    @Test
    public void testApplyDiscountForZeroTotal() {



        double currentTotal = 0;
        double expectedTotal = 0 * 0.8; // 0 + 10 = 10
        assertEquals(expectedTotal, checkout.applyDiscount(currentTotal), 0.0001);
    }

    @Test
    public void testApplyDiscountForNegativeTotal() {



        double currentTotal = -100;
        double expectedTotal = 0; // -80 + 10 = -70
        assertEquals(expectedTotal, checkout.applyDiscount(currentTotal), 0.0001);
    }
}
