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



    public static int withDraw()
    {
        if(money <= 10.000)
        {
            money -= 10; // total yang ingin di tarik;
        }
        return money;
    }

    public static void storeMoney()
    {

    }

    public static void depositMoney()
    {
        System.out.println("Hallo");
    }


    @Override
    public ResultSet accountUser(String username) {
        return null;
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
