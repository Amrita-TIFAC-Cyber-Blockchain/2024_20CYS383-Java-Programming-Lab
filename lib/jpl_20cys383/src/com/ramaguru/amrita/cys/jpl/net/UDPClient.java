package com.ramaguru.amrita.cys.jpl.net;

import java.io.*;
import java.net.*;

/**
 * The UDPClient class represents the client side of the UDP client-server application.
 * It sends messages to the server and receives responses.
 */
public class UDPClient {

    private static final int PORT = 4424;
    private static final String SERVER_ADDRESS = "localhost";
    private static final int BUFFER_SIZE = 1024;

    /**
     * The main method is the entry point of the client application.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        try {
            // Create a UDP socket
            DatagramSocket clientSocket = new DatagramSocket();

            // Convert server address to InetAddress
            InetAddress serverAddress = InetAddress.getByName(SERVER_ADDRESS);

            // Read user input
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter a message: ");
            String message = reader.readLine();

            // Send message to the server
            byte[] sendBuffer = message.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, serverAddress, PORT);
            clientSocket.send(sendPacket);

            byte[] receiveBuffer = new byte[BUFFER_SIZE];

            // Receive response from the server
            DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
            clientSocket.receive(receivePacket);

            // Extract server response
            String serverResponse = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Received from server: " + serverResponse);

            // Close the socket
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
