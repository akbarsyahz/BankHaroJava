package com.bank_haro.dashboard;

import com.bank_haro.connectiondatabase.Koneksi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomePage implements ActionListener {


    Koneksi con = new Koneksi();
    JFrame frame = new JFrame();
    JLabel welcomeLabel = new JLabel("Halo!!");
    JLabel moneyLabel = new JLabel("RP");
    JLabel moneyTotalLabel  = new JLabel("Total");

    public WelcomePage(String userID){
        welcomeLabel.setBounds(100,30,200,35);
        welcomeLabel.setFont(new Font(null, Font.PLAIN, 25));
        welcomeLabel.setText("Hello "+ userID);

        moneyLabel.setBounds(50,100,75,25);
        moneyTotalLabel.setBounds(125,100,200,25);
        moneyTotalLabel.setText("1.000.000.000");


        frame.add(welcomeLabel);
        frame.add(moneyLabel);
        frame.add(moneyTotalLabel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
