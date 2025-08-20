package com.example.GetRide.transformers;

import com.example.GetRide.dto.request.CustomerRequest;
import com.example.GetRide.dto.response.CustomerResponse;
import com.example.GetRide.model.Customer;

public class CustomerTransformer {

    public static Customer customerRequestToCustomer(CustomerRequest customerRequest) {

        return Customer.builder()
                .age(customerRequest.getAge())
                .name(customerRequest.getName())
                .emailId(customerRequest.getEmailId())
                .gender(customerRequest.getGender())
                .build();

    }
    public static CustomerResponse customerToCustomerResponse(Customer customer) {

        return CustomerResponse.builder()
                .gender(customer.getGender())
                .emailId(customer.getEmailId())
                .name(customer.getName())
                .build();
    }
}
