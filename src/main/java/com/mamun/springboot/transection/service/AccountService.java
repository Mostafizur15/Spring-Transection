package com.mamun.springboot.transection.service;

import com.mamun.springboot.transection.entity.Account;
import com.mamun.springboot.transection.entity.TxLog;
import com.mamun.springboot.transection.repository.AccountRepository;
import com.mamun.springboot.transection.repository.TxLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.mamun.springboot.transection.service.TxLogService;

import java.io.IOException;

@Service

public class AccountService {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private TxLogRepository txLogRepository;
    @Autowired
    private TxLogService txLogService;
    @Transactional(rollbackFor = IOException.class)
    public void moneyTransfer(Integer fromAccId, Integer toAccId, Double amount) {

        // credit operatio
        var txLog = new TxLog(null,fromAccId,toAccId,amount,null);

        try{
            Account creditAccount = accountRepository.findById(toAccId)
                    .orElseThrow(() -> new RuntimeException("account found by id = " + toAccId));


        Double currentAmount = creditAccount.getBalance();
        creditAccount.setBalance(currentAmount + amount);
        accountRepository.save(creditAccount);
        accountRepository.flush();
        // debit operation
        fun();
        Account debitAccount = accountRepository.findById(fromAccId)
                .orElseThrow(() -> new RuntimeException("account found by id = " + fromAccId));

        Double currentAmount2 = debitAccount.getBalance();

        if (currentAmount2 < amount) {
            throw new RuntimeException("Insufficient balance");
        }
        debitAccount.setBalance(currentAmount2 - amount);
        accountRepository.save(debitAccount);
        accountRepository.flush();
        txLog.setStatus("SUCCESS");
    }catch(RuntimeException e){
            txLog.setStatus("FAILED");
          //  throw e;          // with out throw it will not roll back
        }
        finally {
            txLogService.saveLog(txLog);
        }
    }

    @Transactional(propagation=Propagation.REQUIRES_NEW)
    void fun(){
        int v=1/0;
    }

}

