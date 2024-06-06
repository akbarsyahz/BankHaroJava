package com.bank_haro.connectiondatabase;

import java.sql.SQLException;
import java.util.List;

public interface CrudInterface{
    public void getData(String table, List<String> nameField, List<?> value) throws SQLException;
    public void insertData(String table, List<String> nameField, List<?> value) throws SQLException;
    public void updateData();
    public void deleteData();
}
