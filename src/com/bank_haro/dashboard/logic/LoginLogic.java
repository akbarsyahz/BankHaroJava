package com.bank_haro.dashboard.logic;

import com.bank_haro.connectiondatabase.KoneksiDatabase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginLogic implements ILogin{

    KoneksiDatabase koneksiDatabase = new KoneksiDatabase();
    Connection con;
    Statement stat;
    public ResultSet rs;
    String sqlCek;

    @Override
    public ResultSet loginLogic(String username, String password) {
        try{
            koneksiDatabase.getKoneksi();
            con = koneksiDatabase.con;
            stat = (Statement) koneksiDatabase.ss;
            sqlCek = "SELECT * FROM users WHERE username='"+username+"' AND password='"+password+"'";
            Statement statement = con.createStatement();
            rs = statement.executeQuery(sqlCek);
            return rs;
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
