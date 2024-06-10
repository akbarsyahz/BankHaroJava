package com.bank_haro.transaction.subtransaction;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DepositPage implements ActionListener {
    JFrame frame = new JFrame();
    JLabel titleLabel = new JLabel("MENU");
    JButton withdrawButton = new JButton("WITHDRAW");
    JButton depositButton = new JButton("DEPOSIT");
    JButton earlierTransactionButton = new JButton("Earlier Transaction");

    public DepositPage() {

    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
