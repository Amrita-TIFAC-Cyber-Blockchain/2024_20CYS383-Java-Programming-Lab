package com.ramaguru.amrita.cys.jpl.exception;

/**
 * Example demonstrating exception handling for NullPointerException.
 *
 *  @author Ramaguru Radhakrishnan
 *  @version 0.5
 */
public class NullPointerExceptionExample {
    /**
     * Main method to demonstrate exception handling for NullPointerException.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        try {
            String text = null;
            int length = text.length(); // NullPointerException
            System.out.println("Length: " + length);
        } catch (NullPointerException e) {
            System.out.println("Error: Null reference");
        }
    }
}
