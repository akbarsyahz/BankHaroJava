package com.bank_haro.connectiondatabase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectionSQL implements ConnectionInterface{
    Connection con;
    Statement stat;
    public ResultSet rs;
    String sqlCek;

    ConnectionSQL(){

    }


    @Override
    public void connect() {

    }

    @Override
    public void disconnect() {

    }
}
