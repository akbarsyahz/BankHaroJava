package com.bank_haro.user;

import com.bank_haro.connectiondatabase.Koneksi;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BankAccount implements User{

    Koneksi koneksi = new Koneksi();
    public static int money;
    Connection con;
    Statement stat;
    public ResultSet rs;
    String sqlCek;
    
    @Override
    public ResultSet accountUser(String username){
        try{
            koneksi.getKoneksi();
            con = koneksi.con;
            stat = (Statement) koneksi.ss;
            sqlCek = "SELECT * FROM users WHERE username='"+username+"'";
            Statement statement = con.createStatement(); // buat objek statement
            rs = statement.executeQuery(sqlCek); // eksekusi query dan simpan hasilnya di obj ResultSet
            return rs;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public ResultSet loginLogic(String username, String password) {
        try{
            koneksi.getKoneksi();
            con = koneksi.con;
            stat = (Statement) koneksi.ss;
            sqlCek = "SELECT * FROM users WHERE username='"+username+"' AND password='"+password+"'";
            Statement statement = con.createStatement();
            rs = statement.executeQuery(sqlCek);
            return rs;
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
