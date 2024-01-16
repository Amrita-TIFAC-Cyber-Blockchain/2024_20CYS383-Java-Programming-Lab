package com.ramaguru.amrita.cys.jpl.gui.swing.apps;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

/**
 * ChatClientUI is a Java Swing-based user interface for a chat client application.
 * It allows the user to send and receive messages to/from a chat server using socket programming.
 * The UI provides a text area to display the chat conversation and a text field to enter messages.
 *
 * @author Ramaguru Radhakrishnan
 * @version 0.5
 */

public class ChatClientUIR extends JFrame implements ActionListener {
    private JTextField messageField;
    private JTextArea chatArea;
    private JButton sendButton;
    private Socket clientSocket;
    private PrintWriter out;
    private DataInputStream in;

    /**
     * Constructs the ChatClientUI object.
     * Sets up the UI components and establishes a connection with the chat server.
     */
    public ChatClientUIR() {
        setTitle("Chat Client");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create and add the chat area
        chatArea = new JTextArea();
        chatArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(chatArea);
        add(scrollPane, BorderLayout.CENTER);

        // Create and add the message field and send button
        messageField = new JTextField();
        messageField.addActionListener(this);
        sendButton = new JButton("Send");
        sendButton.addActionListener(this);
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BorderLayout());
        inputPanel.add(messageField, BorderLayout.CENTER);
        inputPanel.add(sendButton, BorderLayout.EAST);
        add(inputPanel, BorderLayout.SOUTH);

        setVisible(true);

        try {
            // Connect to the server
            clientSocket = new Socket("localhost", 2444); // Replace "localhost" with the server's IP address if needed

            // Initialize input and output streams
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new DataInputStream(clientSocket.getInputStream());

            // Start a thread to listen for incoming messages from the server
            Thread receiveThread = new Thread(() -> {
                System.out.println("Thread Started for receiving the message from Server");
                String message = "Dummy";
                try {
                    while (!(message = in.readUTF()).equals("exit")) {
                        chatArea.append("Server: " + message + "\n");
                        System.out.println("Message from  Server: " + message + "\n");

                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            receiveThread.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Handles the actionPerformed event for the message field and send button.
     * Sends the entered message to the server when the user presses Enter or clicks the Send button.
     *
     * @param e the ActionEvent object representing the user action
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == messageField) {
            String message = messageField.getText();
            sendMessage(message);
            messageField.setText("");
        }
    }

    /**
     * Sends a message to the chat server and updates the chat area with the sent message.
     *
     * @param message the message to be sent
     */
    private void sendMessage(String message) {
        chatArea.append("Client: " + message + "\n");
        out.println(message);
    }

    /**
     * The entry point of the chat client application.
     * Creates an instance of ChatClientUI to start the chat client.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        new ChatClientUIR();
    }
}
