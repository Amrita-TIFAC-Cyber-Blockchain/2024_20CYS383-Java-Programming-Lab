package com.ramaguru.amrita.cys.jpl.Streams;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * An example demonstrating the usage of BufferedInputStream and BufferedOutputStream to improve I/O performance.
 * This example reads data from the input file using BufferedInputStream and writes it to the output file using BufferedOutputStream.
 *
 * @author Ramaguru Radhakrishnan
 * @version 0.5
 */
public class BufferedStreamExample {
    /**
     * Reads data from the input file using BufferedInputStream and writes it to the output file using BufferedOutputStream.
     *
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream("C:\\Projects_Java\\lib\\jpl_20cys383\\src\\com\\ramaguru\\amrita\\files\\input.txt"));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("C:\\Projects_Java\\lib\\jpl_20cys383\\src\\com\\ramaguru\\amrita\\files\\output.txt"))) {
            int byteData;
            while ((byteData = bis.read()) != -1) {
                bos.write(byteData); // Write the byte data to the output file
            }
        } catch (IOException e) {
            e.printStackTrace(); // Print the exception stack trace if an error occurs
        }
    }
}
