package com.bank_haro.user;

import java.sql.ResultSet;

public interface User {
    ResultSet accountUser(String username);

}
