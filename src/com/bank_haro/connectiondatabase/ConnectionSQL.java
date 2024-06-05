package com.bank_haro.connectiondatabase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectionSQL implements ConnectionInterface{
    Connection con;
    Statement stat;
    public ResultSet rs;
    String sqlCek;


    @Override
    public void connect() {

    }

    @Override
    public void disconnect() {

    }

    @Override
    public void getData() {

    }

    @Override
    public void insertData() {

    }

    @Override
    public void updateData() {

    }

    @Override
    public void deleteData() {

    }
}
