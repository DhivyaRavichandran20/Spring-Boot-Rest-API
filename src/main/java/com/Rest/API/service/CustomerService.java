package com.Rest.API.service;


import com.Rest.API.dao.CustomerRepository;
import com.Rest.API.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRespository;
    public  List<Customer> getAllCustomer(){

      /*  Student s1 = new Student("John", "R111", "12345", new Date(1985,04,04));
        Student s2 = new Student("Rebecca", "R112", "12345", new Date(1975,04,04));
        Student s3 = new Student("Alex", "R113", "12345", new Date(1965,04,04));
        return List.of(s1,s2,s3);*/

        return customerRespository.findAll();

    }

    public Customer getCustomer(Long id){
        Optional<Customer> maybeCustomer = customerRespository.findById(id);
        return maybeCustomer.orElse(null);
    }

    public Customer createCustomer(Customer customer){
      Customer customer1 =customerRespository.save(customer);
        return customer1;
    }

    public Customer updateCustomer(Long id,Customer customer){

    Customer customer1 = customerRespository.findById(id).get();
       customer1.setContact(customer.getContact());
        customer1.setAddress(customer.getAddress());
        customer1.setName(customer.getName());
        customer1.setRating(customer.getRating());
        return customerRespository.save(customer1);
    }

    public void deleteCustomer(Long id){

        boolean customerExist = customerRespository.existsById(id);

        if(customerExist){
           customerRespository.deleteById(id);
        }

    }
}
