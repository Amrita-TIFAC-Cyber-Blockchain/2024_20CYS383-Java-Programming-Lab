package com.ramaguru.amrita.cys.jpl.files;

import java.io.File;
import java.io.IOException;

/**
 * The CreateFileExample class demonstrates how to create a file using the File class.
 * It creates a new file with a specified name and displays a success message if the file is created successfully.
 * This class provides a basic structure for creating files in Java.
 *
 * Usage:
 * - The program specifies the name of the file to create.
 * - It creates a File object with the specified filename.
 * - It calls the createNewFile() method to create the file.
 * - If the file is created successfully, it displays a success message.
 * - If the file already exists, it displays a message indicating that the file already exists.
 *
 * Note: This example assumes that the file can be created in the specified location.
 *
 * Dependencies:
 * - None
 *
 * @author Ramaguru Radhakrishnan
 * @version 0.5
 */
public class CreateFileExample {
    /**
     * The main method is the entry point of the program.
     * It creates a new file with a specified name and displays a success message if the file is created successfully.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        try {
            // Change the file path if required
            File myObj = new File("C:\\Projects_Java\\jpl_20cys383\\src\\com\\ramaguru\\amrita\\files\\example.txt");

            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
