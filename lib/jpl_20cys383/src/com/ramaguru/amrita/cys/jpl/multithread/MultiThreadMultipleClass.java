package com.ramaguru.amrita.cys.jpl.multithread;

/**
 * The MultiThreadMultipleClass class demonstrates the usage of multiple threads in Java.
 * It creates two threads of different classes, MultiThreadClass1 and MultiThreadClass2, and starts them.
 *
 * @author Ramaguru Radhakrishnan
 * @version 1.0
 */
public class MultiThreadMultipleClass {

    public static void main(String[] args) {
        // Create two thread objects
        MultiThreadClass1 thread1 = new MultiThreadClass1();
        MultiThreadClass2 thread2 = new MultiThreadClass2();

        // Start the threads
        thread1.start();
        thread2.start();
    }
}

/**
 * The MultiThreadClass1 class extends Thread and represents a thread that prints numbers from 1 to 5.
 */
class MultiThreadClass1 extends Thread {

    /**
     * The run() method contains the code to be executed in the thread.
     * It prints the thread ID along with the numbers from 1 to 5 and sleeps for 1 second between each iteration.
     */
    @Override
    public void run() {
        try {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Thread " + Thread.currentThread().getId() + ": " + i);
                Thread.sleep(1000); // Sleep for 1 second
            }
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted.");
        }
    }
}

/**
 * The MultiThreadClass2 class extends Thread and represents a thread that prints numbers from 1 to 20.
 */
class MultiThreadClass2 extends Thread {

    /**
     * The run() method contains the code to be executed in the thread.
     * It prints the thread ID along with the numbers from 1 to 20 and sleeps for 500 milliseconds between each iteration.
     */
    @Override
    public void run() {
        try {
            for (int i = 1; i <= 20; i++) {
                System.out.println("Thread " + Thread.currentThread().getId() + ": " + i);
                Thread.sleep(500); // Sleep for 500 milliseconds
            }
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted.");
        }
    }
}
