package com.Rest.API.web;


import com.Rest.API.model.Customer;
import com.Rest.API.model.Student;
import com.Rest.API.service.CustomerService;
import com.Rest.API.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomer(){
        List<Customer> customerList =  customerService.getAllCustomer();
        return ResponseEntity.ok(customerList);
    }

    @GetMapping("{id}")
    public ResponseEntity<Customer> getAllCustomer(@PathVariable Long id){
        return ResponseEntity.ok(customerService.getCustomer(id));
    }

    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer){
        return customerService.createCustomer(customer);
    }


    @PutMapping("{id}")
    public Customer updateCustomer(@PathVariable Long id, @RequestBody Customer customer){
        return customerService.updateCustomer(id, customer);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Long id){
    customerService.deleteCustomer(id);
        return ResponseEntity.ok("delete success");
    }
}


