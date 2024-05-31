package com.bank.services.controller;

import com.bank.services.model.Account;
import com.bank.services.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    // Endpoint to add a new account
    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
        Account savedAccount = accountService.insertAccount(account);
        return ResponseEntity.ok(savedAccount);
    }

    // Endpoint to retrieve all accounts
    @GetMapping
    public ResponseEntity<List<Account>> getAllAccounts() {
        List<Account> accounts = accountService.getAllAccounts();
        return ResponseEntity.ok(accounts);
    }

    // Endpoint to get account details by ID
    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable("id") Long id) {
        return accountService.findAccountById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}

