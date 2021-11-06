package com.app.bankclient.controller;


import com.app.bankclient.model.Customer;
import com.app.bankclient.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    public final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public Customer save(@RequestBody Customer customer) {
        return customerService.save(customer);
    }

    @GetMapping("/{id}")
    public Customer getUser(@PathVariable("id") Long id) {
        return customerService.getOne(id);
    }

    @GetMapping()
    public List<Customer> findAll() {
        return customerService.findAll();
    }

    @PutMapping
    public Customer update(@RequestBody Customer customer) {
        return customerService.update(customer);
    }

    @DeleteMapping
    public boolean delete(@RequestBody Customer customer) {
        return customerService.delete(customer);
    }

    @DeleteMapping("/{id}")
    public boolean deleteById(@PathVariable("id") Long id) {
        return customerService.deleteById(id);
    }
}
