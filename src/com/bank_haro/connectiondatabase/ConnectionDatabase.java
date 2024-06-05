package com.bank_haro.connectiondatabase;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionDatabase {
    public Connection con;
    public Statement ss;

    String driverName = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/bankjava";
    String username = "";
    String password = "";

    public void getKoneksi() {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            System.out.println("Koneksi Sukses ");
            ss = (Statement) con.createStatement();
        } catch (SQLException ex) {
            System.out.println("Koneksi Gagal");
        }
    }
}
