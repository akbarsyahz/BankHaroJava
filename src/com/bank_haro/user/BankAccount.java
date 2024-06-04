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


    public BankAccount(){

    }


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

    }


    @Override
    public void accountUser() {

    }

    @Override
    public void moneyUser() {

    }
}
