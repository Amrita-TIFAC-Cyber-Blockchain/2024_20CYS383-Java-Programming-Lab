package com.ramaguru.amrita.cys.jpl.exception;

/**
 *  Example demonstrating exception handling for ArithmeticException.
 *
 *  @author Ramaguru Radhakrishnan
 *  @version 0.5
 */
public class ArithmeticExceptionExample {

    /**
     * Main method to perform division and handle ArithmeticException.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        try {
            int result = 10 / 0; // ArithmeticException: division by zero
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
