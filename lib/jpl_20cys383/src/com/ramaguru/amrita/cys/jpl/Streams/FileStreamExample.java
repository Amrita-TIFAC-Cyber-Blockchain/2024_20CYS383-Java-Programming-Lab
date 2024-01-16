package com.ramaguru.amrita.cys.jpl.Streams;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * An example demonstrating the usage of FileInputStream to read data from a file as a sequence of bytes.
 *
 * @author Ramaguru Radhakrishnan
 * @version 0.5
 */
public class FileStreamExample {
    /**
     * Reads the data from the file and prints it to the console.
     *
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("example.txt")) {
            int data;
            while ((data = fis.read()) != -1) {
                System.out.print((char) data); // Convert the byte data to char and print
            }
        } catch (IOException e) {
            e.printStackTrace(); // Print the exception stack trace if an error occurs
        }
    }
}
