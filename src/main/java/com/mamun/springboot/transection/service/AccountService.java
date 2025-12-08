package com.mamun.springboot.transection.service;

import com.mamun.springboot.transection.entity.Account;
import com.mamun.springboot.transection.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;
    public void moneyTransfer(Integer fromAccId, Integer toAccId, Double amount) {

        // credit operatio
        Account creditAccount = accountRepository.findById(toAccId)
                .orElseThrow(() -> new RuntimeException("account found by id = " + toAccId));

        Double currentAmount = creditAccount.getBalance();
        creditAccount.setBalance(currentAmount + amount);
        accountRepository.save(creditAccount);
        accountRepository.flush();
        // debit operation
        int v=1/0;
        Account debitAccount = accountRepository.findById(fromAccId)
                .orElseThrow(() -> new RuntimeException("account found by id = " + fromAccId));

        Double currentAmount2 = debitAccount.getBalance();

        if (currentAmount2 < amount) {
            throw new RuntimeException("Insufficient balance");
        }
        debitAccount.setBalance(currentAmount2 - amount);
        accountRepository.save(debitAccount);
        accountRepository.flush();
    }

}
