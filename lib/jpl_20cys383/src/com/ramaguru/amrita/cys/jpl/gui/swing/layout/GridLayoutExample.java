package com.ramaguru.amrita.cys.jpl.gui.swing.layout;

import javax.swing.*;
import java.awt.*;

/**
 * This class demonstrates the usage of GridLayout in Java Swing.
 * It creates a simple GUI window with components arranged using GridLayout.
 *
 * @author Ramaguru Radhakrishnan
 * @version 0.5
 */
public class GridLayoutExample extends JFrame {

    /**
     * Constructs the GridLayoutExample window.
     */
    public GridLayoutExample() {
        setTitle("GridLayout Example");
        setSize(320, 80);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the GridLayout as the layout manager for the frame
        setLayout(new GridLayout(2, 2));

        // Create and add components to the content pane

        // Labels
        JLabel label1 = new JLabel("Name", JLabel.CENTER);
        JLabel label2 = new JLabel("Email", JLabel.CENTER);


        // TextArea
        JTextArea tarea1 = new JTextArea("Ramaguru R");
        JTextArea tarea2 = new JTextArea("ram@jpl.in");


        // Add components to the content pane
        add(label1);
        add(tarea1);
        add(label2);
        add(tarea2);


        // Make the window visible
        setVisible(true);
    }

    /**
     * Main method to launch the application.
     *
     * @param args command-line arguments (unused)
     */
    public static void main(String[] args) {
        new GridLayoutExample();
    }
}

