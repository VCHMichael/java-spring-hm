package com.app.bankclient.repository;

import com.app.bankclient.model.Account;
import com.app.bankclient.model.Customer;

import java.util.List;

public interface AccountRepository {
    Account save(Account obj);

    Account update(Account obj);

    boolean delete(Account obj);

    void deleteAll(List<Account> entities);

    void saveAll(List<Account> entities);

    List<Account> findAll();

    boolean deleteById(long id);

    Account topUp(long id, double amount);

    boolean withdrawal(long id, int amount);

    boolean transfer(long firstId, long secondId,  int amount);

    Account getOne(long id);

}
