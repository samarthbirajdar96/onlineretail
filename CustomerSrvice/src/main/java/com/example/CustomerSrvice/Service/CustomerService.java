package com.example.CustomerSrvice.Service;

import com.example.CustomerSrvice.Model.Customer;
import com.example.CustomerSrvice.Model.CustomerAddress;

import com.example.CustomerSrvice.Repo.CustomerAddressRepository;
import com.example.CustomerSrvice.Repo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerAddressRepository addressRepository;

    // Get all customers
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    // Get customer by ID
    public Customer getCustomerById(Long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        return customer.orElseThrow(() -> new RuntimeException("Customer not found"));
    }

    // Create a new customer
    public Customer createCustomer(Customer customer) {
        // Save customer addresses
        CustomerAddress billingAddress = addressRepository.save(customer.getCustomerBillingAddress());
        CustomerAddress shippingAddress = addressRepository.save(customer.getCustomerShippingAddress());

        customer.setCustomerBillingAddress(billingAddress);
        customer.setCustomerShippingAddress(shippingAddress);
        return customerRepository.save(customer);
    }

    // Update an existing customer
    public Customer updateCustomer(Long id, Customer customerDetails) {
        Customer customer = getCustomerById(id);
        customer.setCustomerName(customerDetails.getCustomerName());
        customer.setCustomerEmail(customerDetails.getCustomerEmail());

        // Update addresses
        customer.setCustomerBillingAddress(customerDetails.getCustomerBillingAddress());
        customer.setCustomerShippingAddress(customerDetails.getCustomerShippingAddress());

        return customerRepository.save(customer);
    }

    // Delete a customer
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}
