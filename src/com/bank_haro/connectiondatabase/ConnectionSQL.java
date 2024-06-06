package com.bank_haro.connectiondatabase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionSQL implements ConnectionInterface{
    ConnectionDatabase connectionDatabase = new ConnectionDatabase();
    Connection con;
    Statement stat;
    public ResultSet rs;

    @Override
    public void connect() {
        connectionDatabase.getKoneksi();
        con = connectionDatabase.con;
        stat = (Statement) connectionDatabase.ss;
    }

    @Override
    public void disconnect() throws SQLException {
        if (stat != null) {
            stat.close();
        }
        if (con != null) {
            con.close();
        }
    }
}
