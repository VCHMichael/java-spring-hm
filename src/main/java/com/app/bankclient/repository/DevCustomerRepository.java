package com.app.bankclient.repository;

import com.app.bankclient.model.Customer;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Profile("dev")
public class DevCustomerRepository implements CustomerRepository{
    @Override
    public Customer save(Customer obj) {
        return null;
    }

    @Override
    public Customer update(Customer obj) {
        return null;
    }

    @Override
    public boolean delete(Customer obj) {
        return false;
    }

    @Override
    public void deleteAll(List<Customer> entities) {

    }

    @Override
    public void saveAll(List<Customer> entities) {

    }

    @Override
    public List<Customer> findAll() {
        return null;
    }

    @Override
    public boolean deleteById(long id) {
        return false;
    }

    @Override
    public Customer getOne(long id) {
        return null;
    }
}
