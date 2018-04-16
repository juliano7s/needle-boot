package com.creationguts.needle.repo;

import com.creationguts.needle.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
