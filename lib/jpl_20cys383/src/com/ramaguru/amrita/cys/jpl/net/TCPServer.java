package com.ramaguru.amrita.cys.jpl.net;

import java.io.*;
import java.net.*;

/**
 * The TCPServer class represents the server side of the TCP client-server application.
 * It listens for client connections and processes client requests.
 */
public class TCPServer {

    /**
     * The main method is the entry point of the server application.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        try {
            // Create a server socket on port 4424
            ServerSocket serverSocket = new ServerSocket(4424);
            System.out.println("Server started. Waiting for clients...");

            while (true) {
                // Accept client connection
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getInetAddress().getHostAddress());

                // Create input and output streams for client communication
                BufferedReader inFromClient = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                DataOutputStream outToClient = new DataOutputStream(clientSocket.getOutputStream());

                // Read client request
                String clientRequest = inFromClient.readLine();
                System.out.println("Received from client: " + clientRequest);

                // Process client request
                String response = processRequest(clientRequest);

                // Send response to client
                outToClient.writeBytes(response + '\n');
                System.out.println("Sent to client: " + response);

                // Close client connection
                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Processes the client request and generates a response.
     * Modify this method to implement your specific server logic.
     *
     * @param request the client request
     * @return the response to the client
     */
    private static String processRequest(String request) {
        // Placeholder implementation
        return "Server response: " + request.toUpperCase();
    }
}
