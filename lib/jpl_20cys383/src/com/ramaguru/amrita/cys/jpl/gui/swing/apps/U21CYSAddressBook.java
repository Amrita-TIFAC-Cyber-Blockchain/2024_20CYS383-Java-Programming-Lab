package com.ramaguru.amrita.cys.jpl.gui.swing.apps;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Address book application for 21CYS
 * @author Ramaguru Radhakrishnan
 * @version 1.0
 */
public class U21CYSAddressBook extends JFrame {

    private JTable contactTable;
    private DefaultTableModel tableModel;

    private JTextField nameField;
    private JTextField phoneField;
    private JTextField emailField;

    /**
     * Constructs the U21CYSAddressBook frame.
     * Initializes the GUI components and sets up the layout.
     */
    public U21CYSAddressBook() {
        setTitle("21CYS Address Book");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the table with default table model
        tableModel = new DefaultTableModel(new Object[]{"Name", "Phone Number", "Email"}, 0);
        contactTable = new JTable(tableModel);

        // Create the scroll pane and add the table to it
        JScrollPane scrollPane = new JScrollPane(contactTable);


        // Create the main panel and set layout
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // Create the form panel and add labels and text fields
        JPanel formPanel = new JPanel();


        // Create the button panel and add buttons
        JPanel buttonPanel = new JPanel();


        // Add scroll pane, form panel, and button panel to the main panel
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(formPanel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Add the main panel to the content pane
        Container container = getContentPane();
        container.add(mainPanel);

        pack();
        setLocationRelativeTo(null); // Center the frame on the screen
    }

    /**
     * Validates a phone number.
     *
     * @param phone the phone number to validate
     * @return true if the phone number is valid, false otherwise
     */
    private boolean isValidPhoneNumber(String phone) {
        // Perform validation logic for phone number (e.g., length, format, etc.)
        return true;
    }

    /**
     * Validates an email address.
     *
     * @param email the email address to validate
     * @return true if the email address is valid, false otherwise
     */
    private boolean isValidEmail(String email) {
        // Perform validation logic for email (e.g., format, etc.)
        return true;
    }

    /**
     * Clears the form fields.
     */
    private void clearFormFields() {

    }

    /**
     * ActionListener for the Add button.
     * Adds a new contact to the address book.
     */
    private class AddButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    /**
     * ActionListener for the Edit button.
     * Edits an existing contact in the address book.
     */
    private class EditButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    /**
     * ActionListener for the Delete button.
     * Deletes a contact from the address book.
     */
    private class DeleteButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    /**
     * Entry point of the application.
     * Creates and displays the U21CYSAddressBook frame.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new U21CYSAddressBook().setVisible(true);
            }
        });
    }
}
