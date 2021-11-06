package com.app.bankclient.service;

import com.app.bankclient.model.Account;
import com.app.bankclient.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    public Account save(Account account) {
        return accountRepository.save(account);
    }

    public Account getOne(Long id) {
        return accountRepository.getOne(id);
    }

    public Account update(Account account) {
        return accountRepository.update(account);
    }

    public boolean delete(Account account) {
        return accountRepository.delete(account);
    }

    public boolean deleteById(Long id) {
        return accountRepository.deleteById(id);
    }

    public Account topUp(long id, int amount) {
        return accountRepository.topUp(id, amount);
    }
}
