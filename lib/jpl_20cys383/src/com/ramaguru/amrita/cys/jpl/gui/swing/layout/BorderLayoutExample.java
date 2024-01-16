package com.ramaguru.amrita.cys.jpl.gui.swing.layout;

import javax.swing.*;
import java.awt.*;

/**
 * This class demonstrates the usage of BorderLayout in Java Swing.
 * It creates a simple GUI window with components arranged using BorderLayout.
 *
 * @author Ramaguru Radhakrishnan
 * @version 0.5
 */
public class BorderLayoutExample extends JFrame {

    /**
     * Constructs the BorderLayoutExample window.
     */
    public BorderLayoutExample() {
        setTitle("BorderLayout Example");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the BorderLayout as the layout manager for the frame
        setLayout(new BorderLayout());

        // Create and add components to the content pane

        // Header Label at the top (North) of the window
        JLabel headerLabel = new JLabel("Welcome to Java Programming Lab", JLabel.CENTER);
        add(headerLabel, BorderLayout.NORTH);

        // Content TextArea in the center of the window
        JTextArea contentTextArea = new JTextArea();
        add(contentTextArea, BorderLayout.CENTER);

        // Submit Button at the bottom (South) of the window
        JButton submitButton = new JButton("Submit Feedback");
        add(submitButton, BorderLayout.SOUTH);

        // Make the window visible
        setVisible(true);
    }

    /**
     * Main method to launch the application.
     *
     * @param args command-line arguments (unused)
     */
    public static void main(String[] args) {
        new BorderLayoutExample();
    }
}
