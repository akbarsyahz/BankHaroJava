package com.bank_haro.connectiondatabase;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionInterface {
    public void connect();
    public void disconnect() throws SQLException;
}
