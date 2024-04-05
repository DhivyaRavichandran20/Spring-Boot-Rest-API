package com.Rest.API.dao;

import com.Rest.API.model.Customer;
import com.Rest.API.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
