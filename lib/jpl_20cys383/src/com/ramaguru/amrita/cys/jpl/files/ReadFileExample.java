package com.ramaguru.amrita.cys.jpl.files;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * The ReadFileExample class demonstrates how to read a text file using the Scanner class.
 * It reads the contents of a file line by line and displays them on the console.
 * This class provides a basic structure for reading files in Java.
 *
 * Usage:
 * - The program specifies the filename to read.
 * - It creates a File object using the specified filename.
 * - It creates a Scanner object to read from the file.
 * - The program iterates through the file line by line using a while loop.
 * - For each line, it retrieves the data and prints it to the console.
 * - Finally, it closes the Scanner.
 *
 * Note: This example assumes that the file exists and is readable.
 *
 * Dependencies:
 * - None
 *
 * @author Ramaguru Radhakrishnan
 * @version 0.5
 */
public class ReadFileExample {
    /**
     * The main method is the entry point of the program.
     * It reads the contents of a text file and displays them on the console.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        try {
            // Change the file path if required
            String filename = "C:\\Projects_Java\\lib\\jpl_20cys383\\src\\com\\ramaguru\\amrita\\files\\example.txt";

            File myFile = new File(filename);

            // Create a Scanner to read from the File
            Scanner myReader = new Scanner(myFile);

            // Iterate through the file line by line
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
