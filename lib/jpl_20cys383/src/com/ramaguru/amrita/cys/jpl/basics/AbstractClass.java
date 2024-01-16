package com.ramaguru.amrita.cys.jpl.basics;

/**
 * The Shape class is an abstract class that defines the common behavior for different shapes.
 * It declares an abstract area() method and provides a default implementation for the display() method.
 * This class serves as a base for implementing specific shape classes.
 *
 * Usage:
 * - Subclasses should provide an implementation for the area() method.
 * - The display() method can be used to display information common to all shapes.
 *
 * Note: This example includes two subclasses (Circle and Rectangle) that inherit from the Shape class.
 *
 * Dependencies:
 * - None
 *
 * @author Ramaguru Radhakrishnan
 * @version 0.5
 */
abstract class Shape {

    /**
     * Calculates the area of the shape.
     * Subclasses must provide their own implementation.
     */
    public abstract void area();

    /**
     * Displays information about the shape.
     * This method provides a default implementation that can be overridden by subclasses if needed.
     */
    public void display() {
        System.out.println("[Super] Calculating Area");
    }
}

/**
 * The Circle class represents a circle shape and inherits from the Shape class.
 * It provides an implementation for the area() method.
 *
 * Usage:
 * - Create an instance of the Circle class to work with circle shapes.
 * - Call the area() method to calculate the area of the circle.
 *
 * Note: This example assumes the calculation of the circle's area using the formula PI * R * R.
 * Note: This example prints messages indicating the execution of each method.
 *
 * Dependencies:
 * - None
 */
class Circle extends Shape {

    /**
     * Calculates the area of the circle.
     */
    public void area() {
        System.out.println("[Abstract Method in Circle] Area of Circle is PI * R * R");
    }
}

/**
 * The Rectangle class represents a rectangle shape and inherits from the Shape class.
 * It provides an implementation for the area() method.
 *
 * Usage:
 * - Create an instance of the Rectangle class to work with rectangle shapes.
 * - Call the area() method to calculate the area of the rectangle.
 *
 * Note: This example assumes the calculation of the rectangle's area using the formula L * B.
 * Note: This example prints messages indicating the execution of each method.
 *
 * Dependencies:
 * - None
 */
class Rectangle extends Shape {

    /**
     * Calculates the area of the rectangle.
     */
    public void area() {
        System.out.println("[Abstract Method in Rectangle] Area of Rectangle is L * B");
    }
}

/**
 * The AbstractClass class demonstrates the usage of abstract classes and inheritance.
 * It creates objects of Circle and Rectangle and invokes their methods.
 * This class provides a basic example of working with abstract classes in Java.
 *
 * Usage:
 * - The program demonstrates the creation of objects of Circle and Rectangle.
 * - It calls the display() and area() methods on these objects to perform calculations and display information.
 * - It also demonstrates that abstract classes cannot be instantiated directly.
 *
 * Note: This example assumes the use of the Circle and Rectangle classes to represent circle and rectangle shapes.
 *
 * Dependencies:
 * - None
 */
public class AbstractClass {
    /**
     * The main method is the entry point of the program.
     * It demonstrates the usage of abstract classes and inheritance.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {

        System.out.println("[Main] Creating Object for Abstract Class is not possible");

        // Shape myShape = new Shape(); // Try uncommenting this line.

        // error: Shape is abstract; cannot be instantiated

        System.out.println("[Main] Creating Objects Circle and Rectangle");
        Circle myCircle = new Circle(); // Create a Circle object
        myCircle.display();
        myCircle.area();

        Rectangle myRect = new Rectangle(); // Create a Rectangle Object
        myRect.display();
        myRect.area();
    }
}
