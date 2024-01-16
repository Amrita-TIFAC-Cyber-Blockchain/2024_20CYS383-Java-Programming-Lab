package com.ramaguru.amrita.cys.jpl.multithread;

/**
 * This code demonstrates the usage of multiple threads in Java.
 *
 * @author Ramaguru Radhakrishnan
 * @version 1.0
 */
public class MultiThreadMultiClass {

    public static void main(String[] args) {
        // Create two thread objects
        MultiThread thread1 = new MultiThread();
        MultiThread thread2 = new MultiThread();

        // Start the threads
        thread1.start();
        thread2.start();
    }
}

/**
 * The MultiThread class extends Thread and represents a thread that prints numbers from 1 to 5.
 */
class MultiThread extends Thread {

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
