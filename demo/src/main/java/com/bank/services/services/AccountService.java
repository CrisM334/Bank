package com.bank.services.services;

import com.bank.services.model.Account;
import com.bank.services.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService {
    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    // Method to save a new account to the database
    public Account insertAccount(Account account) {
        return accountRepository.save(account);
    }

    // Method to retrieve all accounts from the database
    public List<Account> getAllAccounts() {
        return (List<Account>) accountRepository.findAll();
    }

    // Method to find an account by its ID
    public Optional<Account> findAccountById(Long id) {
        return accountRepository.findById(id);
 }
}

