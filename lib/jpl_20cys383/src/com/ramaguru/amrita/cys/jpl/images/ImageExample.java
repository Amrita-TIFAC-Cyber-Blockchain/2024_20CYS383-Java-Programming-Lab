package com.ramaguru.amrita.cys.jpl.images;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * The ImageExample class demonstrates reading and writing images using BufferedImage and ImageIO.
 * It reads an image file, stores it in memory using BufferedImage, and then writes it as a new image file.
 * This class shows a simple example of image manipulation in Java.
 *
 * Usage:
 * - Provide the file paths for the input image and the desired output image.
 * - The program reads the input image, creates a BufferedImage to store it, and prints a message if the reading is successful.
 * - The program then writes the BufferedImage as a new image file in the specified format (e.g., PNG).
 * - A message is printed if the writing is successful.
 *
 * Note: This example assumes the input image file exists and is accessible.
 *
 * Note: This example uses absolute file paths, which may need to be modified for your system.
 *
 * Note: This example does not handle advanced image manipulation or error handling.
 *
 * Dependencies:
 * - Java AWT (Abstract Window Toolkit)
 *
 * @author Ramaguru Radhakrishnan
 * @version 0.5
 */
public class ImageExample {
    /**
     * The main method is the entry point of the program.
     * It demonstrates reading an image file, storing it in a BufferedImage, and writing it as a new image file.
     *
     * @param args command line arguments
     * @throws IOException if an I/O error occurs
     */
    public static void main(String args[]) throws IOException {
        // Width of the image
        int width = 963;

        // Height of the image
        int height = 640;

        // For storing image in RAM
        BufferedImage image = null;

        // Read the image
        try {
            File input_file = new File("C:\\Projects_Java\\jpl_20cys383\\src\\com\\ramaguru\\amrita\\images\\21UCYS.jpeg");

            // Create a BufferedImage object with the specified width, height, and image type
            // BufferedImage.TYPE_INT_ARGB represents the Alpha, Red, Green, and Blue components of the image pixel using 8-bit integer values
            image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

            // Read the input file into the BufferedImage
            image = ImageIO.read(input_file);

            System.out.println("Reading complete.");
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }

        // Write the image
        try {
            // Output file path
            File output_file = new File("C:\\Projects_Java\\jpl_20cys383\\src\\com\\ramaguru\\amrita\\images\\Recreate.png");

            // Write the BufferedImage to the output file in the specified format (e.g., PNG)
            ImageIO.write(image, "png", output_file);

            System.out.println("Writing complete.");
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }
}
