package Courier.Service.System;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class ManagerInfo extends JFrame {
    ManagerInfo() {
        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 990, 590);
        panel.setBackground(new Color(3, 45, 48));
        panel.setLayout(null);
        add(panel);

        JTable table = new JTable();
        table.setBounds(10, 34, 980, 450);
        table.setForeground(Color.WHITE);
        table.setBackground(new Color(3, 45, 48));
        panel.add(table);

        try {
            con c = new con(); // Assuming 'con' is your connection class
            String query = "SELECT * FROM employee WHERE job = 'Manager'"; // SQL query
            ResultSet resultSet = c.statement.executeQuery(query);

            // Populate the table using a custom method
            table.setModel(buildTableModel(resultSet));

        } catch (Exception e) {
            e.printStackTrace();
        }

        JButton back = new JButton("BACK");
        back.setBounds(350, 500, 120, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        JLabel name = new JLabel("Name");
        name.setBounds(41, 11, 70, 19);
        name.setForeground(Color.WHITE);
        name.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(name);

        JLabel age = new JLabel("Age");
        age.setBounds(159, 11, 70, 19);
        age.setForeground(Color.WHITE);
        age.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(age);

        JLabel gender = new JLabel("Gender");
        gender.setBounds(273, 11, 70, 19);
        gender.setForeground(Color.WHITE);
        gender.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(gender);

        JLabel job = new JLabel("Job");
        job.setBounds(416, 11, 70, 19);
        job.setForeground(Color.WHITE);
        job.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(job);

        JLabel salary = new JLabel("Salary");
        salary.setBounds(536, 11, 70, 19);
        salary.setForeground(Color.WHITE);
        salary.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(salary);

        JLabel phone = new JLabel("Phone");
        phone.setBounds(656, 11, 70, 19);
        phone.setForeground(Color.WHITE);
        phone.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(phone);

        JLabel gmail = new JLabel("Gmail");
        gmail.setBounds(786, 11, 70, 19);
        gmail.setForeground(Color.WHITE);
        gmail.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(gmail);

        JLabel aadhar = new JLabel("Nid No");
        aadhar.setBounds(896, 11, 70, 19);
        aadhar.setForeground(Color.WHITE);
        aadhar.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(aadhar);

        setUndecorated(true);
        setLayout(null);
        setLocation(430, 100);
        setSize(1000, 600);
        setVisible(true);
    }

    // Method to build the table model from the ResultSet
    public static DefaultTableModel buildTableModel(ResultSet resultSet) throws SQLException {
        ResultSetMetaData metaData = resultSet.getMetaData();

        // Get column names
        int columnCount = metaData.getColumnCount();
        String[] columnNames = new String[columnCount];
        for (int i = 1; i <= columnCount; i++) {
            columnNames[i - 1] = metaData.getColumnName(i);
        }

        // Create the table model
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        // Populate the rows
        while (resultSet.next()) {
            Object[] row = new Object[columnCount];
            for (int i = 1; i <= columnCount; i++) {
                row[i - 1] = resultSet.getObject(i);
            }
            model.addRow(row);
        }
        return model;
    }

    public static void main(String[] args) {
        new ManagerInfo();
    }
}
