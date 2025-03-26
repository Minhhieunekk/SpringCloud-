package com.example.accountservice.controller;

import com.example.accountservice.client.NotificationService;
import com.example.accountservice.client.StatisticService;
import com.example.accountservice.model.AccountDTO;
import com.example.accountservice.model.MessageDTO;
import com.example.accountservice.model.StatisticDTO;
import com.example.accountservice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class AccountController  {

    @Autowired
    private AccountService accountService;

    @Autowired
    private StatisticService statisticService;

    @Autowired
    private NotificationService notificationService;

    @PostMapping("/account")
    public AccountDTO addAccount(@RequestBody AccountDTO accountDTO) {
        accountService.addAccount(accountDTO);
        statisticService.addStatistic(new StatisticDTO("Account created",new Date()));

        MessageDTO messageDTO = new MessageDTO();
        messageDTO.setSubject("Account created");
        messageDTO.setFrom("iwillwin2211@gmail.com");
        messageDTO.setTo("hieutmhe180168@fpt.edu.vn");
        messageDTO.setToName(accountDTO.getUsername());
        messageDTO.setContent("Your account has been created successfully");
        notificationService.sendNotification(messageDTO);
        return accountDTO;
    }


    @GetMapping("/accounts")
    public List<AccountDTO> getAll() {
        statisticService.addStatistic(new StatisticDTO("Get all account",new Date()));
        return accountService.getAllAccounts();
    }

    @GetMapping("/account/{id}")
    public ResponseEntity<AccountDTO> get(@PathVariable Integer id) {
        return Optional.of(new ResponseEntity<>(accountService.getAccountById(id), HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @DeleteMapping("/account/{id}")
    public void delete(@PathVariable Integer id) {
        accountService.deleteAccount(id);
    }

    @PutMapping("/account")
    public void update(@RequestBody AccountDTO accountDTO) {
        accountService.updateAccount(accountDTO);
    }

}
