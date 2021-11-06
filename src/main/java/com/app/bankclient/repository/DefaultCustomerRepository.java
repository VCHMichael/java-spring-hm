package com.app.bankclient.repository;

import com.app.bankclient.model.Customer;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import java.util.List;

@Repository
@Profile("prod")
public class DefaultCustomerRepository implements CustomerRepository {
    private final EntityManager entityManager;

    public DefaultCustomerRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public Customer save(Customer customer) {
        entityManager.persist(customer);
        return customer;
    }

    @Transactional
    @Override
    public Customer update(Customer obj) {
       return entityManager.merge(obj);
    }

    @Override
    @Transactional
    public boolean delete(Customer obj) {
        Customer customer = entityManager.find(Customer.class, obj.getId());
        entityManager.remove(customer);
        return !entityManager.contains(obj);
    }

    @Override
    public void deleteAll(List<Customer> entities) {

    }

    @Override
    public void saveAll(List<Customer> entities) {

    }

    @Override
    public List<Customer> findAll() {
        return entityManager.createQuery("Select a from Customer a", Customer.class)
                .getResultList();
    }

    @Override
    public boolean deleteById(long id) {
        Customer customer = entityManager.getReference(Customer.class, id);
        entityManager.remove(customer);
        return !entityManager.contains(customer);
    }

    @Override
    public Customer getOne(long id) {
        return entityManager.find(Customer.class, id);
    }

}
