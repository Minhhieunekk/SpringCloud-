package com.example.accountservice.service;

import com.example.accountservice.model.Account;
import com.example.accountservice.model.AccountDTO;

import java.util.List;

public interface AccountService {
    void addAccount(AccountDTO accountDTO);
    void updateAccount(AccountDTO accountDTO);
    void deleteAccount(int id);
    List<AccountDTO> getAllAccounts();
    AccountDTO getAccountById(int id);
    void updatePassword(AccountDTO accountDTO);
}
