package com.workintech.controller;

import com.workintech.dto.AccountResponse;
import com.workintech.entity.Account;
import com.workintech.entity.Customer;
import com.workintech.service.AccountService;
import com.workintech.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    private final AccountService accountService;
    private final CustomerService customerService;
    @Autowired
    public AccountController(AccountService accountService, CustomerService customerService) {
        this.accountService = accountService;
        this.customerService = customerService;
    }
    @PostMapping("/{customerId}")
    public AccountResponse save(@PathVariable Long customerId, @RequestBody Account account){
        Customer customer = customerService.findById(customerId);
        account.setCustomer(customer);
        return accountService.save(account);
    }

    @GetMapping
    public List<AccountResponse> getAll(){
        return accountService.findAll();
    }

    @GetMapping("/{id}")
    public AccountResponse getById(@PathVariable Long id){
        return accountService.getById(id);
    }

    @DeleteMapping("/{id}")
    public AccountResponse delete(@PathVariable Long id){
        return accountService.remove(id);
    }

}
