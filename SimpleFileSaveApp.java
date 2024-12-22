import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class SimpleFileSaveApp {
    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("Simple File Save Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 350);
        frame.setLayout(new BorderLayout());

        // Create a panel for the file name field
        JPanel fileNamePanel = new JPanel(new BorderLayout());
        JLabel fileNameLabel = new JLabel("File Name: ");
        JTextField fileNameField = new JTextField();
        fileNamePanel.add(fileNameLabel, BorderLayout.WEST);
        fileNamePanel.add(fileNameField, BorderLayout.CENTER);
        frame.add(fileNamePanel, BorderLayout.NORTH);

        // Create a text area for typing content
        JTextArea textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Create a panel for the Save button
        JPanel buttonPanel = new JPanel();
        JButton saveButton = new JButton("Save to File");
        buttonPanel.add(saveButton);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        // Add event listener for Save Button
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fileName = fileNameField.getText().trim();
                if (fileName.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please enter a file name.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setSelectedFile(new File(fileName)); // Pre-fill file chooser with the file name
                int choice = fileChooser.showSaveDialog(frame);

                if (choice == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                        writer.write(textArea.getText());
                        JOptionPane.showMessageDialog(frame, "File saved successfully!", "Success",
                                JOptionPane.INFORMATION_MESSAGE);
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(frame, "Error saving file: " + ex.getMessage(), "Error",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        // Make the frame visible
        frame.setVisible(true);
    }
}
