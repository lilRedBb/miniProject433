package org.example;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        org.example.Products.ProductTest.class,
        org.example.Products.LaptopTest.class,
        org.example.Other.AmountAndPriceTest.class,
        org.example.Storage.StorageTest.class,
        org.example.Storage.DefaultProductFactoryTest.class,
        org.example.UI.productBannerTest.class,
        org.example.UI.UserInputTest.class,
        org.example.User.RegularUserTest.class,
        org.example.CheckOut.CheckOutTest.class,
        org.example.CheckOut.VipCheckoutTest.class,
        org.example.Cart.CartAssembleTest.class,
        org.example.Cart.CartDisplayTest.class,
        org.example.Cart.UserCartTest.class,


})

public class AllTest {

}