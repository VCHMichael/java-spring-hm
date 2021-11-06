package com.app.bankclient.repository;

import com.app.bankclient.model.Account;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

@Repository
@Profile("prod")
public class DefaultAccountRepository implements AccountRepository{
    private final EntityManager entityManager;

    public DefaultAccountRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public Account save(Account account) {
        entityManager.persist(account);
        return account;
    }

    @Override
    public Account update(Account obj) {
        return entityManager.merge(obj);
    }

    @Override
    @Transactional
    public boolean delete(Account obj) {
        Account account = entityManager.find(Account.class, obj.getId());
        entityManager.remove(account);
        return !entityManager.contains(obj);
    }

    @Override
    public void deleteAll(List<Account> entities) {

    }

    @Override
    public void saveAll(List<Account> entities) {

    }

    @Override
    public List<Account> findAll() {
        return entityManager.createQuery("Select a from Account a", Account.class)
                .getResultList();
    }

    @Override
    public boolean deleteById(long id) {
        Account account = entityManager.getReference(Account.class, id);
        entityManager.remove(account);
        return !entityManager.contains(account);
    }

    @Transactional
    @Override
    public Account topUp(long id, double amount) {
        Account account = entityManager.getReference(Account.class, id);
        account.setBalance(amount);
        entityManager.merge(account);
        return account;
    }

    @Override
    public boolean withdrawal(long id, int amount) {
        return false;
    }

    @Override
    public boolean transfer(long firstId, long secondId, int amount) {
        return false;
    }

    @Override
    public Account getOne(long id) {
        return null;
    }
}
