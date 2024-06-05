package com.bank_haro.dashboard.logic;

import com.bank_haro.connectiondatabase.ConnectionDatabase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginLogic implements ILogin{

    ConnectionDatabase connectionDatabase = new ConnectionDatabase();
    Connection con;
    Statement stat;
    public ResultSet rs;
    String sqlCek;

    @Override
    public ResultSet loginLogic(String username, String password) {
        try{
            connectionDatabase.getKoneksi();
            con = connectionDatabase.con;
            stat = (Statement) connectionDatabase.ss;
            sqlCek = "SELECT * FROM users WHERE username='"+username+"' AND password='"+password+"'";
            Statement statement = con.createStatement();
            rs = statement.executeQuery(sqlCek);
            return rs;
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
