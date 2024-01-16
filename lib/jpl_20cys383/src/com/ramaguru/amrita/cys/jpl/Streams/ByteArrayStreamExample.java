package com.ramaguru.amrita.cys.jpl.Streams;

import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * An example demonstrating the usage of ByteArrayInputStream to read data from a byte array.
 *
 * @author Ramaguru Radhakrishnan
 * @version 0.5
 */
public class ByteArrayStreamExample {
    /**
     * Reads the data from the byte array and prints it to the console.
     *
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        byte[] data = { 50, 49, 85, 67, 89, 83 };
        try (ByteArrayInputStream bais = new ByteArrayInputStream(data)) {
            int byteData;
            while ((byteData = bais.read()) != -1) {
                System.out.print((char) byteData); // Convert the byte data to char and print
            }
        } catch (IOException e) {
            e.printStackTrace(); // Print the exception stack trace if an error occurs
        }
    }
}
