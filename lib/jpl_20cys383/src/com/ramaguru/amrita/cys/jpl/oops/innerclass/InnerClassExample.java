package com.ramaguru.amrita.cys.jpl.oops.innerclass;

/**
 * The OuterClass represents an outer class containing an inner class.
 * It demonstrates the usage of inner classes in Java.
 *
 * The InnerClassExample class is the entry point of the program.
 * It creates instances of the outer and inner classes and accesses their variables.
 *
 * @author Ramaguru Radhakrishnan
 * @version 0.5
 */
class OuterClass {
    int x = 10;

    /**
     * The InnerClass represents an inner class within the OuterClass.
     * It has its own variable y.
     */
    class InnerClass {
        int y = 5;
    }
}

/**
 * The InnerClassExample class demonstrates the usage of inner classes.
 * It creates instances of the outer and inner classes and performs variable access.
 */
public class InnerClassExample {
    /**
     * The main method is the entry point of the program.
     * It creates an instance of OuterClass and InnerClass,
     * and accesses their variables to demonstrate inner class usage.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        OuterClass myOuter = new OuterClass();
        OuterClass.InnerClass myInner = myOuter.new InnerClass();
        System.out.println(myInner.y + myOuter.x);
    }
}
