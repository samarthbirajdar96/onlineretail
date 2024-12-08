package com.example.CustomerSrvice.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customerName;
    private String customerEmail;

    @OneToOne
    private CustomerAddress customerBillingAddress;

    @OneToOne
    private CustomerAddress customerShippingAddress;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public CustomerAddress getCustomerBillingAddress() {
        return customerBillingAddress;
    }

    public void setCustomerBillingAddress(CustomerAddress customerBillingAddress) {
        this.customerBillingAddress = customerBillingAddress;
    }

    public CustomerAddress getCustomerShippingAddress() {
        return customerShippingAddress;
    }

    public void setCustomerShippingAddress(CustomerAddress customerShippingAddress) {
        this.customerShippingAddress = customerShippingAddress;
    }
}
