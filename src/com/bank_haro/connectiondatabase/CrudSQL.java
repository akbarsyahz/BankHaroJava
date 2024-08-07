package com.bank_haro.connectiondatabase;

import java.sql.*;
import java.util.Collections;
import java.util.List;

public class CrudSQL extends ConnectionSQL implements CrudInterface{

    ConnectionSQL connectionSQL = new ConnectionSQL();
    String sql;

    @Override
    public void getAllData(String table, List<String> nameField, List<?> value) throws SQLException {

    }

    @Override
    public void insertData(String table, List<String> nameField, List<?> value) throws SQLException {
        try {
            connectionSQL.connect();
            String fields = String.join(", ", nameField);
            String placeholders = String.join(", ", Collections.nCopies(value.size(), "?"));

            String sql = "INSERT INTO " + table + " (" + fields + ") VALUES (" + placeholders + ")";

            try (PreparedStatement statement = connectionSQL.con.prepareStatement(sql)) {
                for (int i = 0; i < value.size(); i++) {
                    statement.setObject(i + 1, value.get(i));
                }
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            connectionSQL.disconnect();
        }
    }

    @Override
    public void updateData() {

    }

    @Override
    public void deleteData() {

    }
}
