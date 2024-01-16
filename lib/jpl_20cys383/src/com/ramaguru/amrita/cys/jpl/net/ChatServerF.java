import java.io.*;
import java.net.*;
import java.util.Scanner;

/**
 * ChatServerF is a simple server application that listens for client connections and handles communication.
 * It receives messages from clients and sends messages to clients.
 * This class provides a basic implementation of a chat server using sockets.
 * It listens for client connections on a specified port and handles communication with the clients.
 * Each client connection is processed in a separate thread.
 *
 * Note: This is a basic implementation and does not include advanced features like multiple clients or user authentication.
 *
 * @author Ramaguru Radhakrishnan
 * @version 0.5
 */
public class ChatServerF {
    /**
     * Starts the chat server on the specified port.
     *
     * @param port the port to listen for client connections
     */
    public void start(int port) {
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server started on port " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected: " + clientSocket.getInetAddress().getHostAddress());

                handleClient(clientSocket);

                // Close the client socket after handling the connection
                // clientSocket.close();
                // System.out.println("Client disconnected: " + clientSocket.getInetAddress().getHostAddress());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Handles communication with a client connected to the server.
     *
     * @param clientSocket the client socket
     */
    private void handleClient(Socket clientSocket) {
        try {
            DataInputStream clientReader = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream clientWriter = new DataOutputStream(clientSocket.getOutputStream());

            // Thread for receiving messages from the client
            Thread receiveThread = new Thread(() -> {
                System.out.println("Thread Started for receiving the message from Client");
                String clientMessage;
                while (true) {
                    try {
                        clientMessage = clientReader.readUTF();
                        if (clientMessage.equals("exit"))
                            break;
                        System.out.println("Received from client: " + clientMessage);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            receiveThread.start();

            // Thread for sending messages to the client
            Thread sendThread = new Thread(() -> {
                Scanner read = new Scanner(System.in);
                String msg;
                try {
                    while (true) {
                        // Perform any necessary operations to get the message to send
                        msg = read.nextLine();
                        if (!msg.isEmpty()) {
                            clientWriter.writeUTF(msg);
                            System.out.println("Sent to client: " + msg);
                        }
                        // Add any necessary delay or conditions for sending messages
                        Thread.sleep(1000); // Example: send a message every 1 second
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            sendThread.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * The entry point of the application.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ChatServerF server = new ChatServerF();
        server.start(2444); // Start the server on port 2444 (or any other desired port)
    }
}
