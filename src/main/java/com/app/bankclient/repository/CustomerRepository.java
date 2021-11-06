package com.app.bankclient.repository;

import com.app.bankclient.model.Customer;

import java.util.List;

public interface CustomerRepository {
    Customer save(Customer obj);

    Customer update(Customer obj);

    boolean delete(Customer obj);

    void deleteAll(List<Customer> entities);

    void saveAll(List<Customer> entities);

    List<Customer> findAll();

    boolean deleteById(long id);

    Customer getOne(long id);

}
