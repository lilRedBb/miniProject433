package org.example.Cart;

public class CartAssemble {
    private UserCart cart;

    public CartAssemble(){
        cart = new UserCart();
        cart.addObserver(new CartDisplay());

    }

    public UserCart genCart(){
        return cart;
    }
}
