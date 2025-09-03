import java.awt.*;
import java.util.Arrays;
import javax.swing.*;

public class UI {
    int w = 360;
    int h = 600;

    Color orange = new Color(220, 133, 49);
    Color gray = new Color(149, 149, 149);
    Color white = new Color(255, 255, 255);
    Color black = new Color(94, 96, 97);
    Color black2 = new Color(0, 0, 0);

    String[] buttonnum = { "AC", "+/-", "%", "÷", "7", "8", "9", "×", "4", "5", "6", "-", "1", "2", "3", "+", "0", ".",
            "√", "=" };
    String[] right = { "÷", "×", "-", "+", "=" };
    String[] top = { "AC", "+/-", "%" };

    JFrame frame = new JFrame("CAL");
    JLabel displayLabel = new JLabel();
    JPanel displayPanel = new JPanel();
    JPanel displayButton = new JPanel();

    JButton[] buttons = new JButton[buttonnum.length];

    UI() {
        frame.setVisible(true);
        frame.setSize(w, h);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        displayLabel.setBackground(white);
        displayLabel.setForeground(black2);
        displayLabel.setFont(new Font("Arial", Font.PLAIN, 80));
        displayLabel.setHorizontalAlignment(JLabel.RIGHT);
        displayLabel.setText("0");
        displayLabel.setOpaque(true);

        displayPanel.setLayout(new BorderLayout());
        displayPanel.add(displayLabel);

        frame.add(displayLabel, BorderLayout.NORTH);

        displayButton.setLayout(new GridLayout(5, 4));

        for (int i = 0; i < buttonnum.length; i++) {
            String value = buttonnum[i];
            JButton button = new JButton(value);

            buttons[i] = button;

            button.setFont(new Font("Arial", Font.PLAIN, 30));

            if (Arrays.asList(top).contains(value)) {
                button.setBackground(gray);
                button.setForeground(white);
            } else if (Arrays.asList(right).contains(value)) {
                button.setBackground(orange);
                button.setForeground(white);
            } else {
                button.setBackground(black);
                button.setForeground(white);
            }

            displayButton.add(button);

        }

        frame.add(displayButton, BorderLayout.CENTER);

        new Logic(displayLabel, buttons);
    }

}