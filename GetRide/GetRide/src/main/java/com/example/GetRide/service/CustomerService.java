package com.example.GetRide.service;

import com.example.GetRide.dto.request.CustomerRequest;
import com.example.GetRide.model.Customer;
import com.example.GetRide.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public String addCustomer(CustomerRequest customerRequest) {

        //dto -> entity
        Customer customer = new Customer();
        customer.setAge(customerRequest.getAge());
        customer.setName(customerRequest.getName());
        customer.setGender(customerRequest.getGender());
        customer.setEmailId(customerRequest.getEmailId());

        Customer savedCustomer = customerRepository.save(customer);
        return "customer added Successfully";
    }


    public Customer getCustomer(String email) {
        return customerRepository.findByEmailId(email);
    }

    public List<Customer> getAllByGenderAndAgeGreaterThan(String gender, int age) {
        return customerRepository.getAllByGenderAndAgeGreaterThan(gender, age);
    }
}
