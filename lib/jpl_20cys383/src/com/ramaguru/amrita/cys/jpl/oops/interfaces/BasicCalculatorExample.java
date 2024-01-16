package com.ramaguru.amrita.cys.jpl.oops.interfaces;

import java.util.Scanner;

/**
 * The Calculator interface defines the basic mathematical operations.
 */
interface Calculator {
    /**
     * Adds two numbers.
     *
     * @param a the first number
     * @param b the second number
     * @return the sum of the two numbers
     */
    double add(double a, double b);

    /**
     * Subtracts the second number from the first number.
     *
     * @param a the first number
     * @param b the second number
     * @return the difference between the two numbers
     */
    double subtract(double a, double b);

    /**
     * Multiplies two numbers.
     *
     * @param a the first number
     * @param b the second number
     * @return the product of the two numbers
     */
    double multiply(double a, double b);

    /**
     * Divides the first number by the second number.
     *
     * @param a the dividend
     * @param b the divisor
     * @return the quotient of the division
     * @throws ArithmeticException if the divisor is zero
     */
    double divide(double a, double b) throws ArithmeticException;
}

/**
 * The BasicCalculator class implements the Calculator interface.
 */
class BasicCalculator implements Calculator {
    @Override
    public double add(double a, double b) {
        return a + b;
    }

    @Override
    public double subtract(double a, double b) {
        return a - b;
    }

    @Override
    public double multiply(double a, double b) {
        return a * b;
    }

    @Override
    public double divide(double a, double b) throws ArithmeticException {
        if (b != 0) {
            return a / b;
        } else {
            throw new ArithmeticException("Division by zero error!");
        }
    }
}

/**
 * The Main class is the entry point of the calculator program.
 */
public class BasicCalculatorExample {
    /**
     * The main method prompts the user for input and performs calculations.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Calculator calculator = new BasicCalculator();
        double num1;
        double num2;

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        num1 = sc.nextDouble();

        System.out.print("Enter the second number: ");
        num2 = sc.nextDouble();

        double additionResult = calculator.add(num1, num2);
        System.out.println("Addition: " + additionResult);

        double subtractionResult = calculator.subtract(num1, num2);
        System.out.println("Subtraction: " + subtractionResult);

        double multiplicationResult = calculator.multiply(num1, num2);
        System.out.println("Multiplication: " + multiplicationResult);

        double divisionResult = calculator.divide(num1, num2);
        System.out.println("Division: " + divisionResult);

    }
}
