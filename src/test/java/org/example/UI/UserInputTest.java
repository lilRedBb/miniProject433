package org.example.UI;

import org.example.Cart.UserCart;
import org.example.CheckOut.CheckOut;
import org.example.Products.Product;
import org.example.Storage.Storage;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static org.mockito.Mockito.*;

public class UserInputTest {

    @Mock
    private Storage storage;

    @Mock
    private CheckOut checkOut;

    @Mock
    private UserCart userCart;

    private UserInput userInput;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        userInput = new UserInput(storage, checkOut, userCart);
    }

    @Test
    public void testConstructorInitialization() {
        // Arrange
        Storage storage = mock(Storage.class);
        CheckOut checkOut = mock(CheckOut.class);
        UserCart userCart = mock(UserCart.class);

        // Act
        UserInput userInput = new UserInput(storage, checkOut, userCart);

        // Assert
        assert userInput.getStorage() == storage;
        assert userInput.getCheckOut() == checkOut;
        assert userInput.getUserCart() == userCart;
    }

    @Test
    public void testHandleAddCommand() {
        // Arrange
        int productId = 1;
        Product product = mock(Product.class);
        Map<Integer, Product> catalog = new HashMap<>();
        catalog.put(productId, product);

        // Act
        userInput.handleAddCommand(productId, catalog);

        // Assert
        verify(userCart).addToCart(product);
    }

    @Test
    public void testHandleDeleteCommand() {
        // Arrange
        int productId = 1;
        Product product = mock(Product.class);
        Map<Integer, Product> catalog = new HashMap<>();
        catalog.put(productId, product);

        // Act
        userInput.handleDeleteCommand(productId, catalog);

        // Assert
        verify(userCart).removeFromCart(product);
    }

    @Test
    public void testHandleShowCommand() {
        // Act
        userInput.handleShowCommand();

        // Assert
        verify(userCart).whatsInCart();
    }

    @Test
    public void testHandleCheckCommand() {
        // Arrange
        Scanner scanner = new Scanner("yes\n"); // Simulate user input
        when(userCart.whatsMyTotal()).thenReturn(100.0);
        //when(checkOut.getFinalTotal(100.0, "nextDay")).thenReturn(125.0);

        // Act
        userInput.handleCheckCommand(scanner);

        // Assert
        verify(checkOut).getFinalTotal(100.0, "nextDay");

    }

    @Test
    public void testInputHeadParser() {
        // Arrange
        String input = "add 1";

        // Act
        String command = userInput.inputHeadParser(input);

        // Assert
        assert command.equals("add");
    }

    @Test
    public void testInputNumberParser() {
        // Arrange
        String input = "add 1";

        // Act
        int number = userInput.inputNumberParser(input);

        // Assert
        assert number == 1;
    }

    @Test
    public void testInputNumberParserInvalid() {
        // Arrange
        String input = "add invalid";

        // Act
        int number = userInput.inputNumberParser(input);

        // Assert
        assert number == -1;
    }

    @Test
    public void testInputNumberParserNoNumber() {
        // Arrange
        String input = "show";

        // Act
        int number = userInput.inputNumberParser(input);

        // Assert
        assert number == -2;
    }


}