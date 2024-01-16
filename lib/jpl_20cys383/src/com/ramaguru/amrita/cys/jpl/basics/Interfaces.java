package com.ramaguru.amrita.cys.jpl.basics;

/**
 * The IShape interface defines the contract for classes that represent geometric shapes.
 * It declares methods for calculating the area and displaying information about the shape.
 * This interface provides a basic structure for implementing different shape classes.
 *
 * Usage:
 * - Classes that implement the IShape interface should provide implementations for the area() and display() methods.
 *
 * Note: This example includes two classes (ICircle and IRectangle) that implement the IShape interface.
 *
 * Dependencies:
 * - None
 *
 * @author Ramaguru Radhakrishnan
 * @version 0.5
 */
interface IShape {
    /**
     * Calculates the area of the shape.
     */
    public void area();

    /**
     * Displays information about the shape.
     */
    public void display();
}

/**
 * The ICircle class represents a circle shape and implements the IShape interface.
 * It provides implementations for the area() and display() methods.
 *
 * Usage:
 * - Create an instance of the ICircle class to work with circle shapes.
 * - Call the area() method to calculate the area of the circle.
 * - Call the display() method to display information about the circle.
 *
 * Note: This example assumes the calculation of the circle's area using the formula PI * R * R.
 * Note: This example prints messages indicating the execution of each method.
 *
 * Dependencies:
 * - None
 */
class ICircle implements IShape {

    /**
     * Calculates the area of the circle.
     */
    public void area() {
        System.out.println("[Interface Method in Circle] Area of Circle is PI * R * R");
    }

    /**
     * Displays information about the circle.
     */
    public void display() {
        System.out.println("[Interface Method in Circle] Calculating Area of Circle");
    }
}

/**
 * The IRectangle class represents a rectangle shape and implements the IShape interface.
 * It provides implementations for the area() and display() methods.
 *
 * Usage:
 * - Create an instance of the IRectangle class to work with rectangle shapes.
 * - Call the area() method to calculate the area of the rectangle.
 * - Call the display() method to display information about the rectangle.
 *
 * Note: This example assumes the calculation of the rectangle's area using the formula L * B.
 * Note: This example prints messages indicating the execution of each method.
 *
 * Dependencies:
 * - None
 */
class IRectangle implements IShape {

    /**
     * Calculates the area of the rectangle.
     */
    public void area() {
        System.out.println("[Interface Method in Rectangle] Area of Rectangle is L * B");
    }

    /**
     * Displays information about the rectangle.
     */
    public void display() {
        System.out.println("[Interface Method in Rectangle] Calculating Area of Rectangle");
    }
}

/**
 * The Interfaces class demonstrates the usage of interfaces and implementing classes.
 * It creates objects of ICircle and IRectangle and invokes their methods.
 * This class provides a basic example of working with interfaces in Java.
 *
 * Usage:
 * - The program creates objects of ICircle and IRectangle.
 * - It calls the display() and area() methods on these objects to perform calculations and display information.
 *
 * Note: This example assumes the use of the ICircle and IRectangle classes to represent circle and rectangle shapes.
 *
 * Dependencies:
 * - None
 */
public class Interfaces {
    /**
     * The main method is the entry point of the program.
     * It demonstrates the usage of interfaces and implementing classes.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        System.out.println("[Main] Creating Objects Circle and Rectangle");

        // Create an instance of ICircle and call its methods
        ICircle myCircle = new ICircle();
        myCircle.display();
        myCircle.area();

        // Create an instance of IRectangle and call its methods
        IRectangle myRect = new IRectangle();
        myRect.display();
        myRect.area();
    }
}
