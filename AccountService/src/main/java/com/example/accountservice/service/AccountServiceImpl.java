package com.example.accountservice.service;

import com.example.accountservice.model.Account;
import com.example.accountservice.model.AccountDTO;
import com.example.accountservice.repository.AccountRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public void addAccount(AccountDTO accountDTO) {
        Account account = modelMapper.map(accountDTO, Account.class);
        account.setPassword(new BCryptPasswordEncoder(10).encode(accountDTO.getPassword()));
        accountRepository.save(account);
        accountDTO.setId(account.getId());
    }

    @Override
    public void updateAccount(AccountDTO accountDTO) {
        Account account = accountRepository.findById(accountDTO.getId()).orElse(null);
        if (account != null) {
            modelMapper.typeMap(AccountDTO.class, Account.class)
                    .addMappings(mapper -> mapper.skip(Account::setPassword))
                    .map(accountDTO, account);
            accountRepository.save(account);
        }
    }

    @Override
    public void deleteAccount(int id) {
        Account account=accountRepository.findById(id).orElse(null);
        if (account !=null)
            accountRepository.delete(account);
    }

    @Override
    public List<AccountDTO> getAllAccounts() {
        List<AccountDTO> accountDTOS=new ArrayList<>();

        accountRepository.findAll().forEach(account -> {
            AccountDTO accountDTO=modelMapper.map(account, AccountDTO.class);
            accountDTOS.add(accountDTO);
        });
        return accountDTOS;
    }

    @Override
    public AccountDTO getAccountById(int id) {
        Account account=accountRepository.findById(id).orElse(null);
        if (account !=null)
            return modelMapper.map(account, AccountDTO.class);
        return null;
    }

    @Override
    public void updatePassword(AccountDTO accountDTO) {
        Account account=accountRepository.findById(accountDTO.getId()).orElse(null);
        if (account !=null){
            account.setPassword(new BCryptPasswordEncoder(10).encode(accountDTO.getPassword()));
            accountRepository.save(account);
        }
    }
}
