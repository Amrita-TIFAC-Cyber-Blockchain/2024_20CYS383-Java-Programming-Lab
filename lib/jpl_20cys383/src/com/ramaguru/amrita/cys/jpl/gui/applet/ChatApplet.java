package com.ramaguru.amrita.cys.jpl.gui.applet;

/**
 * ChatApplet is a Java applet that provides a user interface for a chat application.
 * Users can enter messages in the input field and send them to the chat area.
 * This applet demonstrates a basic UI for a chat system.
 *
 * @author Ramaguru Radhakrishnan
 * @version 0.5
 *
 * This applet uses the AWT (Abstract Window Toolkit) for creating the UI components.
 * It consists of a chat area, an input field, and a send button.
 * Messages entered by the user are displayed in the chat area.
 * The input field and send button allow the user to send messages.
 *
 * Usage:
 * 1. Initialize the applet using the `init()` method.
 * 2. Enter messages in the input field and press Enter or click the Send button to send them.
 * 3. Sent messages will be displayed in the chat area.
 *
 * Example:
 * <pre>{@code
 *     <applet code="ChatApplet.class" width="500" height="400">
 *     </applet>
 * }</pre>
 *
 * Version History:
 * - 0.5: Initial version of the applet with basic UI components and message display functionality.
 *
 * Known Issues:
 * - The applet UI may not be compatible with all modern web browsers due to deprecated support for Java applets.
 * - No server-side functionality is included for handling or storing messages. This is purely a client-side UI.
 *
 * Disclaimer: This applet is provided as a sample for educational purposes and may not be suitable for production use.
 * It is recommended to use more modern web technologies for developing chat interfaces.
 */

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class ChatApplet extends Applet implements ActionListener {
    private TextField inputField;
    private TextArea chatArea;

    /**
     * Initializes the applet by setting up the UI components.
     */
    public void init() {
        setLayout(new BorderLayout());

        // Create and add the chat area
        chatArea = new TextArea();
        chatArea.setEditable(false);
        add(chatArea, BorderLayout.CENTER);

        // Create and add the input field and send button
        inputField = new TextField();
        inputField.addActionListener(this);
        Button sendButton = new Button("Send");
        sendButton.addActionListener(this);
        Panel inputPanel = new Panel();
        inputPanel.setLayout(new BorderLayout());
        inputPanel.add(inputField, BorderLayout.CENTER);
        inputPanel.add(sendButton, BorderLayout.EAST);
        add(inputPanel, BorderLayout.SOUTH);
    }

    /**
     * Handles the action performed event for the input field and send button.
     * If the input field is used, the message is retrieved and displayed in the chat area.
     * @param e The ActionEvent object representing the event.
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == inputField) {
            String message = inputField.getText();
            displayMessage("User: " + message);
            // Here you can perform any necessary logic to send the message to the chat server or process it as needed
            inputField.setText("");
        }
    }

    /**
     * Displays a message in the chat area.
     * @param message The message to be displayed.
     */
    private void displayMessage(String message) {
        chatArea.append(message + "\n");
    }
}
