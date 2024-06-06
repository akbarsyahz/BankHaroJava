package com.bank_haro.dashboard;

import com.bank_haro.dashboard.logic.IRegister;
import com.bank_haro.dashboard.logic.LoginLogic;
import com.bank_haro.dashboard.logic.RegisterLogic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegisterPage implements ActionListener {

    JFrame frame = new JFrame();
    JLabel titleLabel = new JLabel("Register");
    JButton regisButton = new JButton("Create Account");
    JButton resetButton = new JButton("Reset");
    JTextField userIDField = new JTextField();
    JTextField userAddressField = new JTextField();
    JTextField userNikField = new JTextField();
    JPasswordField userPasswordField = new JPasswordField();
    JLabel userIDLabel = new JLabel("username:");
    JLabel userPasswordLabel = new JLabel("password:");
    JLabel userAddressLabel = new JLabel("Address:");
    JLabel userNikLabel = new JLabel("NIK:");
    JLabel messageLabel = new JLabel();

    RegisterPage(){
        titleLabel.setBounds(155, 30, 200, 35);
        titleLabel.setFont(new Font(null,Font.BOLD,25));

        userIDLabel.setBounds(50,100,75,25);
        userPasswordLabel.setBounds(50,150,75,25);
        userAddressLabel.setBounds(50,200,75,25);
        userNikLabel.setBounds(50,250,75,25);

        messageLabel.setBounds(125,250,250,35);
        messageLabel.setFont(new Font(null,Font.ITALIC,25));

        userIDField.setBounds(125,100,200,25);
        userPasswordField.setBounds(125,150,200,25);

        userAddressField.setBounds(125,200,200,25);
        userNikField.setBounds(125,250,200,25);

        regisButton.setBounds(140,300,150,25);
        regisButton.setFocusable(false);
        regisButton.addActionListener(this);

        resetButton.setBounds(160,350,100,25);
        resetButton.setFocusable(false);
        resetButton.addActionListener(this);

        frame.add(titleLabel);
        frame.add(userIDLabel);
        frame.add(userPasswordLabel);
        frame.add(userAddressLabel);
        frame.add(userNikLabel);
        frame.add(messageLabel);
        frame.add(userIDField);
        frame.add(userPasswordField);
        frame.add(userAddressField);
        frame.add(userNikField);
        frame.add(regisButton);
        frame.add(resetButton);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==resetButton) {
            userIDField.setText("");
            userPasswordField.setText("");
            userAddressField.setText("");
            userNikField.setText("");
        }

        if(e.getSource()==regisButton) {
            RegisterLogic register = new RegisterLogic();
            String userID = userIDField.getText();
            String password = String.valueOf(userPasswordField.getPassword());
            String userAddress = userAddressField.getText();

            Long userNik;
            try {
                userNik = Long.parseLong(userNikField.getText());
            } catch (NumberFormatException ex) {
                throw new IllegalArgumentException("NIK harus berupa angka.");
            }

            // Validasi panjang NIK
            if (String.valueOf(userNik).length() != 16) {
                throw new IllegalArgumentException("NIK harus terdiri dari 16 angka.");
            }

            boolean isRegistered = register.register(userID, password, userAddress, userNik);
            if (isRegistered) {
                messageLabel.setForeground(Color.green);
                messageLabel.setText("Registration successful");
                frame.dispose();
                DashboardPage dashboardPage = new DashboardPage(userID);
            } else {
                messageLabel.setForeground(Color.red);
                messageLabel.setText("Registration failed");
            }
        }
    }


}
