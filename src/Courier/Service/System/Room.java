package Courier.Service.System;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Room extends JFrame {

    JTable table;
    JButton back;

    Room() {
        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 890, 590);
        panel.setBackground(new Color(3, 45, 48));
        panel.setLayout(null);
        add(panel);

        // Set the image icon
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/icon/img18.png"));
        Image image = imageIcon.getImage().getScaledInstance(300, 200, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(500, 200, 300, 200);
        panel.add(label);

        // Initialize the table
        table = new JTable();
        table.setBounds(10, 40, 500, 400);
        table.setBackground(new Color(3, 45, 48));
        table.setForeground(Color.WHITE);
        panel.add(table);

        // Fetch data from the database and populate the table
        try {
            con c = new con(); // Assuming 'con' is your connection class
            String RoomInfo = "SELECT * FROM storeroom"; // Your SQL query
            ResultSet resultSet = c.statement.executeQuery(RoomInfo); // Execute the query

            // Set the table model using the custom method to populate it
            table.setModel(buildTableModel(resultSet)); // Fill the table with data
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Back button
        back = new JButton("BACK");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(200, 500, 120, 30);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        // Labels for the columns in the table
        JLabel room = new JLabel("Room No.");
        room.setBounds(12, 15, 80, 19);
        room.setForeground(Color.WHITE);
        room.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(room);

        JLabel availability = new JLabel("Availability");
        availability.setBounds(119, 15, 80, 19);
        availability.setForeground(Color.WHITE);
        availability.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(availability);

        JLabel clean = new JLabel("Clean Status");
        clean.setBounds(216, 15, 150, 19);
        clean.setForeground(Color.WHITE);
        clean.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(clean);

        JLabel price = new JLabel("Price");
        price.setBounds(330, 15, 80, 19);
        price.setForeground(Color.WHITE);
        price.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(price);

        JLabel bed = new JLabel("Room Type");
        bed.setBounds(417, 15, 80, 19);
        bed.setForeground(Color.WHITE);
        bed.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(bed);

        setUndecorated(true);
        setLayout(null);
        setLocation(450, 100);
        setSize(900, 600);
        setVisible(true);
    }

    // Method to build table model from ResultSet
    public static DefaultTableModel buildTableModel(ResultSet resultSet) throws SQLException {
        // Get the metadata to fetch column names
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();

        // Fetch column names dynamically
        String[] columnNames = new String[columnCount];
        for (int i = 1; i <= columnCount; i++) {
            columnNames[i - 1] = metaData.getColumnName(i);
        }

        // Create a table model to hold the data
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        // Iterate through the ResultSet and populate the model with rows
        while (resultSet.next()) {
            Object[] row = new Object[columnCount];
            for (int i = 1; i <= columnCount; i++) {
                row[i - 1] = resultSet.getObject(i); // Get each column's value from ResultSet
            }
            model.addRow(row); // Add the row to the table model
        }

        return model; // Return the populated table model
    }

    public static void main(String[] args) {
        new Room(); // Create and show the Room window
    }
}
