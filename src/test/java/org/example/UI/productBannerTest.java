package org.example.UI;

import org.example.Cart.CartDisplay;
import org.example.Storage.DefaultProductFactory;
import org.example.Storage.Storage;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertTrue;

public class productBannerTest {

    private productBanner pb;

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUp() {
        Storage storage = new Storage(new DefaultProductFactory());
        storage.populateStorage(new DefaultProductFactory());
        pb = new productBanner(storage);



        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testShowBanner() {
        pb.showBanner();
        String output = outContent.toString();


        assertTrue(output.contains("Dell XPS"));
        assertTrue(output.contains("LG OASIS"));
        assertTrue(output.contains("Potato"));
        assertTrue(output.contains("Hand soap"));

    }

    @org.junit.After
    public void restoreStreams() {
        System.setOut(originalOut);
    }
}
