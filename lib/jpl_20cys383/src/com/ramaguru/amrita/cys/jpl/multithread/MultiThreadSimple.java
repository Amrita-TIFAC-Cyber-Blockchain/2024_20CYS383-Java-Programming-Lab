package com.ramaguru.amrita.cys.jpl.multithread;

/**
 * This code demonstrates the usage of multiple threads in Java.
 *
 * @author Ramaguru Radhakrishnan
 * @version 1.0
 */
public class MultiThreadSimple extends Thread {

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

    public static void main(String[] args) {
        // Create two thread objects
        MultiThreadSimple thread1 = new MultiThreadSimple();
        MultiThreadSimple thread2 = new MultiThreadSimple();

        // Start the threads
        thread1.start();
        thread2.start();
    }
}
