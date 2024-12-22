import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleStringManipulationApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("String Manipulation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(null);

        JLabel inputLabel = new JLabel("Input any string:");
        inputLabel.setBounds(20, 20, 150, 25);
        frame.add(inputLabel);

        JTextField inputField = new JTextField();
        inputField.setBounds(180, 20, 100, 25);
        frame.add(inputField);

        JButton checkPalindromeButton = new JButton("Check Palindrome");
        checkPalindromeButton.setBounds(20, 60, 150, 25);
        checkPalindromeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = inputField.getText();
                String reversed = new StringBuilder(input).reverse().toString();
                if (input.equals(reversed)) {
                    JOptionPane.showMessageDialog(frame, "The input is a palindrome.");
                } else {
                    JOptionPane.showMessageDialog(frame, "The input is not a palindrome.");
                }
            }
        });
        frame.add(checkPalindromeButton);

        JButton reverseButton = new JButton("Reverse");
        reverseButton.setBounds(180, 60, 100, 25);
        reverseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = inputField.getText();
                String reversed = new StringBuilder(input).reverse().toString();
                inputField.setText(reversed);
                JOptionPane.showMessageDialog(frame, "String reversed.");
            }
        });
        frame.add(reverseButton);

        JButton findVowelsButton = new JButton("Find Vowels");
        findVowelsButton.setBounds(20, 100, 150, 25);
        findVowelsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = inputField.getText();
                StringBuilder vowels = new StringBuilder();

                for (char c : input.toCharArray()) {
                    if ("AEIOUaeiou".indexOf(c) != -1) {
                        vowels.append(c);
                    }
                }

                JOptionPane.showMessageDialog(frame, "Vowels in the string: " + vowels.toString());
            }
        });
        frame.add(findVowelsButton);

        frame.setVisible(true);
    }
}
