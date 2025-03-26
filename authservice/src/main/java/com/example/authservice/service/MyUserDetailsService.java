package com.example.authservice.service;

import com.example.authservice.model.Account;
import com.example.authservice.model.AccountPrincipal;
import com.example.authservice.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.findByUsername(username);
        if (account == null) {
            System.out.println("User not found");
            throw new UsernameNotFoundException("User not found");
        }
        return new AccountPrincipal(account);
    }
}
