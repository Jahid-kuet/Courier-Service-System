package Courier.Service.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateStoreRoom extends JFrame {
    UpdateStoreRoom(){
        JPanel panel = new JPanel();
        panel.setBounds(5,5,940,490);
        panel.setBackground(new Color(3,45,48));
        panel.setLayout(null);
        add(panel);

        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/icon/update.png"));
        Image image = imageIcon.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(500,60,300,300);
        panel.add(label);

        JLabel label1  = new JLabel("Update StoreRoom Status");
        label1.setBounds(124,11,300,25);
        label1.setFont(new Font("Tahoma", Font.BOLD, 20));
        label1.setForeground(Color.WHITE);
        panel.add(label1);

        JLabel label2  = new JLabel("Room Number :");
        label2.setBounds(25,88,120,14);
        label2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label2.setForeground(Color.WHITE);
        panel.add(label2);

        Choice c = new Choice();
        c.setBounds(248,85,140,20);
        panel.add(c);

        try {
            con C = new con();
            ResultSet resultSet = C.statement.executeQuery("select * from storeroom");
            while (resultSet.next()){
                c.add(resultSet.getString("room_number"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel label3  = new JLabel("Availability :");
        label3.setBounds(25,129,120,20);
        label3.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label3.setForeground(Color.WHITE);
        panel.add(label3);

        JTextField textField3 = new JTextField();
        textField3.setBounds(248,129,140,20);
        panel.add(textField3);

        JLabel label4  = new JLabel("Clean Status :");
        label4.setBounds(25,174,120,14);
        label4.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label4.setForeground(Color.WHITE);
        panel.add(label4);

        JTextField textField4 = new JTextField();
        textField4.setBounds(248,174,140,20);
        panel.add(textField4);

        JLabel label5  = new JLabel("Maintaining Cost :");
        label5.setBounds(25,216,130,20);
        label5.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label5.setForeground(Color.WHITE);
        panel.add(label5);

        JTextField textField5 = new JTextField();
        textField5.setBounds(248,216,140,20);
        panel.add(textField5);

        JLabel label6  = new JLabel("Room Type :");
        label6.setBounds(25,260,120,20);
        label6.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label6.setForeground(Color.WHITE);
        panel.add(label6);

        JTextField textField6 = new JTextField();
        textField6.setBounds(248,260,140,20);
        panel.add(textField6);

        // Update button functionality
        JButton update = new JButton("Update");
        update.setBounds(56, 350, 89, 23);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        panel.add(update);
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    con C = new con();
                    String q = c.getSelectedItem();
                    String avail = textField3.getText();
                    String cleanSt = textField4.getText();
                    String amount = textField5.getText();
                    String room = textField6.getText();
                    C.statement.executeUpdate("UPDATE storeroom SET availability = '" + avail + "', cleaning_status = '" + cleanSt + "', maintaining_cost = '" + amount + "', room_type = '" + room + "' WHERE room_number = '" + q + "'");
                    JOptionPane.showMessageDialog(null, "Updated Successfully");
                    setVisible(false);
                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        });

        // Back button functionality
        JButton back = new JButton("Back");
        back.setBounds(168, 350, 89, 23);
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
        check.setBounds(281, 350, 89, 23);
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        panel.add(check);
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = c.getSelectedItem();
                String query = "SELECT * FROM storeroom WHERE room_number = '" + id + "'";

                try {
                    con C = new con();
                    ResultSet resultSet = C.statement.executeQuery(query);

                    if (resultSet.next()) {
                        textField3.setText(resultSet.getString("availability"));
                        textField4.setText(resultSet.getString("cleaning_status"));
                        textField5.setText(resultSet.getString("maintaining_cost"));
                        textField6.setText(resultSet.getString("room_type"));
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        setLayout(null);
        setSize(950,450);
        setLocation(400,200);
        setVisible(true);
    }
    public static void main(String[] args) {
        new UpdateStoreRoom();
    }
}