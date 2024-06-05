package com.bank_haro.connectiondatabase;

import java.sql.Connection;

public interface ConnectionInterface {
    public void connect();
    public void disconnect();
    public void getData();
    public void insertData();
    public void updateData();
    public void deleteData();
}
