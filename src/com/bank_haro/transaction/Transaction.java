package com.bank_haro.transaction;

import com.bank_haro.bankaccount.BankAccount;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Transaction extends BankAccount implements TransactionInterface{

    String username;
    BigDecimal money;
    BankAccount account = new Transaction();
    BigDecimal minMoney = BigDecimal.valueOf(50.000);

    public Transaction()
    {
        try{
            ResultSet accountMoney = account.accountUser(username);
            accountMoney.next();
            money = accountMoney.getBigDecimal("money");
        }catch (SQLException e){
            throw new RuntimeException(e);
        }

    }

    @Override
    public Integer withDraw() {
//        money =
        return 0;
    }

    @Override
    public Integer deposit() {
        return 0;
    }

    @Override
    public Integer earlierTransaction() {
        return 0;
    }
}
