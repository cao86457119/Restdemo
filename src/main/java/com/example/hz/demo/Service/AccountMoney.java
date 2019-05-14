package com.example.hz.demo.Service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.sql.SQLException;

/**
 * @author kiva
 */
@Service

public class AccountMoney {
    @Transactional
    public String getName(){
        String happy = "happy";
        try {
            throw new SQLException("发生异常了..");
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return happy;
    }
}
