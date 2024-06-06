package com.bank_haro.dashboard.logic;

import com.bank_haro.connectiondatabase.CrudSQL;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class RegisterLogic implements IRegister{
    CrudSQL connection = new CrudSQL();

    @Override
    public void register(String username, String password, String address, Integer nik) {
        if (username == null || username.isEmpty()) {
            throw new IllegalArgumentException("Username tidak boleh kosong.");
        }
        if (password == null || password.length() < 8) {
            throw new IllegalArgumentException("Password harus memiliki panjang minimal 8 karakter.");
        }
        if (address == null || address.isEmpty()) {
            throw new IllegalArgumentException("Alamat tidak boleh kosong.");
        }
        if (nik == null || nik.toString().length() != 16) {
            throw new IllegalArgumentException("NIK harus terdiri dari 16 angka.");
        }


        List<String> fields = Arrays.asList("username", "password", "address", "nik");
        List<Object> values = Arrays.asList(username, password, address, nik);


        try {
            connection.insertData("users", fields, values);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to register user", e);
        }
    }
}
