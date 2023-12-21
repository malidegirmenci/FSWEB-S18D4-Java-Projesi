package com.workintech.service;

import com.workintech.converter.DtoConverter;
import com.workintech.dto.CustomerResponse;
import com.workintech.entity.Customer;
import com.workintech.exceptions.CustomException;
import com.workintech.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public CustomerResponse save(Customer customer) {
        return DtoConverter.convertToCustomerResponse(customerRepository.save(customer));
    }

    @Override
    public Customer findById(Long id) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if(optionalCustomer.isPresent()){
            return optionalCustomer.get();
        }
        throw new CustomException("Given id is not exist: "+id, HttpStatus.BAD_REQUEST);
    }
    @Override
    public CustomerResponse getById(Long id){
        return DtoConverter.convertToCustomerResponse(findById(id));
    }
    @Override
    public List<CustomerResponse> findAll() {
        return DtoConverter.convertToCustomerResponseList(customerRepository.findAll());
    }

    @Override
    public CustomerResponse remove(Long id) {
        Customer willRemoveCustomer = findById(id);
        customerRepository.delete(willRemoveCustomer);
        return DtoConverter.convertToCustomerResponse(willRemoveCustomer);
    }
}
