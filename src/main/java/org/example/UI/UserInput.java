package org.example.UI;
import org.example.CheckOut.CheckOut;
import org.example.Cart.UserCart;
import org.example.Products.Product;
import org.example.Storage.Storage;

import java.util.Map;
import java.util.Scanner;

public class UserInput {
    private final UserCart userCart;
    private final Storage storage;
    private final CheckOut checkOut;

    public UserInput(Storage storage,CheckOut checkOut, UserCart userCart) {
        this.storage = storage;
        this.userCart = userCart;
        this.checkOut = checkOut;
    }

    public void inputInterface(){
        Scanner scanner = new Scanner(System.in);

        while (true){

            String input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("exit")) {
                handleExitCommand();
                break;
            }


            String command = inputHeadParser(input);

            int number = inputNumberParser(input);
            if (number == -1)continue;



            if (!storage.isWithinCatalogIndex(number)){
                System.out.println("there is no such product that has this productID");
                continue;
            }



            switch (command.toLowerCase()) {
                case "add":
                    handleAddCommand(number,storage.getCatalog());
                    break;
                case "del":
                    handleDeleteCommand(number,storage.getCatalog());
                    break;
                case "show":
                    handleShowCommand();
                    break;
                case "check":
                    handleCheckCommand(scanner);
                    break;
                default:
                    System.out.println("Unknown command. Use 'add' or 'del' or 'show or 'check''");
            }
        }

        scanner.close();


        }

    void handleAddCommand(int productID, Map<Integer, Product> catalog) {

        userCart.addToCart(catalog.get(productID));
        System.out.println("item added");
    }

    void handleDeleteCommand(int productID, Map<Integer, Product> catalog) {
        userCart.removeFromCart(catalog.get(productID));
        System.out.println("one item removed");
    }

    void handleShowCommand() {

        userCart.whatsInCart();
        System.out.println("current total is: "+ checkOut.getFinalTotal(userCart.whatsMyTotal(), "standard"));
        System.out.println("Shipment cost: standard = 10$, nextDay = 25$, any order >= 50 will not charge for standard delivery ");
    }

    void handleCheckCommand(Scanner scanner){
        System.out.print("type 'yes' for nextDay shipment(25)$, 'no' for standard shipment(10$) ");
        String shipmentResponse = scanner.nextLine().trim().equalsIgnoreCase("yes")?"nextDay":"standard";

        double finalCost = checkOut.getFinalTotal(userCart.whatsMyTotal(),shipmentResponse );
        if (finalCost==0 ||finalCost ==100000){
            System.out.println("your total cost is too small or too big, 1<= your cost < 100000");
            return;
        }
        System.out.printf("your final total is: %-15.2f%n transaction complete", finalCost);
        userCart.clearCart();


    }

    void handleExitCommand(){
        System.out.println("Exiting...");
    }

    String inputHeadParser(String input){
        String[] parts = input.split("\\s+");
        return parts[0];

    }

    int inputNumberParser(String input){
        String[] parts = input.split("\\s+");
        if (parts.length >= 2){
            try {
                return Integer.parseInt(parts[1]);
            } catch (NumberFormatException e) {
                System.out.println("Invalid number format. Please enter a valid integer.");
                return -1;
            }

        }
        return -2;

    }
    public Storage getStorage() {
        return storage;
    }

    public CheckOut getCheckOut() {
        return checkOut;
    }

    public UserCart getUserCart() {
        return userCart;
    }


}
