package Courier.Service.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateCheck extends JFrame {
    UpdateCheck() {
        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 940, 490);
        panel.setBackground(new Color(3, 45, 48));
        panel.setLayout(null);
        add(panel);

        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/icon/updated.png"));
        Image image = imageIcon.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(500, 60, 300, 300);
        panel.add(label);

        JLabel label1 = new JLabel("Check-In Details");
        label1.setBounds(124, 11, 222, 25);
        label1.setFont(new Font("Tahoma", Font.BOLD, 20));
        label1.setForeground(Color.WHITE);
        panel.add(label1);

        JLabel label2 = new JLabel("Document:");
        label2.setBounds(25, 85, 90, 14);
        label2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label2.setForeground(Color.WHITE);
        panel.add(label2);

        Choice c = new Choice();
        c.setBounds(248, 82, 140, 20);
        panel.add(c);

        // Load customer numbers into the dropdown
        try {
            con C = new con();
            ResultSet resultSet = C.statement.executeQuery("SELECT * FROM customer");
            while (resultSet.next()) {
                c.add(resultSet.getString("number"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel label3 = new JLabel("Name:");
        label3.setBounds(25, 120, 107, 14);
        label3.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label3.setForeground(Color.WHITE);
        panel.add(label3);

        JTextField textField3 = new JTextField();
        textField3.setBounds(248, 115, 140, 20);
        panel.add(textField3);

        JLabel label4 = new JLabel("Origin:");
        label4.setBounds(25, 155, 97, 20);
        label4.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label4.setForeground(Color.WHITE);
        panel.add(label4);

        JTextField textField4 = new JTextField();
        textField4.setBounds(248, 150, 140, 20);
        panel.add(textField4);

        JLabel label5 = new JLabel("Destination:");
        label5.setBounds(25, 190, 97, 14);
        label5.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label5.setForeground(Color.WHITE);
        panel.add(label5);

        JTextField textField5 = new JTextField();
        textField5.setBounds(248, 185, 140, 20);
        panel.add(textField5);

        JLabel label6 = new JLabel("Checked-in:");
        label6.setBounds(25, 225, 97, 14);
        label6.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label6.setForeground(Color.WHITE);
        panel.add(label6);

        JTextField textField6 = new JTextField();
        textField6.setBounds(248, 220, 175, 20);
        panel.add(textField6);

        JLabel label7 = new JLabel("Amount Paid (taka):");
        label7.setBounds(25, 260, 200, 14);
        label7.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label7.setForeground(Color.WHITE);
        panel.add(label7);

        JTextField textField7 = new JTextField();
        textField7.setBounds(248, 255, 140, 20);
        panel.add(textField7);

        JLabel label8 = new JLabel("Pending Amount (taka):");
        label8.setBounds(25, 295, 225, 20);
        label8.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label8.setForeground(Color.WHITE);
        panel.add(label8);

        JTextField textField8 = new JTextField();
        textField8.setBounds(248, 290, 140, 20);
        panel.add(textField8);

        // Update button functionality
        JButton update = new JButton("Update");
        update.setBounds(56, 410, 89, 23);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        panel.add(update);
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    con C = new con();
                    String q = c.getSelectedItem();
                    String name = textField3.getText();
                    String origin = textField4.getText();
                    String destination = textField5.getText();
                    String checkintime = textField6.getText();
                    String deposit = textField7.getText();
                    C.statement.executeUpdate("UPDATE customer SET name = '" + name + "', origin = '" + origin + "', destination = '" + destination + "', checkintime = '" + checkintime + "', deposit = '" + deposit + "' WHERE number = '" + q + "'");
                    JOptionPane.showMessageDialog(null, "Updated Successfully");
                    setVisible(false);
                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        });

        // Back button functionality
        JButton back = new JButton("Back");
        back.setBounds(168, 410, 89, 23);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        // Check button functionality
        JButton check = new JButton("Check");
        check.setBounds(281, 410, 89, 23);
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        panel.add(check);
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = c.getSelectedItem();
                String query = "SELECT * FROM customer WHERE number = '" + id + "'";

                try {
                    con C = new con();
                    ResultSet resultSet = C.statement.executeQuery(query);

                    if (resultSet.next()) {
                        textField3.setText(resultSet.getString("name"));
                        textField4.setText(resultSet.getString("origin"));
                        textField5.setText(resultSet.getString("destination"));
                        textField6.setText(resultSet.getString("checkintime"));
                        textField7.setText(resultSet.getString("deposit"));

                        // Calculate and set pending amount
                        String total = resultSet.getString("total");
                        int pendingAmount = Integer.parseInt(total) - Integer.parseInt(textField7.getText());
                        textField8.setText(String.valueOf(pendingAmount));
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        setLayout(null);
        setSize(950, 500);
        setLocation(400, 200);
        setVisible(true);
    }

    public static void main(String[] args) {
        new UpdateCheck();
    }
}
