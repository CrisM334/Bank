package com.bank.services.services;

import com.bank.services.model.Customer;
import com.bank.services.model.CustomerAccountDetails;
import com.bank.services.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;



@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer insertCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public List<Customer> getAllCustomers() {
        return (List<Customer>) customerRepository.findAll();
    }

    public Optional<Customer> findCustomerById(Long id) {
        return customerRepository.findById(id);
    }


    // Method to get customer and account details
    public List<CustomerAccountDetails> findAllCustomerAccountDetails() {
        return customerRepository.findCustomerAccountDetails();
    }

    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}
