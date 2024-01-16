package com.ramaguru.amrita.cys.jpl.net;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * The SimpleServer class represents a simple server program.
 * It listens for incoming connections on a specified port and receives messages from clients.
 * This class demonstrates basic network programming using sockets.
 *
 * Note: This is a simple example and does not handle multiple clients or advanced error handling.
 *
 * Usage:
 * - Run the SimpleServer program.
 * - Connect to the server using a client program and send a message.
 * - The server receives the message and prints it to the console.
 * - The server then closes the connection.
 *
 * @author Ramaguru Radhakrishnan
 * @version 0.5
 */
public class SimpleServerR {
    /**
     * The main method is the entry point of the program.
     * It listens for incoming connections, receives messages, and prints them to the console.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        try {
            // Create a server socket on port 2444
            ServerSocket ss = new ServerSocket(2444);

            // Wait for a client to establish a connection
            Socket s = ss.accept();

            DataOutputStream dout = new DataOutputStream(s.getOutputStream());

            Scanner read  = new Scanner(System.in);
            String msg = "Hello Client";
            while(true) {

                System.out.println("Enter a message to Client");
                msg = read.nextLine();

                // Send a message to the client
                dout.writeUTF(msg);
                dout.flush();

                if(msg.equals("exit"))
                    break;

            }
            System.out.println("Closing Connections");
            dout.close();
            // Close the server socket
            ss.close();
        } catch (IOException e) {
            System.out.println("An error occurred: " + e);
        }
    }
}
