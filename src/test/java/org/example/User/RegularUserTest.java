package org.example.User;

import org.example.Other.USState;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class RegularUserTest {

    private RegularUser regularUser;

    @Before
    public void setUp(){
        regularUser = new RegularUser();
    }

    @Test
    public void testTaxState(){
        USState userState = regularUser.getUserState();
        if(userState.equals(USState.NEW_YORK) ||
                userState.equals(USState.ILLINOIS) ||
                userState.equals(USState.CALIFORNIA)){
            assertEquals(1.06,regularUser.getTaxRate(),0.01);
        } else{

            assertEquals(1,regularUser.getTaxRate(),0.1);
        }
    }
    @Test
    public void testSetTaxRate() {
        UserInfo userInfo = new UserInfo() {};
        userInfo.setTaxRate(1.1);
        assertEquals(1.1, userInfo.getTaxRate(), 0.0001);
    }

    @Test
    public void testGetUserState() {
        UserInfo userInfo = new UserInfo() {};
        USState state = userInfo.getUserState();
        assertNotNull(state); // 确保返回值不为 null
    }

}
