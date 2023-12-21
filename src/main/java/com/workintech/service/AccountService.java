package com.workintech.service;

import com.workintech.dto.AccountResponse;

import com.workintech.entity.Account;


import java.util.List;

public interface AccountService {
    AccountResponse save(Account account);
    Account findById(Long id);
    List<AccountResponse> findAll();
    AccountResponse remove(Long id);
    AccountResponse getById(Long id);
}
