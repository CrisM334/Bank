package com.bank.services.repository;

import java.util.List;
import com.bank.services.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import com.bank.services.model.CustomerAccountDetails;


@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
    @Query("SELECT new com.bank.services.model.CustomerAccountDetails(c.customerId, c.name, c.email, a.accountId, a.balance) FROM Customer c JOIN c.accounts a")
    List<CustomerAccountDetails> findCustomerAccountDetails();
}

