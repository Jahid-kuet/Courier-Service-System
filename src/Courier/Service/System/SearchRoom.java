package Courier.Service.System;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class SearchRoom extends JFrame implements ActionListener {
    JCheckBox checkBox;
    Choice choice;
    JTable table;
    JButton add, back;

    SearchRoom() {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(3, 45, 48));
        panel.setBounds(5, 5, 690, 490);
        panel.setLayout(null);
        add(panel);

        JLabel searchForRoom = new JLabel("Search For Room");
        searchForRoom.setBounds(250, 11, 186, 31);
        searchForRoom.setForeground(Color.WHITE);
        searchForRoom.setFont(new Font("Tahoma", Font.BOLD, 20));
        panel.add(searchForRoom);

        JLabel rbt = new JLabel("Room Type:");
        rbt.setBounds(50, 73, 120, 20);
        rbt.setForeground(Color.WHITE);
        rbt.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(rbt);

        JLabel rn = new JLabel("Room Number");
        rn.setBounds(23, 162, 150, 20);
        rn.setForeground(Color.WHITE);
        rn.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(rn);

        JLabel available = new JLabel("Availability");
        available.setBounds(175, 162, 150, 20);
        available.setForeground(Color.WHITE);
        available.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(available);

        JLabel price = new JLabel("Maintaining Cost");
        price.setBounds(425, 162, 150, 20);
        price.setForeground(Color.WHITE);
        price.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(price);

        JLabel BT = new JLabel("Room Type");
        BT.setBounds(580, 162, 150, 20);
        BT.setForeground(Color.WHITE);
        BT.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(BT);

        JLabel SS = new JLabel("Clean Status");
        SS.setBounds(306, 162, 150, 20);
        SS.setForeground(Color.WHITE);
        SS.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(SS);

        checkBox = new JCheckBox("Only Display Available");
        checkBox.setBounds(400, 69, 205, 23);
        checkBox.setForeground(Color.WHITE);
        checkBox.setBackground(new Color(3, 45, 48));
        panel.add(checkBox);

        choice = new Choice();
        choice.add("Small");
        choice.add("Big");
        choice.setBounds(170, 70, 120, 20);
        panel.add(choice);

        table = new JTable();
        table.setBounds(0, 187, 700, 150);
        table.setBackground(new Color(3, 45, 48));
        table.setForeground(Color.WHITE);
        panel.add(table);

        try {
            con c = new con();
            String q = "select * from storeroom";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(buildTableModel(resultSet));
        } catch (Exception e) {
            e.printStackTrace();
        }

        add = new JButton("Search");
        add.setBounds(200, 400, 120, 30);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        panel.add(add);

        back = new JButton("Back");
        back.setBounds(380, 400, 120, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        panel.add(back);

        setUndecorated(true);
        setLayout(null);
        setLocation(500, 200);
        setSize(700, 500);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == add) {
            String Q = "select * from storeroom where room_type = '" + choice.getSelectedItem() + "'";
            String Q1 = "select * from storeroom where availability = 'Available'  And room_type = '" + choice.getSelectedItem() + "'";
            try {
                con c = new con();
                ResultSet resultSet = c.statement.executeQuery(Q);
                table.setModel(buildTableModel(resultSet));
                if(checkBox.isSelected()){
                    ResultSet resultSet1 = c.statement.executeQuery(Q1);
                    table.setModel(buildTableModel(resultSet1));
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }

    // Method to build the table model from ResultSet
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
        new SearchRoom();
    }
}
