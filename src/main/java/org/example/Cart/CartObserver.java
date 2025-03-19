package org.example.Cart;

import org.example.Other.AmountAndPrice;

import java.util.Map;

public interface CartObserver {
    void onCartUpdated(Map<String, AmountAndPrice> cart);


}
