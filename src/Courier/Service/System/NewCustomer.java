package Courier.Service.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class NewCustomer extends JFrame implements ActionListener {
    JComboBox<String> idTypeComboBox, originComboBox, destinationComboBox;
    JTextField textFieldNumber, textName, textCountry, textDeposit,textTotal;
    JRadioButton r1, r2;
    JLabel date;
    ButtonGroup genderGroup;
    JButton add, back;

    NewCustomer() {

        // Create a panel
        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 840, 540);
        panel.setLayout(null);
        panel.setBackground(new Color(3, 45, 48));
        add(panel);

        // Add an image
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/icon/img20.png"));
        Image image = imageIcon.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        JLabel imgLabel = new JLabel(new ImageIcon(image));
        imgLabel.setBounds(550, 150, 200, 200);
        panel.add(imgLabel);

        // Title
        JLabel labelName = new JLabel("NEW CUSTOMER FORM");
        labelName.setBounds(118, 11, 260, 53);
        labelName.setFont(new Font("Tahoma", Font.BOLD, 20));
        labelName.setForeground(Color.WHITE);
        panel.add(labelName);

        // ID Type
        JLabel labelID = new JLabel("ID :");
        labelID.setBounds(35, 76, 200, 14);
        labelID.setForeground(Color.WHITE);
        labelID.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(labelID);

        idTypeComboBox = new JComboBox<>(new String[]{"Passport", "Nid No", "Student Id", "Driving License"});
        idTypeComboBox.setBounds(271, 73, 150, 25);
        idTypeComboBox.setBackground(new Color(3, 45, 48));
        idTypeComboBox.setForeground(Color.WHITE);
        idTypeComboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(idTypeComboBox);

        // ID Number
        JLabel labelNumber = new JLabel("Number :");
        labelNumber.setBounds(35, 111, 200, 14);
        labelNumber.setForeground(Color.WHITE);
        labelNumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(labelNumber);
        textFieldNumber = new JTextField();
        textFieldNumber.setBounds(271, 111, 150, 25);
        panel.add(textFieldNumber);

        // Name
        JLabel labelNameField = new JLabel("Name :");
        labelNameField.setBounds(35, 151, 200, 14);
        labelNameField.setForeground(Color.WHITE);
        labelNameField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(labelNameField);
        textName = new JTextField();
        textName.setBounds(271, 151, 150, 25);
        panel.add(textName);

        // Gender
        JLabel labelGender = new JLabel("Gender :");
        labelGender.setBounds(35, 191, 200, 14);
        labelGender.setForeground(Color.WHITE);
        labelGender.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(labelGender);

        r1 = new JRadioButton("Male");
        r1.setFont(new Font("Tahoma", Font.BOLD, 14));
        r1.setForeground(Color.WHITE);
        r1.setBackground(new Color(3, 45, 48));
        r1.setBounds(271, 191, 80, 20);
        panel.add(r1);

        r2 = new JRadioButton("Female");
        r2.setFont(new Font("Tahoma", Font.BOLD, 14));
        r2.setForeground(Color.WHITE);
        r2.setBackground(new Color(3, 45, 48));
        r2.setBounds(350, 191, 80, 20);
        panel.add(r2);

        // Group gender buttons
        genderGroup = new ButtonGroup();
        genderGroup.add(r1);
        genderGroup.add(r2);

        // Country
        JLabel labelCountry = new JLabel("Country :");
        labelCountry.setBounds(35, 231, 200, 20);
        labelCountry.setForeground(Color.WHITE);
        labelCountry.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(labelCountry);
        textCountry = new JTextField();
        textCountry.setBounds(271, 231, 150, 25);
        panel.add(textCountry);

        // Origin
        JLabel labelOrigin = new JLabel("Origin :");
        labelOrigin.setBounds(35, 271, 200, 20);
        labelOrigin.setForeground(Color.WHITE);
        labelOrigin.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(labelOrigin);

        originComboBox = new JComboBox<>(new String[]{"Dhaka", "Khulna", "Barisal", "Rajshahi", "Rangpur", "Chattogram", "Mymensingh", "Sylhet"});
        originComboBox.setBounds(271, 271, 150, 25);
        originComboBox.setBackground(new Color(3, 45, 48));
        originComboBox.setForeground(Color.WHITE);
        originComboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(originComboBox);

        // Destination
        JLabel labelDestination = new JLabel("Destination :");
        labelDestination.setBounds(35, 311, 200, 20);
        labelDestination.setForeground(Color.WHITE);
        labelDestination.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(labelDestination);

        destinationComboBox = new JComboBox<>(new String[]{"Dhaka", "Khulna", "Barisal", "Rajshahi", "Rangpur", "Chattogram", "Mymensingh", "Sylhet"});
        destinationComboBox.setBounds(271, 311, 150, 25);
        destinationComboBox.setBackground(new Color(3, 45, 48));
        destinationComboBox.setForeground(Color.WHITE);
        destinationComboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(destinationComboBox);

        // Checked-In Date
        JLabel labelCheckedIn = new JLabel("Checked-In :");
        labelCheckedIn.setBounds(35, 351, 200, 14);
        labelCheckedIn.setForeground(Color.WHITE);
        labelCheckedIn.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(labelCheckedIn);

        Date date1 = new Date();
        date = new JLabel("" + date1);
        date.setBounds(271, 351, 200, 14);
        date.setForeground(Color.WHITE);
        date.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(date);

        // Deposit
        JLabel labelDeposit = new JLabel("Deposit :");
        labelDeposit.setBounds(35, 391, 200, 20);
        labelDeposit.setForeground(Color.WHITE);
        labelDeposit.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(labelDeposit);
        textDeposit = new JTextField();
        textDeposit.setBounds(271, 391, 150, 25);
        panel.add(textDeposit);

        // Total
        JLabel labelTotal = new JLabel("Total :");
        labelTotal.setBounds(35, 431, 200, 20);
        labelTotal.setForeground(Color.WHITE);
        labelTotal.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(labelTotal);
        textTotal = new JTextField();
        textTotal.setBounds(271, 431, 150, 25);
        panel.add(textTotal);

        // Buttons
        add = new JButton("ADD");
        add.setBounds(100, 465, 120, 30);
        add.setForeground(Color.WHITE);
        add.setBackground(Color.BLACK);
        add.addActionListener(this);
        panel.add(add);

        back = new JButton("BACK");
        back.setBounds(260, 465, 120, 30);
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.addActionListener(this);
        panel.add(back);

        // Frame settings
        setLayout(null);
        setLocation(500, 150);
        setSize(850, 550);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == add) {
            con c = new con();
            String radioBTn=null;
            if(r1.isSelected()){
                radioBTn="Male";
            }else if(r2.isSelected()){
                radioBTn="Female";
            }
            String idType = (String) idTypeComboBox.getSelectedItem();
            String number = textFieldNumber.getText();
            String name = textName.getText();
            String gender = radioBTn;
            String country = textCountry.getText();
            String origin = (String) originComboBox.getSelectedItem();
            String destination = (String) destinationComboBox.getSelectedItem();
            String checkedIn = date.getText();
            String deposit = textDeposit.getText();
            String total=textTotal.getText();

            // Add database connection logic here
            try {
                String q="insert into customer values ('"+idType+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+origin+"','"+destination+"','"+checkedIn+"','"+deposit+"','"+total+"')";
                c.statement.executeUpdate(q);
                // Simulate a successful database insert
                JOptionPane.showMessageDialog(null, "Customer added successfully!");
                setVisible(false);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (e.getSource() == back) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new NewCustomer();
    }
}
