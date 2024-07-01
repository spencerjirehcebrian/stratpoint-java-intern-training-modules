package com.miniproject.three;

import com.miniproject.three.entity.Product;
import com.miniproject.three.entity.cart.Cart;
import com.miniproject.three.entity.products.*;
import com.miniproject.three.services.impl.CartServiceImpl;
import com.miniproject.three.services.impl.ProductServiceImpl;
import com.miniproject.three.services.impl.UserInterfaceServiceImpl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import static org.mockito.Mockito.*;

public class MainTest {

    private CartServiceImpl cartServiceMock;
    private ProductServiceImpl productServiceMock;
    private UserInterfaceServiceImpl userInterfaceMock;
    private ByteArrayOutputStream outContent;

    @Before
    public void setUp() {
        cartServiceMock = mock(CartServiceImpl.class);
        productServiceMock = mock(ProductServiceImpl.class);
        userInterfaceMock = mock(UserInterfaceServiceImpl.class);

        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testPrintWelcomeMessage() {
        Main.printWelcomeMessage();
        String output = outContent.toString();
        assertTrue(output.contains("Welcome to this E-Commerce Cart System"));
    }

    @Test
    public void testQueryQuestion() {
        String simulatedInput = "3\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
        Scanner scanner = new Scanner(System.in);
        int quantity = Main.queryQuestion(scanner);
        assertTrue(quantity == 3);
    }

    @Test
    public void testQueryQuestionInvalidInput() {
        String simulatedInput = "abc\n2\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
        Scanner scanner = new Scanner(System.in);
        int quantity = Main.queryQuestion(scanner);
        assertTrue(quantity == 2);
        String output = outContent.toString();
        assertTrue(output.contains("Invalid input. Please enter a valid integer."));
    }

    @Test
    public void testPrintMainMenu() {
        Main.printMainMenu("productList", "");
        String output = outContent.toString();
        assertTrue(output.contains("[1] View Cart"));
    }

    @Test
    public void testPromptContinue() {
        String simulatedInput = "\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
        Main.promptContinue();
        String output = outContent.toString();
        assertTrue(output.contains("Press any key to continue..."));
    }

    @Test
    public void testMainMenuNavigation() {
        String simulatedInput = "1\n5\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        Cart cart = new Cart();
        Product phone = new ElectronicProduct("1001", "Smartphone", 699.99, "24 months warranty", 1);
        cart.addProduct(phone);

        when(cartServiceMock.getCart()).thenReturn(cart);
        when(productServiceMock.getProductById("1001")).thenReturn(phone);

        Main mainInstance = new Main();

        mainInstance.main(new String[] {});

        String output = outContent.toString();
        assertTrue(output.contains("Enter Action Number"));
    }
}
