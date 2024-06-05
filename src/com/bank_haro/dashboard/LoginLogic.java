package com.bank_haro.dashboard;

import com.bank_haro.connectiondatabase.Koneksi;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginLogic implements ILogin{

    Koneksi koneksi = new Koneksi();
    Connection con;
    Statement stat;
    public ResultSet rs;
    String sqlCek;

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
