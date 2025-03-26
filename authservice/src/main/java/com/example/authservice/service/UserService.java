package com.example.authservice.service;

import com.example.authservice.model.Account;
import com.example.authservice.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private AccountRepository accountRepository;

    public Account save(Account account) {
        account.setPassword(new BCryptPasswordEncoder(10).encode(account.getPassword()));
        return accountRepository.save(account);
    }

}
