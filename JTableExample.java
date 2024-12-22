import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class JTableExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("JTable CRUD Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        String[] columnNames = {"ID", "Name", "Age"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(tableModel);

        
        tableModel.addRow(new Object[]{1, "John Doe", 25});
        tableModel.addRow(new Object[]{2, "Jane Smith", 30});
        tableModel.addRow(new Object[]{3, "Sam Brown", 22});

        
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        
        JTextField idField = new JTextField(5);
        JTextField nameField = new JTextField(10);
        JTextField ageField = new JTextField(5);


        JButton addButton = new JButton("Add");
        JButton deleteButton = new JButton("Delete");
        JButton updateButton = new JButton("Update");

        panel.add(new JLabel("ID:"));
        panel.add(idField);
        panel.add(new JLabel("Name:"));
        panel.add(nameField);
        panel.add(new JLabel("Age:"));
        panel.add(ageField);
        panel.add(addButton);
        panel.add(deleteButton);
        panel.add(updateButton);
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
        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(panel, BorderLayout.SOUTH);
        frame.setVisible(true);
    }
}
