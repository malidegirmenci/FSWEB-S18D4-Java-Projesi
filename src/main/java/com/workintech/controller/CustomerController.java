package com.workintech.controller;

import com.workintech.dto.CustomerResponse;
import com.workintech.entity.Customer;
import com.workintech.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    private final CustomerService customerService;
    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
    @PostMapping
    public CustomerResponse save(@RequestBody Customer customer){
        return customerService.save(customer);
    }


    @GetMapping
    public List<CustomerResponse> getAll(){
        return customerService.findAll();
    }

    @GetMapping("/{id}")
    public CustomerResponse getById(@PathVariable Long id){
        return customerService.getById(id);
    }

    @DeleteMapping("/{id}")
    public CustomerResponse delete(@PathVariable Long id){
        return customerService.remove(id);
    }

}
