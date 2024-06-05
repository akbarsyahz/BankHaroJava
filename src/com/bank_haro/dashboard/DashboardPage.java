package com.bank_haro.dashboard;

import com.bank_haro.transaction.TransactionPage;
import com.bank_haro.bankaccount.BankAccount;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DashboardPage extends BankAccount implements ActionListener {

    JFrame frame = new JFrame();
    JLabel welcomeLabel = new JLabel("Halo!!");
    JLabel moneyLabel = new JLabel("RP");
    JLabel moneyTotalLabel  = new JLabel("0");
    JButton transactionButton = new JButton("Transaction");
    BankAccount accounDetail = new BankAccount();

    public DashboardPage(String userID){

        welcomeLabel.setBounds(100,30,200,35);
        welcomeLabel.setFont(new Font(null, Font.PLAIN, 25));
        welcomeLabel.setText("Hello "+ userID);

        moneyLabel.setBounds(50,100,75,25);
        moneyTotalLabel.setBounds(125,100,200,25);

        transactionButton.setBounds(125,200,150,25);
        transactionButton.setFocusable(false);
        transactionButton.addActionListener(this);

        try{
            ResultSet detailAccount = accounDetail.accountUser(userID);
            detailAccount.next();
            moneyTotalLabel.setText(String.valueOf(detailAccount.getBigDecimal("money")));
        }catch (SQLException e){
            throw new RuntimeException(e);
        }

        frame.add(welcomeLabel);
        frame.add(moneyLabel);
        frame.add(moneyTotalLabel);
        frame.add(transactionButton);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == transactionButton)
        {
            frame.dispose();
            TransactionPage transactionPage = new TransactionPage();
        }
    }
}
