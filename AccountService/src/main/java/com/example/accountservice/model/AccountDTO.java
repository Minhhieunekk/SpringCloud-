package com.example.accountservice.model;


import lombok.Data;

import java.util.Set;

@Data
public class AccountDTO {
    private int id;
    private String name;
    private String password;
    private String username;
    private Set<String> roles;
}
