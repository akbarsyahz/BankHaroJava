package com.bank_haro.dashboard;

import com.bank_haro.dashboard.logic.LoginLogic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginPage implements ActionListener {

    JFrame frame = new JFrame();
    JLabel titleLabel = new JLabel("BANK HARO");
    JButton loginButton = new JButton("Login");
    JButton resetButton = new JButton("Reset");
    JTextField userIDField = new JTextField();
    JPasswordField userPasswordField = new JPasswordField();
    JLabel userIDLabel = new JLabel("userID:");
    JLabel userPasswordLabel = new JLabel("password:");
    JLabel messageLabel = new JLabel();

    public LoginPage(){

        titleLabel.setBounds(155, 30, 200, 25);
        titleLabel.setFont(new Font(null,Font.BOLD,25));

        userIDLabel.setBounds(50,100,75,25);
        userPasswordLabel.setBounds(50,150,75,25);

        messageLabel.setBounds(125,250,250,35);
        messageLabel.setFont(new Font(null,Font.ITALIC,25));

        userIDField.setBounds(125,100,200,25);
        userPasswordField.setBounds(125,150,200,25);

        loginButton.setBounds(125,200,100,25);
        loginButton.setFocusable(false);
        loginButton.addActionListener(this);

        resetButton.setBounds(225,200,100,25);
        resetButton.setFocusable(false);
        resetButton.addActionListener(this);

        frame.add(titleLabel);
        frame.add(userIDLabel);
        frame.add(userPasswordLabel);
        frame.add(messageLabel);
        frame.add(userIDField);
        frame.add(userPasswordField);
        frame.add(loginButton);
        frame.add(resetButton);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==resetButton) {
            userIDField.setText("");
            userPasswordField.setText("");
        }

        if(e.getSource()==loginButton) {
              LoginLogic userLogin = new LoginLogic();
            try {
                String userID = userIDField.getText();
                String password = String.valueOf(userPasswordField.getPassword());
                ResultSet cekLogin = userLogin.loginLogic(userID, password);
                if (cekLogin.next()) {
                    messageLabel.setForeground(Color.green);
                    messageLabel.setText("Login successful");
                    frame.dispose();
                    DashboardPage dashboardPage = new DashboardPage(userID);
                } else {
                    messageLabel.setForeground(Color.red);
                    messageLabel.setText("username or password wrong");
                }
            }catch (SQLException ex){
                System.out.println("Koneksi Gagal " + ex);
            }
        }
    }
}
