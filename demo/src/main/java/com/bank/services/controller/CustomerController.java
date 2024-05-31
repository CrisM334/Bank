package com.bank.services.controller;

import com.bank.services.model.Customer;
import com.bank.services.model.CustomerAccountDetails;
import com.bank.services.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        Customer savedCustomer = customerService.insertCustomer(customer);
        return ResponseEntity.ok(savedCustomer);
    }

    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> customers = customerService.getAllCustomers();
        return ResponseEntity.ok(customers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable("id") Long id) {
        return customerService.findCustomerById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // New endpoint for customer-account details
    @GetMapping("/details")
    public ResponseEntity<List<CustomerAccountDetails>> getAllCustomerAccountDetails() {
        List<CustomerAccountDetails> details = customerService.findAllCustomerAccountDetails();
        return ResponseEntity.ok(details);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable("id") Long id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.noContent().build();  // Returns an HTTP 204 response.
    }

    


}
