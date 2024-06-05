package com.bank_haro.dashboard.logic;

import java.sql.ResultSet;

public interface ILogin {

    ResultSet loginLogic(String username, String password);
}
