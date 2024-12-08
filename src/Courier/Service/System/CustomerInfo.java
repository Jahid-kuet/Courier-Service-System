package Courier.Service.System;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class CustomerInfo extends JFrame {
    CustomerInfo() {
        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 1040, 590);
        panel.setBackground(new Color(3, 45, 48));
        panel.setLayout(null);
        add(panel);

        JTable table = new JTable();
        table.setBounds(30, 40, 970, 450);
        table.setBackground(new Color(3, 45, 48));
        table.setForeground(Color.WHITE);
        panel.add(table);

        // Populate the table
        try {
            con c = new con();
            String q = "select * from customer";
            ResultSet resultSet = c.statement.executeQuery(q);

            // Build the table model manually
            DefaultTableModel model = buildTableModel(resultSet);
            table.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel id = new JLabel("Document");
        id.setBounds(25, 11, 100, 20);
        id.setForeground(Color.WHITE);
        id.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(id);

        JLabel number = new JLabel("Number");
        number.setBounds(125, 11, 100, 20);
        number.setForeground(Color.WHITE);
        number.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(number);

        JLabel name = new JLabel("Name");
        name.setBounds(220, 11, 100, 20);
        name.setForeground(Color.WHITE);
        name.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(name);

        JLabel gender = new JLabel("Gender");
        gender.setBounds(320, 11, 100, 20);
        gender.setForeground(Color.WHITE);
        gender.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(gender);

        JLabel country = new JLabel("Country");
        country.setBounds(420, 11, 100, 20);
        country.setForeground(Color.WHITE);
        country.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(country);

        JLabel room = new JLabel("Origin");
        room.setBounds(525, 11, 100, 20);
        room.setForeground(Color.WHITE);
        room.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(room);

        JLabel time = new JLabel("Destination");
        time.setBounds(620, 11, 100, 20);
        time.setForeground(Color.WHITE);
        time.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(time);

        JLabel checkin = new JLabel("CI time");
        checkin.setBounds(730, 11, 100, 20);
        checkin.setForeground(Color.WHITE);
        checkin.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(checkin);

        JLabel deposit = new JLabel("Deposit");
        deposit.setBounds(820, 11, 100, 20);
        deposit.setForeground(Color.WHITE);
        deposit.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(deposit);

        JLabel total = new JLabel("Total");
        total.setBounds(930, 11, 100, 20);
        total.setForeground(Color.WHITE);
        total.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(total);

        JButton back = new JButton("Back");
        back.setBounds(450, 510, 120, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setUndecorated(true);
        setLayout(null);
        setSize(1050, 600);
        setLocation(400, 100);
        setVisible(true);
    }

    // Method to build the table model from ResultSet
    private DefaultTableModel buildTableModel(ResultSet resultSet) throws SQLException {
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
        new CustomerInfo();
    }
}
