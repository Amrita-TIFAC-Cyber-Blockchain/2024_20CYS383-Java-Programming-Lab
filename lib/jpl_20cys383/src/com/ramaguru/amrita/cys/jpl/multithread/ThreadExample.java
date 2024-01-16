package com.ramaguru.amrita.cys.jpl.multithread;

/**
 * The ThreadExample class demonstrates creating a thread using the Runnable interface.
 * It implements the Runnable interface and defines a run() method that will be executed in a separate thread.
 * This class shows a simple example of multi-threading in Java.
 *
 * Note: The run() method will be executed concurrently with the main thread.
 *
 * Usage:
 * - Create an instance of ThreadExample.
 * - Create a Thread object, passing the ThreadExample instance as the Runnable.
 * - Start the thread using the start() method.
 * - The code inside the run() method will be executed in a separate thread concurrently with the main thread.
 * - The code outside the thread will be executed by the main thread.
 *
 * Note: The output may vary due to the concurrent execution of the threads.
 *
 * This example does not handle advanced thread synchronization or termination.
 *
 * @author Ramaguru Radhakrishnan
 * @version 0.5
 */
public class ThreadExample implements Runnable {
    /**
     * The main method is the entry point of the program.
     * It demonstrates creating and starting a thread using the ThreadExample class.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        ThreadExample obj = new ThreadExample();
        Thread thread = new Thread(obj);
        thread.start();
        System.out.println("This code is outside of the thread");
    }

    /**
     * The run method is invoked when the thread is started.
     * It contains the code that will be executed in a separate thread.
     * This method prints a message to the console.
     */
    public void run() {
        System.out.println("This code is running in a thread");
    }
}
