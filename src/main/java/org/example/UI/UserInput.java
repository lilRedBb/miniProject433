package org.example.UI;
import org.example.Cart.UserCart;
import org.example.Products.Product;
import org.example.Storage.Storage;

import java.util.Map;
import java.util.Scanner;

public class UserInput {

    UserCart userCart = new UserCart();
    Map<Integer, Product> allItems = Storage.getAllItems();

    int maxCurrentProductID = Storage.getCounter();

    public void inputInterface(){
        Scanner scanner = new Scanner(System.in);

        while (true){

            String input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Exiting...");
                break;
            }

            String[] parts = input.split("\\s+");

            String command = parts[0];
            int number = 0;

            if (parts.length >= 2){
                try {
                    number = Integer.parseInt(parts[1]);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid number format. Please enter a valid integer.");
                    continue;
                }

            }

            if (number > maxCurrentProductID){
                System.out.println("there is no such product that has this productID");
                continue;
            }


            switch (command.toLowerCase()) {
                case "add":
                    userCart.addToCart(allItems.get(number));
                    break;
                case "del":
                    userCart.removeFromCart(allItems.get(number));
                    break;
                case "show":
                    userCart.whatsInCart();
                    break;
                default:
                    System.out.println("Unknown command. Use 'add' or 'del' or 'show or 'check''");
            }
        }

        scanner.close();


        }


}
