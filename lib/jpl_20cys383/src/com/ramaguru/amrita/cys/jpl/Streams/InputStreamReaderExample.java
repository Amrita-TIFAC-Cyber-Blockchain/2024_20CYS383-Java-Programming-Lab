package com.ramaguru.amrita.cys.jpl.Streams;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * An example demonstrating the usage of InputStreamReader to read data from an underlying input stream and convert it into characters.
 *
 * @author Ramaguru Radhakrishnan
 * @version 0.5
 */
public class InputStreamReaderExample {
    /**
     * Reads the data from the input stream and prints it to the console.
     *
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("C:\\Projects_Java\\lib\\jpl_20cys383\\src\\com\\ramaguru\\amrita\\files\\example.txt");
             InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8)) {
            int charData;
            while ((charData = isr.read()) != -1) {
                System.out.print((char) charData); // Print the character data
            }
        } catch (IOException e) {
            e.printStackTrace(); // Print the exception stack trace if an error occurs
        }
    }
}
