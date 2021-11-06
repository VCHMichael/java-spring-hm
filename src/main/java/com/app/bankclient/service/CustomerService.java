package com.app.bankclient.service;

import com.app.bankclient.model.Customer;
import com.app.bankclient.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer getOne(Long id) {
        return customerRepository.getOne(id);
    }

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public Customer update(Customer customer) {
        return customerRepository.update(customer);
    }

    public boolean delete(Customer customer) {
        return customerRepository.delete(customer);
    }

    public boolean deleteById(Long id) {
        return customerRepository.deleteById(id);
    }

    public void deleteAll(List<Customer> customers) {
        customerRepository.deleteAll(customers);
    }

    public void saveAll(List<Customer> customers) {
        customerRepository.saveAll(customers);
    }
}
