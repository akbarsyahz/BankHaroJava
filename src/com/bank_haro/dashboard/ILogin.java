package com.bank_haro.dashboard;

import java.sql.ResultSet;

public interface ILogin {

    ResultSet loginLogic(String username, String password);
}
