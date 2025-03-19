package org.example.Cart;

import org.example.Other.AmountAndPrice;
import org.example.Other.DefaultProductInfo;
import org.example.Other.ElectronicInfo;
import org.example.Products.Electronics;
import org.example.Products.Product;

import java.util.*;

public class UserCart {

    private Map<String, AmountAndPrice> myCart = new HashMap<>();

    private final List<CartObserver> observers = new ArrayList<>();


    public UserCart(){


    }


    public void addToCart(Product product){
        //int idToAdd = Integer.parseInt(product.getId());
        if (product==null)return;
        AmountAndPrice productInfo = createAmountAndPriceItem(product);
        updateCart(product.getName(),productInfo,1);

    }

    public void removeFromCart(Product product){
        //int idToAdd = Integer.parseInt(product.getId());
        if (product==null)return;
        updateCart(product.getName(),null, -1);

    }

    private void updateCart(String productName,AmountAndPrice productInfo, int quantityChange){

        AmountAndPrice existingItem = myCart.get(productName);

        int quantityToBe;
        if (existingItem == null && quantityChange>0){
            myCart.put(productName,productInfo);
        }else if(existingItem !=null) {
            quantityToBe = existingItem.getAmount()+quantityChange;
            if (quantityToBe > 0){
                existingItem.setAmount(quantityToBe);
            }else {
                myCart.remove(productName);
            }
        }

        notifyObservers(myCart);

    }

    public double whatsMyTotal(){
        //return observers.get(0).currentTotalCostInCart(myCart);
        double currentTotal = 0;
        for (AmountAndPrice amountAndPrice : myCart.values()) {
            currentTotal += (amountAndPrice.getAmount()*amountAndPrice.getPrice());
        }
        return currentTotal;

    }

    AmountAndPrice createAmountAndPriceItem(Product product) {
        if (product instanceof Electronics) {
            return new ElectronicInfo(1, product.getPrice(), product.getId(), 12);
        }
         else {
            return new DefaultProductInfo(1, product.getPrice(), product.getId());
        }
    }


    public void whatsInCart() {
        // Print the header with correct format specifiers
      notifyObservers(myCart);
    }

    public Map<String, AmountAndPrice> getMyCart() {
        return Collections.unmodifiableMap(myCart);
    }

    public void clearCart(){
        myCart.clear();
    }

    public void addObserver(CartObserver observer) {
        observers.add(observer);
    }

    // 移除观察者
    public void removeObserver(CartObserver observer) {
        observers.remove(observer);
    }

    public List<CartObserver> getObservers(){
        return Collections.unmodifiableList(observers);
    }

    // 通知所有观察者
    void notifyObservers(Map<String, AmountAndPrice> myCartNow) {
        for (CartObserver observer : observers) {
            observer.onCartUpdated(myCartNow);
        }
    }








}
