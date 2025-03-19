package org.example.CheckOut;

import org.example.User.RegularUser;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CheckOutTest {

    private DefaultCheckout checkout = new DefaultCheckout(new RegularUser());

    @Test
    public void testApplyDiscountForRegular(){
        assertEquals(900,checkout.applyDiscount(900),0.0001);
    }

    @Test
    public void testGetFinalTotalIsAccurate(){
        double total = checkout.getFinalTotal(1000,"no");
        boolean totalIsAccurate = (total==1000)||(total==1060);
        assertTrue(totalIsAccurate);
    }

    @Test
    public void testNextDayShipmentAdded(){
        double total = checkout.getFinalTotal(1000,"nextDay");
        boolean totalIsAccurate = (total==1025)||(total==1085);
        assertTrue(totalIsAccurate);
    }

    @Test
    public void testNextStandardShipmentAdded(){
        double total = checkout.getFinalTotal(40,"no");

        boolean totalIsAccurate = (total==50)||(Math.abs(total-52.4)<0.1);
        assertTrue(totalIsAccurate);
    }

    @Test
    public void testMinTotal(){
        double total = checkout.getFinalTotal(0.8,"no");
        boolean totalIsAccurate = (total==0);
        assertTrue(totalIsAccurate);
    }

    @Test
    public void testMaxTotal(){
        double total = checkout.getFinalTotal(99999.999,"no");
        boolean totalIsAccurate = (total==100000);
        assertTrue(totalIsAccurate);
    }

    //test boundary
    @Test
    public void testStandardShipmentForExact50() {
        double total = checkout.getFinalTotal(50, "no");
        boolean totalIsAccurate = (total == 50) || (Math.abs(total - 53) < 0.1); //
        assertTrue(totalIsAccurate);
    }

    @Test
    public void testMinTotalForExact1() {
        double total = checkout.getFinalTotal(1, "no");

        boolean totalIsAccurate = (total == 11) || (Math.abs(total - 11.06) < 0.1);
        assertTrue(totalIsAccurate);
    }

    @Test
    public void testMaxTotalForExact99999_99() {
        double total = checkout.getFinalTotal(99999.99, "no");

        boolean totalIsAccurate = (total == 99999.99) || (Math.abs(total - 105999.9) < 0.1);
        assertTrue(totalIsAccurate);
    }


    //test when total is too small or big, will getFinaltotal return the correct value back
    @Test
    public void testMinTotalForLessThan1() {
        double total = checkout.getFinalTotal(0.5, "no");
        assertEquals(0, total, 0.0001);
    }

    @Test
    public void testMaxTotalForGreaterThan99999_99() {
        double total = checkout.getFinalTotal(100000, "no");
        assertEquals(100000, total, 0.0001);
    }

}
