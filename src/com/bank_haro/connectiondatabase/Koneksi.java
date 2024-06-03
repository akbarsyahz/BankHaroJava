package com.bank_haro.connectiondatabase;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class Koneksi {
    Connection koneksi;

    public static Connection Koneksi() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection koneksi = DriverManager.getConnection("jdbc:mysql://localhost/BankJava", "123", "123");

            return koneksi;
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
}
