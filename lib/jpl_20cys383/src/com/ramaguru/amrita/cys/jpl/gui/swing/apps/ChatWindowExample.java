package com.ramaguru.amrita.cys.jpl.gui.swing.apps;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The ChatWindowExample class demonstrates a simple chat window using ActionListener.
 * It creates a JFrame with a JTextArea for displaying messages and a JTextField for entering new messages.
 * When the "Send" button is clicked or Enter key is pressed, the entered message is displayed in the chat window.
 * This class provides a basic example of implementing a chat-like interface using ActionListener in Java Swing.
 *
 * Dependencies:
 * - None
 *
 * @author Ramaguru Radhakrishnan
 * @version 0.5
 */
public class ChatWindowExample {
    private JFrame frame;
    private JTextArea chatArea;
    private JTextField messageField;

    /**
     * Creates a new instance of the ChatWindowExample class.
     * Initializes the chat window UI components and sets up event listeners.
     */
    public ChatWindowExample() {
        // Create the JFrame
        frame = new JFrame("Chat Window");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Create the JTextArea for displaying messages
        chatArea = new JTextArea();
        chatArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(chatArea);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Create the JTextField for entering messages
        messageField = new JTextField();
        messageField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String message = messageField.getText();
                appendMessage("You: " + message);
                messageField.setText("");
            }
        });
        frame.add(messageField, BorderLayout.SOUTH);

        // Create the "Send" button
        JButton sendButton = new JButton("Send");
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String message = messageField.getText();
                appendMessage("You: " + message);
                messageField.setText("");
            }
        });
        frame.add(sendButton, BorderLayout.EAST);

        // Set the JFrame size and make it visible
        frame.setSize(400, 300);
        frame.setVisible(true);
    }

    /**
     * Appends a message to the chat area.
     * Scrolls to the bottom to show the latest message.
     *
     * @param message the message to append
     */
    private void appendMessage(String message) {
        chatArea.append(message + "\n");
        chatArea.setCaretPosition(chatArea.getDocument().getLength());
    }

    /**
     * The main method is the entry point of the program.
     * Creates an instance of ChatWindowExample to start the chat window.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ChatWindowExample();
            }
        });
    }
}
