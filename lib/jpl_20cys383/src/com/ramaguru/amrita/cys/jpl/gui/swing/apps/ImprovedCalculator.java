package com.ramaguru.amrita.cys.jpl.gui.swing.apps;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * A simple calculator application built using Java Swing.
 * This calculator supports basic arithmetic operations.
 *
 * @author Ramaguru Radhakrishnan
 * @version 1.0
 */

public class ImprovedCalculator extends JFrame {

    private JTextField display;

        private String operator;
    private double operand1;
    private boolean isOperatorClicked;

    /**
     * Constructs an instance of ImprovedCalculator.
     */
    public ImprovedCalculator() {
        setTitle("Simple Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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

        // Create the clear button
        JButton buttonClear = new JButton("Clear");

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
        numberPanel.add(buttonClear);

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

        ActionListener clearListener = new ClearButtonListener();
        buttonClear.addActionListener(clearListener);

        // Add key listener to the display field
        KeyListener keyListener = new DisplayKeyListener();
        display.addKeyListener(keyListener);

        pack();
        setLocationRelativeTo(null); // Center the frame on the screen
    }

    /**
     * ActionListener implementation for number buttons.
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
                operand1 = result;
                operator = button.getText();
            }
        }

        /**
         * Performs the calculation based on the operator.
         *
         * @param operand1 the first operand
         * @param operand2 the second operand
         * @param operator the operator
         * @return the result of the calculation
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
     * ActionListener implementation for the clear button.
     */
    private class ClearButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            display.setText("");
            operand1 = 0;
            operator = null;
            isOperatorClicked = false;
        }
    }

    /**
     * KeyListener implementation for the display field.
     */
    private class DisplayKeyListener implements KeyListener {
        @Override
        public void keyTyped(KeyEvent e) {
            // Not used
        }

        @Override
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();

            // Handle numeric key inputs
            if (keyCode >= KeyEvent.VK_0 && keyCode <= KeyEvent.VK_9) {
                String digit = KeyEvent.getKeyText(keyCode);
                display.setText(display.getText() + digit);
            }

            // Handle operator key inputs
            if (keyCode == KeyEvent.VK_PLUS) {
                operatorButtonClicked("+");
            } else if (keyCode == KeyEvent.VK_MINUS) {
                operatorButtonClicked("-");
            } else if (keyCode == KeyEvent.VK_MULTIPLY) {
                operatorButtonClicked("*");
            } else if (keyCode == KeyEvent.VK_DIVIDE) {
                operatorButtonClicked("/");
            } else if (keyCode == KeyEvent.VK_EQUALS || keyCode == KeyEvent.VK_ENTER) {
                operatorButtonClicked("=");
            }
        }

        /**
         * Handles the operator button clicks triggered by key events.
         *
         * @param op the operator
         */
        private void operatorButtonClicked(String op) {
            String currentText = display.getText();

            if (!isOperatorClicked) {
                operand1 = Double.parseDouble(currentText);
                operator = op;
                display.setText("");
                isOperatorClicked = true;
            } else {
                double operand2 = Double.parseDouble(currentText);
                double result = performCalculation(operand1, operand2, operator);
                display.setText(String.valueOf(result));
                operand1 = result;
                operator = op;
            }
        }

        /**
         * Performs the calculation based on the operator.
         *
         * @param operand1 the first operand
         * @param operand2 the second operand
         * @param operator the operator
         * @return the result of the calculation
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

        @Override
        public void keyReleased(KeyEvent e) {
            // Not used
        }
    }

    /**
     * The main method that creates and displays the calculator GUI.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ImprovedCalculator().setVisible(true);
            }
        });
    }
}
