package com.ramaguru.amrita.cys.jpl.gui.swing.apps;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

/**
 * com.ramaguru.amrita.cys.jpl.gui.swing.apps.ChatClientUIF is a Java Swing-based client application for a chat system.
 * It allows the user to send messages to a server and receive messages from the server.
 * The user interface provides a chat area to display incoming messages and a text field to enter and send messages.
 * This class extends the JFrame class and implements the ActionListener interface.
 *
 * @author Ramaguru Radhakrishnan
 * @version 0.5
 */
public class ChatClientUIF extends JFrame implements ActionListener {
    private JTextField messageField;
    private JTextArea chatArea;
    private JButton sendButton;
    private Socket clientSocket;
    private DataOutputStream out;
    private DataInputStream in;

    /**
     * Constructs the com.ramaguru.amrita.cys.jpl.gui.swing.apps.ChatClientUIF object.
     * Initializes the UI components and establishes a connection to the server.
     */
    public ChatClientUIF() {
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
            out = new DataOutputStream(clientSocket.getOutputStream());
            in = new DataInputStream(clientSocket.getInputStream());

            // Start a thread to listen for incoming messages from the server
            Thread receiveThread = new Thread(() -> {
                System.out.println("Thread Started for receiving the message from Server");
                String message;
                try {
                    while ((message = in.readUTF()) != null) {
                        if (message.equals("exit"))
                            break;

                        if (!message.isEmpty())
                            chatArea.append("Server: " + message + "\n");
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
     * Handles the actionPerformed event.
     * Called when the user presses Enter in the message field or clicks the send button.
     *
     * @param e the ActionEvent object
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == messageField || e.getSource() == sendButton) {
            String message = messageField.getText();
            sendMessage(message);
            messageField.setText("");
        }
    }

    /**
     * Sends a message to the server.
     *
     * @param message the message to send
     */
    private void sendMessage(String message) {
        try {
            System.out.println("Thread Started for Sending the message from Server");

            try {
                System.out.println("Message to Server: " + message);
                if (!message.isEmpty()) {
                    out.writeUTF(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (!message.isEmpty()) {
            chatArea.append("Client: " + message + "\n");
        }
    }

    /**
     * The entry point of the application.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new ChatClientUIF();
    }
}
