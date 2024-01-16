package com.ramaguru.amrita.cys.jpl.exception;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Example demonstrating exception handling for FileNotFoundException.
 *
 *  @author Ramaguru Radhakrishnan
 *  @version 0.5
 */
public class FileNotFoundExceptionExample {

    /**
     * Main method to read a file and handle FileNotFoundException.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        try {
            File file = new File("nonexistent.txt");
            Scanner scanner = new Scanner(file); // FileNotFoundException
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found");
        }
    }
}

