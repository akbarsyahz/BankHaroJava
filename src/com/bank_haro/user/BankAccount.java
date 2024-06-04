package com.bank_haro.user;

import com.bank_haro.connectiondatabase.Koneksi;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class BankAccount implements User{

    Koneksi koneksi = new Koneksi();
    public static int money;
    Connection con;
    Statement stat;
    public ResultSet rs;



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
    public void accountUser(String userID) {
        try{
            koneksi.getKoneksi();
            con = koneksi.con;
            stat = (Statement) koneksi.ss;
            String sql = "SELECT * FROM users WHERE " + userID;
            Statement statement = con.createStatement();
            rs = statement.executeQuery(sql);
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
