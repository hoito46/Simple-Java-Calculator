import java.awt.event.*;
import java.util.Arrays;
import javax.swing.*;

public class Logic {

    String num1 = "0";
    String num2 = null;
    String a = null;

    void clear() {
        num1 = "0";
        num2 = null;
        a = null;
    }

    String noZero(float numDisplay) {
        if (numDisplay % 1 == 0) {
            return String.valueOf((int) numDisplay);
        } else {
            return String.valueOf(numDisplay);
        }
    }

    public Logic(JLabel displayLabel, JButton[] buttons) {
        String[] right = { "÷", "×", "-", "+", "=" };
        String[] top = { "AC", "+/-", "%", "√" };

        for (int i = 0; i < buttons.length; i++) {
            JButton button = buttons[i];

            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    JButton button = (JButton) e.getSource();
                    String value = button.getText();

                    if (Arrays.asList(top).contains(value)) {
                        if (value == "AC") {
                            clear();
                            displayLabel.setText("0");
                        } else if (value == "+/-") {
                            float numDisplay = Float.parseFloat(displayLabel.getText());
                            numDisplay = numDisplay * -1;
                            displayLabel.setText(noZero(numDisplay));
                        } else if (value == "%") {
                            float numDisplay = Float.parseFloat(displayLabel.getText());
                            numDisplay = numDisplay / 100;
                            displayLabel.setText(noZero(numDisplay));
                        } else if (value == "√") {
                            float numDisplay = Float.parseFloat(displayLabel.getText());
                            numDisplay = (float) Math.sqrt(numDisplay);

                            if (numDisplay < 0) {
                                displayLabel.setText("ERROR");
                            } else {
                                displayLabel.setText(noZero(numDisplay));
                            }
                        }
                    }

                    else if (Arrays.asList(right).contains(value)) {
                        if ("+-×÷".contains(value)) {
                            if (a == null) {
                                num1 = displayLabel.getText();
                                displayLabel.setText("0");
                            }
                            a = value;
                        } else if (value == "=") {
                            float n1 = 0;
                            float n2 = 0;

                            if (num1 != null) {
                                num2 = displayLabel.getText();
                                n1 = Float.parseFloat(num1);
                                n2 = Float.parseFloat(num2);
                            }

                            switch (a) {
                                case "+":
                                    displayLabel.setText(noZero(n1 + n2));
                                    break;
                                case "-":
                                    displayLabel.setText(noZero(n1 - n2));
                                    break;
                                case "×":
                                    displayLabel.setText(noZero(n1 * n2));
                                    break;
                                case "÷":
                                    displayLabel.setText(noZero(n1 / n2));
                                    break;
                                default:
                                    break;
                            }

                        }
                    }

                    else {
                        if (value == ".") {
                            if (!displayLabel.getText().contains(value)) {
                                displayLabel.setText(displayLabel.getText() + value);
                            }
                        } else if ("0123456789".contains(value)) {
                            if (displayLabel.getText() == "0") {
                                displayLabel.setText(value);
                            } else {
                                displayLabel.setText(displayLabel.getText() + value);
                            }
                        }
                    }
                }
            });
        }

    }
}