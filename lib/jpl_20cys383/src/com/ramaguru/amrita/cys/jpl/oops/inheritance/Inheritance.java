package com.ramaguru.amrita.cys.jpl.oops.inheritance;

/**
 * The Shape class represents a generic shape.
 * It provides methods for calculating the area and displaying the shape.
 * This class serves as the superclass for specific shape classes.
 *
 * @author Ramaguru Radhakrishnan
 * @version 0.5
 */
class Shape {

    /**
     * Calculates the area of the shape.
     * This method is meant to be overridden by subclasses.
     */
    public void area() { }

    /**
     * Displays information about the shape.
     * This method is meant to be overridden by subclasses.
     */
    public void display() {
        System.out.println("[Super] Calculating Area");
    }

}

/**
 * The Circle class represents a circle shape.
 * It extends the Shape class and provides its own implementation for area calculation.
 */
class Circle extends Shape {

    /**
     * Calculates the area of a circle.
     * Overrides the area() method in the superclass.
     */
    public void area() {
        System.out.println("[Circle] Area of Circle is PI*R*R");
    }

}

/**
 * The Rectangle class represents a rectangle shape.
 * It extends the Shape class and provides its own implementation for area calculation.
 */
class Rectangle extends Shape {

    /**
     * Calculates the area of a rectangle.
     * Overrides the area() method in the superclass.
     */
    public void area() {
        System.out.println("[Rectangle] Area of Rectangle is L*B");
    }

}

/**
 * The Inheritance class demonstrates inheritance in action.
 * It creates instances of Circle and Rectangle classes and invokes their methods.
 */
public class Inheritance {
    /**
     * The main method is the entry point of the program.
     * It creates objects of Circle and Rectangle and calls their display() and area() methods.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {

        System.out.println("[Main] Creating Objects Circle and Rectangle");

        Circle myCircle = new Circle(); // Create a Circle object
        myCircle.display();
        myCircle.area();

        Rectangle myRect = new Rectangle(); // Create a Rectangle object
        myRect.display();
        myRect.area();
    }

}
