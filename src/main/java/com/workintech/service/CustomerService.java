package com.workintech.service;

import com.workintech.dto.CustomerResponse;
import com.workintech.entity.Customer;

import java.util.List;

public interface CustomerService {
    CustomerResponse save(Customer customer);
    Customer findById(Long id);
    List<CustomerResponse> findAll();
    CustomerResponse remove(Long id);
    CustomerResponse getById(Long id);
}
