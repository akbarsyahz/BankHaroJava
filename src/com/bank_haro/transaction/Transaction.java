package com.bank_haro.transaction;

import com.bank_haro.bankaccount.BankAccount;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.Locale;

public class Transaction extends BankAccount implements TransactionInterface{

    String username;
    BigDecimal money;
    BankAccount account = new Transaction();
    BigDecimal minMoney = new BigDecimal("100000.50");

    public Transaction()
    {
        this.username = username;
        try {
            ResultSet accountMoney = account.accountUser(username);
            if (accountMoney.next()) {
                money = accountMoney.getBigDecimal("money");
            } else {
                money = BigDecimal.ZERO;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static String formatRupiah(BigDecimal amount) {
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));
        return currencyFormat.format(amount);
    }

    @Override
    public BigDecimal withDraw(BigDecimal amount) {
        if (money.compareTo(minMoney) >= 0 && money.compareTo(amount) >= 0) {
            money = money.subtract(amount);
            return amount;
        } else {
            System.out.println("Saldo tidak mencukupi untuk melakukan penarikan atau saldo kurang dari minimum yang diizinkan.");
            return BigDecimal.ZERO;
        }
    }

    @Override
    public BigDecimal deposit(BigDecimal amount) {
       if (money.compareTo(minMoney) >= 0 && money.compareTo(amount) >= 0){
           money = money.add(amount);
           return amount;
       }else{
           System.out.println("Saldo tidak mencukupi untuk melakukan penarikan atau saldo kurang dari minimum yang diizinkan.");
           return BigDecimal.ZERO;
       }
    }

    @Override
    public BigDecimal earlierTransaction(BigDecimal amount) {
        return amount;
    }
}
