package com.bank_haro.transaction;

import java.math.BigDecimal;

public interface TransactionInterface {
    BigDecimal withDraw(BigDecimal amount);
    BigDecimal deposit(BigDecimal amount);
    BigDecimal earlierTransaction(BigDecimal amount);
}
