package com.iliasServices.customer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public record CustomerService(CustomerRepository customerRepository ,  RestTemplate restTemplate) {

    public void registerCustomer(CustomerRegistrationRequest request) {
    Customer customer = Customer.builder()
            .firstName(request.firstName())
            .lastName(request.lastName())
            .email(request.email())
            .build();
    // todo : check if email valid
        // todo : check if email not taken
        // todo : store customer in db
        customerRepository.saveAndFlush(customer);
        // todo : check if fraudster
        FraudCeckResponse fraudCeckResponse = restTemplate.getForObject("http://localhost:8081/api/v1/fraud-check/{customerId}",
                FraudCeckResponse.class,customer.getId());
        if ( fraudCeckResponse.isFraudster()){
            throw new IllegalStateException("fraudster");
        }
        // todo : send notification
    }
}
