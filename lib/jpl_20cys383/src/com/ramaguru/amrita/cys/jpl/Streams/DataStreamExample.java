package com.ramaguru.amrita.cys.jpl.Streams;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

/**
 * An example demonstrating the usage of DataInputStream and DataOutputStream to read and write primitive data types.
 *
 * @author Ramaguru Radhakrishnan
 * @version 0.5
 */
public class DataStreamExample {
    /**
     * Writes an integer and a double value to the file using DataOutputStream,
     * and then reads the values back using DataInputStream and prints them.
     *
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("C:\\Projects_Java\\lib\\jpl_20cys383\\src\\com\\ramaguru\\amrita\\files\\data.bin"));
             DataInputStream dis = new DataInputStream(new FileInputStream("C:\\Projects_Java\\lib\\jpl_20cys383\\src\\com\\ramaguru\\amrita\\files\\data.bin"))) {
            dos.writeInt(44); // Write the integer value
            dos.writeDouble(3.14); // Write the double value
            dos.writeChars("Ramaguru R"); // Write the String value

            int intValue = dis.readInt(); // Read the integer value
            double doubleValue = dis.readDouble(); // Read the double value
            String stringvalue = Arrays.toString(dis.readAllBytes()); // Read the String value as Array

            System.out.println("Read values: " + intValue + ", " + doubleValue + "," + stringvalue);
        } catch (IOException e) {
            e.printStackTrace(); // Print the exception stack trace if an error occurs
        }
    }
}
