package com.bank_haro.bankaccount;

import com.bank_haro.connectiondatabase.ConnectionDatabase;
import com.bank_haro.user.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BankAccount implements User {

    ConnectionDatabase connectionDatabase = new ConnectionDatabase();
    public static int money;
    Connection con;
    Statement stat;
    public ResultSet rs;
    String sqlCek;
    
    @Override
    public ResultSet accountUser(String username){
        try{
            connectionDatabase.getKoneksi();
            con = connectionDatabase.con;
            stat = (Statement) connectionDatabase.ss;
            sqlCek = "SELECT * FROM users WHERE username='"+username+"'";
            Statement statement = con.createStatement(); // buat objek statement
            rs = statement.executeQuery(sqlCek); // eksekusi query dan simpan hasilnya di obj ResultSet
            return rs;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }


}
