package com.workintech.controller;

import com.workintech.dto.AccountResponse;
import com.workintech.entity.Account;
import com.workintech.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }
    @PostMapping
    public AccountResponse save(@RequestBody Account account){
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
