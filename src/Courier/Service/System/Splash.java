package Courier.Service.System;

import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame {
    Splash(){
        JLabel label1=new JLabel("Courier Service System");
        label1.setBounds(300,40,300,50);
        label1.setFont(new Font("Tahoma",Font.BOLD,24));
        label1.setForeground(Color.WHITE);
        add(label1);


        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/icon/login3.gif"));
        JLabel label = new JLabel(imageIcon);
        label.setBounds(0,0,858,680);
        add(label);

        getContentPane().setBackground(new Color(3,45,48));

        setLayout(null);
        setLocation(300,80);
        setSize(858,680);
        setVisible(true);

        try {
            Thread.sleep(5000);
            new login();
            setVisible(false);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new Splash();
    }
}