package org.example.UI;

import org.example.Cart.CartAssemble;
import org.example.CheckOut.CheckOut;
import org.example.Cart.UserCart;
import org.example.CheckOut.DefaultCheckout;
import org.example.CheckOut.VipCheckout;
import org.example.Storage.DefaultProductFactory;
import org.example.Storage.Storage;
import org.example.User.RegularUser;
import org.example.User.UserInfo;

public class userPage {

    public static void main(String[] args) {
        Storage storage = new Storage(new DefaultProductFactory());
        productBanner banner = new productBanner(storage);
        banner.showBanner();
        UserGuide.printGuide();

        UserCart cart = new CartAssemble().genCart();
        RegularUser regularUser = new RegularUser();
        UserInput userInput = new UserInput(storage,new DefaultCheckout(regularUser),cart);
        userInput.inputInterface();



    }





}
