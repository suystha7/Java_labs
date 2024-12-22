import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;

public class SimpleFileSaveApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Simple File Save Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 350);
        frame.setLayout(new BorderLayout());

        JPanel fileNamePanel = new JPanel(new BorderLayout());
        JLabel fileNameLabel = new JLabel("File Name: ");
        JTextField fileNameField = new JTextField();
        fileNamePanel.add(fileNameLabel, BorderLayout.WEST);
        fileNamePanel.add(fileNameField, BorderLayout.CENTER);
        frame.add(fileNamePanel, BorderLayout.NORTH);

        JTextArea textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        frame.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        JButton saveButton = new JButton("Save to File");
        buttonPanel.add(saveButton);
        frame.add(buttonPanel, BorderLayout.SOUTH);
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
                fileChooser.setSelectedFile(new File(fileName)); 
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

        frame.setVisible(true);
    }
}
