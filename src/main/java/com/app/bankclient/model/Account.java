package com.app.bankclient.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    @Column(name = "number")
    private  String number;
    @Column(name = "currency")
    private  Currency currency;
    @Column(name = "balance")
    private  Double balance;
    @ManyToOne(fetch=FetchType.EAGER)
    @JsonBackReference
    private  Customer customer;

    public  Account(Currency currency, Customer customer) {
        this.currency = currency;
        this.customer = customer;
        this.number = UUID.randomUUID().toString();
    }

    public Account() {

    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", currency=" + currency +
                ", balance=" + balance +
                ", customer=" + customer +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;
        Account account = (Account) o;
        return id.equals(account.id) && number.equals(account.number) && currency == account.currency && balance.equals(account.balance) && customer.equals(account.customer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, number, currency, balance, customer);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
