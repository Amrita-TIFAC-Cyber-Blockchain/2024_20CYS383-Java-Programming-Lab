package com.ramaguru.amrita.cys.jpl.exception;

/**
 *  Example demonstrating exception handling for ArrayIndexOutOfBoundsException.
 *
 *  @author Ramaguru Radhakrishnan
 *  @version 0.5
 */

public class ArrayIndexOutOfBoundsExceptionExample {
    /**
     * Main method to demonstrate exception handling for ArrayIndexOutOfBoundsException.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        try {
            int[] numbers = {1, 2, 3};
            System.out.println(numbers[3]); // ArrayIndexOutOfBoundsException
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Index out of bounds");
        }
    }
}
