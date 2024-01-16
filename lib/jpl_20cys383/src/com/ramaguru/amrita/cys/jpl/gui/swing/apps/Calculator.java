package com.ramaguru.amrita.cys.jpl.gui.swing.apps;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A simple calculator application built using Java Swing.
 * This calculator supports basic arithmetic operations.
 *
 * @author Ramaguru Radhakrishnan
 * @version 1.0
 */
public class Calculator extends JFrame {

    private JTextField display;

    private String operator;
    private double operand1;
    private boolean isOperatorClicked = false;

    /**
     * Creates a new instance of the Calculator class.
     * Initializes the UI components and sets up the event listeners.
     */
    public Calculator() {
        setTitle("Simple Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);

        // Create the display field
        display = new JTextField(10);
        display.setEditable(false);

        // Create the number buttons
        JButton button1 = new JButton("1");
        JButton button2 = new JButton("2");
        JButton button3 = new JButton("3");
        JButton button4 = new JButton("4");
        JButton button5 = new JButton("5");
        JButton button6 = new JButton("6");
        JButton button7 = new JButton("7");
        JButton button8 = new JButton("8");
        JButton button9 = new JButton("9");
        JButton button0 = new JButton("0");

        // Create the operator buttons
        JButton buttonPlus = new JButton("+");
        JButton buttonMinus = new JButton("-");
        JButton buttonMultiply = new JButton("*");
        JButton buttonDivide = new JButton("/");
        JButton buttonEquals = new JButton("=");

        // Set layout
        setLayout(new BorderLayout());

        // Create panel for number buttons
        JPanel numberPanel = new JPanel();
        numberPanel.setLayout(new GridLayout(4, 3));
        numberPanel.add(button1);
        numberPanel.add(button2);
        numberPanel.add(button3);
        numberPanel.add(button4);
        numberPanel.add(button5);
        numberPanel.add(button6);
        numberPanel.add(button7);
        numberPanel.add(button8);
        numberPanel.add(button9);
        numberPanel.add(button0);

        // Create panel for operator buttons
        JPanel operatorPanel = new JPanel();
        operatorPanel.setLayout(new GridLayout(5, 1));
        operatorPanel.add(buttonPlus);
        operatorPanel.add(buttonMinus);
        operatorPanel.add(buttonMultiply);
        operatorPanel.add(buttonDivide);
        operatorPanel.add(buttonEquals);

        // Create panel for display and buttons
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(display, BorderLayout.NORTH);
        mainPanel.add(numberPanel, BorderLayout.CENTER);
        mainPanel.add(operatorPanel, BorderLayout.EAST);

        // Add main panel to the content pane
        Container container = getContentPane();
        container.add(mainPanel);

        // Add action listeners to buttons
        ActionListener numberListener = new NumberButtonListener();
        button1.addActionListener(numberListener);
        button2.addActionListener(numberListener);
        button3.addActionListener(numberListener);
        button4.addActionListener(numberListener);
        button5.addActionListener(numberListener);
        button6.addActionListener(numberListener);
        button7.addActionListener(numberListener);
        button8.addActionListener(numberListener);
        button9.addActionListener(numberListener);
        button0.addActionListener(numberListener);

        ActionListener operatorListener = new OperatorButtonListener();
        buttonPlus.addActionListener(operatorListener);
        buttonMinus.addActionListener(operatorListener);
        buttonMultiply.addActionListener(operatorListener);
        buttonDivide.addActionListener(operatorListener);
        buttonEquals.addActionListener(operatorListener);

        pack();
        setLocationRelativeTo(null); // Center the frame on the screen
    }

    /**
     * ActionListener implementation for number buttons.
     * Appends the clicked number to the display text field.
     */
    private class NumberButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            String buttonText = button.getText();
            display.setText(display.getText() + buttonText);
        }
    }

    /**
     * ActionListener implementation for operator buttons.
     * Handles the operator button clicks and performs the calculations.
     */
    private class OperatorButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            String currentText = display.getText();

            if (!isOperatorClicked) {
                operand1 = Double.parseDouble(currentText);
                operator = button.getText();
                display.setText("");
                isOperatorClicked = true;
            } else {
                double operand2 = Double.parseDouble(currentText);
                double result = performCalculation(operand1, operand2, operator);
                display.setText(String.valueOf(result));

            }
        }

        /**
         * Performs the calculation based on the operator.
         *
         * @param operand1 The first operand.
         * @param operand2 The second operand.
         * @param operator The operator (+, -, *, /).
         * @return The result of the calculation.
         */
        private double performCalculation(double operand1, double operand2, String operator) {
            double result = 0.0;
            switch (operator) {
                case "+":
                    result = operand1 + operand2;
                    break;
                case "-":
                    result = operand1 - operand2;
                    break;
                case "*":
                    result = operand1 * operand2;
                    break;
                case "/":
                    result = operand1 / operand2;
                    break;
            }
            return result;
        }
    }

    /**
     * The main entry point of the calculator application.
     *
     * @param args The command line arguments (unused).
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Calculator().setVisible(true);
            }
        });
    }
}
