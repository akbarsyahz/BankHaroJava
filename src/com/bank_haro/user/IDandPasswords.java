package com.bank_haro.user;

import java.util.HashMap;

public class IDandPasswords {

    HashMap<String,String> logininfo = new HashMap<String,String>();

    public IDandPasswords(){
        logininfo.put("akbarsyahn","123");
    }

    public HashMap getLoginInfo(){
        return logininfo;
    }
}
