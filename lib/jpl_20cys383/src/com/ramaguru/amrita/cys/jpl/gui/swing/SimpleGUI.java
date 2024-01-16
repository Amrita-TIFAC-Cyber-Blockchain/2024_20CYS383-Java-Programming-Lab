package com.ramaguru.amrita.cys.jpl.gui.swing;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The ActionListenerExample class demonstrates the usage of an ActionListener with a JButton.
 * It creates a JFrame with a single JButton. When the button is clicked, a message dialog is displayed.
 * This class provides a basic example of handling button click events using ActionListener in Java Swing.
 *
 * Dependencies:
 * - None
 *
 * @author Ramaguru Radhakrishnan
 * @version 0.5
 */
public class SimpleGUI {
    /**
     * The main method is the entry point of the program.
     * It creates a JFrame and sets up a JButton with an ActionListener.
     *
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        // Create the JFrame
        JFrame frame = new JFrame("Simpele GUI Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the JButton
        JButton button = new JButton("Dare to touch Me!");

        // Create an ActionListener
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Display a message dialog when the button is clicked
                JOptionPane.showMessageDialog(frame, "You just clicked the Button!");
            }
        };

        // Add the ActionListener to the button
        button.addActionListener(listener);

        // Add the button to the JFrame
        frame.getContentPane().add(button);

        // Set the JFrame size and make it visible
        frame.setSize(300, 150);
        frame.setVisible(true);
    }
}
