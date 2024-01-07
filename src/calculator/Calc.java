package calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Calc extends JFrame {

    public JTextField display;
    public String currentInput = "";
    public double result = 0;
    public String lastOperation = "";

    public Calc() {
        setTitle("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        display = new JTextField();
        display.setEditable(false);
        add(display, BorderLayout.NORTH);

        display.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_BACK_SPACE, 0), "backspace");
        display.getActionMap().put("backspace", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleBackspace();
            }
        });

        display.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char keyChar = e.getKeyChar();
                if (Character.isDigit(keyChar) || keyChar == '.' || "+-*/".indexOf(keyChar) != -1) {
                    handleInput(String.valueOf(keyChar));
                } else if (e.getKeyChar() == '\n') {
                    performOperation();
                }
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 5));

        String[] buttonLabels = {
                "7", "8", "9", "/", "C",
                "4", "5", "6", "*", "",
                "1", "2", "3", "-", "",
                "0", ".", "=", "+", ""
        };

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.addActionListener(new ButtonClickListener());
            buttonPanel.add(button);
        }

        add(buttonPanel, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }

    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton source = (JButton) e.getSource();
            String buttonText = source.getText();

            if (buttonText.equals("=")) {
                performOperation();
            } else if (buttonText.equals("C")) {
                clearCalculator();
            } else if (buttonText.equals("←")) {
                handleBackspace();
            } else {
                handleInput(buttonText);
            }
        }
    }

        public void handleInput(String input) {
            if (input.matches("[0-9.]")) {
                currentInput += input;
                display.setText(currentInput);
            } else if (input.matches("[+\\-*/]")) {
                performOperation();
                lastOperation = input;
                currentInput = "";
            }
        }

        public void performOperation() {
            if (!currentInput.isEmpty()) {
                double currentValue = Double.parseDouble(currentInput);
                switch (lastOperation) {
                    case "+":
                        result += currentValue;
                        break;
                    case "-":
                        result -= currentValue;
                        break;
                    case "*":
                        result *= currentValue;
                        break;
                    case "/":
                        if (currentValue != 0) {
                            result /= currentValue;
                        } else {
                            display.setText("Error");
                            return;
                        }
                        break;
                    default:
                        result = currentValue;
                        break;
                }

                display.setText(String.valueOf(result));
                currentInput = "";
                lastOperation = "";
            }
        }

        public void handleBackspace() {
        if (!currentInput.isEmpty()) {
            currentInput = currentInput.substring(0, currentInput.length() - 1);
            display.setText(currentInput);
            }
        }

        public void clearCalculator() {
            currentInput = "";
            result = 0;
            lastOperation = "";
            display.setText("");
        }

        public static void main(String[] args) {
            SwingUtilities.invokeLater(() -> {
                Calc calculator = new Calc();
                calculator.setVisible(true);
            });
        }
    }
