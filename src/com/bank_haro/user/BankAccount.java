package com.bank_haro.user;

import com.bank_haro.connectiondatabase.Koneksi;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class BankAccount implements User{

    public static int money;
    Connection con;
    Statement stat;


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
            Koneksi koneksi = new Koneksi();
            koneksi.getKoneksi();
            con = koneksi.con;
            stat = (Statement) koneksi.ss;
            String sql = "SELECT * FROM users WHERE " + userID;
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            Object[] data = {
                    rs.getString("username"),
                    rs.getString("money"),
            };
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
