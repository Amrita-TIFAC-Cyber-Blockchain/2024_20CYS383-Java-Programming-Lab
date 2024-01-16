package com.ramaguru.amrita.cys.jpl.oops.polymorphism;

/**
 * The PShape class represents a generic shape.
 * It provides methods for calculating the area and displaying the shape.
 * This class serves as the superclass for specific shape classes.
 *
 * @author Ramaguru Radhakrishnan
 * @version 0.5
 */
class PShape {

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
 * The PCircle class represents a circle shape.
 * It extends the PShape class and provides its own implementation for area calculation.
 */
class PCircle extends PShape {

    /**
     * Calculates the area of a circle.
     * Overrides the area() method in the superclass.
     */
    public void area() {
        System.out.println("[Circle] Area of Circle is PI*R*R");
    }

}

/**
 * The PRectangle class represents a rectangle shape.
 * It extends the PShape class and provides its own implementation for area calculation.
 */
class PRectangle extends PShape {

    /**
     * Calculates the area of a rectangle.
     * Overrides the area() method in the superclass.
     */
    public void area() {
        System.out.println("[Rectangle] Area of Rectangle is L*B");
    }

}

/**
 * The Polymorphism class demonstrates polymorphism in action.
 * It creates instances of PCircle and PRectangle and invokes their methods.
 */
public class Polymorphism {

    /**
     * The main method is the entry point of the program.
     * It creates objects of PCircle and PRectangle and calls their display() and area() methods.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {

        System.out.println("[Main] Creating Objects Circle and Rectangle");

        PCircle myCircle = new PCircle(); // Create a Circle object
        myCircle.display();
        myCircle.area();

        PRectangle myRect = new PRectangle(); // Create a Rectangle object
        myRect.display();
        myRect.area();
    }

}
