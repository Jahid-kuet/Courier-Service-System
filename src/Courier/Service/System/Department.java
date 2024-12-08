package Courier.Service.System;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class Department extends JFrame {
    Department() {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(3, 45, 48));
        panel.setBounds(5, 5, 690, 490);
        panel.setLayout(null);
        add(panel);

        // Initialize the table
        JTable table = new JTable();
        table.setBounds(0, 40, 700, 350);
        table.setBackground(new Color(4, 45, 48));
        table.setForeground(Color.WHITE);
        panel.add(table);

        // Fetch data from the database and populate the table
        try {
            con c = new con(); // Assuming 'con' is your connection class
            String departmentInfo = "SELECT * FROM department"; // SQL query
            ResultSet resultSet = c.statement.executeQuery(departmentInfo); // Execute the query

            // Set the table model using the custom method to populate it
            table.setModel(buildTableModel(resultSet)); // Fill the table with data
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Back button
        JButton back = new JButton("BACK");
        back.setBounds(400, 410, 120, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false); // Close the window when clicked
            }
        });

        // Labels for the columns in the table
        JLabel label1 = new JLabel("Department");
        label1.setBounds(145, 11, 105, 20);
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label1);

        JLabel label2 = new JLabel("Budget");
        label2.setBounds(431, 11, 105, 20);
        label2.setForeground(Color.WHITE);
        label2.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label2);

        // Set JFrame properties
        setUndecorated(true);
        setLayout(null);
        setLocation(550, 150);
        setSize(700, 500);
        setVisible(true);
    }

    // Method to build table model from ResultSet
    public static DefaultTableModel buildTableModel(ResultSet resultSet) throws SQLException {
        // Get metadata from ResultSet to fetch column names
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();

        // Fetch column names dynamically
        String[] columnNames = new String[columnCount];
        for (int i = 1; i <= columnCount; i++) {
            columnNames[i - 1] = metaData.getColumnName(i);
        }

        // Create a table model to hold the data
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        // Iterate through ResultSet and populate the table model with rows
        while (resultSet.next()) {
            Object[] row = new Object[columnCount];
            for (int i = 1; i <= columnCount; i++) {
                row[i - 1] = resultSet.getObject(i); // Get each column value from ResultSet
            }
            model.addRow(row); // Add the row to the table model
        }

        return model; // Return the populated table model
    }

    public static void main(String[] args) {
        new Department(); // Create and show the Department window
    }
}
