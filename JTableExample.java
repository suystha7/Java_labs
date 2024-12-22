import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JTableExample {
    public static void main(String[] args) {
        // Create a frame
        JFrame frame = new JFrame("JTable CRUD Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        // Define column names and data
        String[] columnNames = {"ID", "Name", "Age"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(tableModel);

        // Add some sample data
        tableModel.addRow(new Object[]{1, "John Doe", 25});
        tableModel.addRow(new Object[]{2, "Jane Smith", 30});
        tableModel.addRow(new Object[]{3, "Sam Brown", 22});

        // Create a panel for buttons and input fields
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        // Input fields
        JTextField idField = new JTextField(5);
        JTextField nameField = new JTextField(10);
        JTextField ageField = new JTextField(5);

        // Buttons
        JButton addButton = new JButton("Add");
        JButton deleteButton = new JButton("Delete");
        JButton updateButton = new JButton("Update");

        // Add components to the panel
        panel.add(new JLabel("ID:"));
        panel.add(idField);
        panel.add(new JLabel("Name:"));
        panel.add(nameField);
        panel.add(new JLabel("Age:"));
        panel.add(ageField);
        panel.add(addButton);
        panel.add(deleteButton);
        panel.add(updateButton);

        // Add ActionListener for Add Button
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idText = idField.getText();
                String nameText = nameField.getText();
                String ageText = ageField.getText();

                if (!idText.isEmpty() && !nameText.isEmpty() && !ageText.isEmpty()) {
                    try {
                        int id = Integer.parseInt(idText);
                        int age = Integer.parseInt(ageText);
                        tableModel.addRow(new Object[]{id, nameText, age});
                        idField.setText("");
                        nameField.setText("");
                        ageField.setText("");
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(frame, "ID and Age must be numbers!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "All fields are required!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Add ActionListener for Delete Button
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow >= 0) {
                    tableModel.removeRow(selectedRow);
                } else {
                    JOptionPane.showMessageDialog(frame, "Please select a row to delete!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Add ActionListener for Update Button
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow >= 0) {
                    String idText = idField.getText();
                    String nameText = nameField.getText();
                    String ageText = ageField.getText();

                    if (!idText.isEmpty() && !nameText.isEmpty() && !ageText.isEmpty()) {
                        try {
                            int id = Integer.parseInt(idText);
                            int age = Integer.parseInt(ageText);
                            tableModel.setValueAt(id, selectedRow, 0);
                            tableModel.setValueAt(nameText, selectedRow, 1);
                            tableModel.setValueAt(age, selectedRow, 2);
                            idField.setText("");
                            nameField.setText("");
                            ageField.setText("");
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(frame, "ID and Age must be numbers!", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(frame, "All fields are required!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "Please select a row to update!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Add the table to a scroll pane
        JScrollPane scrollPane = new JScrollPane(table);

        // Add components to the frame
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(panel, BorderLayout.SOUTH);

        // Make the frame visible
        frame.setVisible(true);
    }
}
