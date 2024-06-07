package com.bank_haro.transaction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TransactionPage implements ActionListener {

    JFrame frame = new JFrame();
    JLabel titleLabel = new JLabel("PILIH MENU");
    JButton withdrawButton = new JButton("WITHDRAW");
    JButton depositButton = new JButton("DEPOSIT");
    JButton earlierTransactionButton = new JButton("Earlier Transaction");

    public TransactionPage(){
        titleLabel.setBounds(155, 30, 200, 25);
        titleLabel.setFont(new Font(null,Font.BOLD,25));

        withdrawButton.setBounds(125,200,100,25);
        withdrawButton.setFocusable(false);
        withdrawButton.addActionListener(this);

        depositButton.setBounds(177,250,100,25);
        depositButton.setFocusable(false);
        depositButton.addActionListener(this);

        earlierTransactionButton.setBounds(177,250,100,25);
        earlierTransactionButton.setFocusable(false);
        earlierTransactionButton.addActionListener(this);

        frame.add(titleLabel);
        frame.add(withdrawButton);
        frame.add(depositButton);
        frame.add(earlierTransactionButton);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
