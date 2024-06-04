package com.bank_haro.user;

import com.bank_haro.connectiondatabase.Koneksi;

import java.sql.Connection;
import java.util.HashMap;

import static com.bank_haro.connectiondatabase.Koneksi.Koneksi;

public class BankAccount implements User{

    String user;
    public static int money;
    Connection cn = Koneksi.Koneksi();

    HashMap<String,String> logininfo = new HashMap<String,String>();

    public BankAccount(){
        logininfo.put("akbarsyahn","123");
    }

    public HashMap getLoginInfo(){
        return logininfo;
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
