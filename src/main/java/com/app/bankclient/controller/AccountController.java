package com.app.bankclient.controller;

import com.app.bankclient.model.Account;
import com.app.bankclient.service.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    public final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }
    @PostMapping
    public Account save(@RequestBody Account account) {
        return accountService.save(account);
    }
    @PostMapping("/deposit")
    public Account topUp(@RequestParam("id") Long id,  @RequestParam("amount") int amount) {
        return accountService.topUp(id, amount);
    }
    @GetMapping("/{id}")
    public Account getUser(@PathVariable("id") Long id) {
        return accountService.getOne(id);
    }
    @GetMapping()
    public List<Account> findAll() {
        return accountService.findAll();
    }
    @PutMapping
    public Account update(@RequestBody Account account) {
        return accountService.update(account);
    }
    @DeleteMapping
    public boolean delete(@RequestBody Account account) {
        return accountService.delete(account);
    }
    @DeleteMapping("/{id}")
    public boolean deleteById(@PathVariable("id") Long id) {
        return accountService.deleteById(id);
    }
}
