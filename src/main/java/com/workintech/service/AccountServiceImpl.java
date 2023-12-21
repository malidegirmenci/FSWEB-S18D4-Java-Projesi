package com.workintech.service;

import com.workintech.converter.DtoConverter;
import com.workintech.dto.AccountResponse;
import com.workintech.entity.Account;
import com.workintech.exceptions.CustomException;
import com.workintech.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountResponse save(Account account) {
        return DtoConverter.convertToAccountResponse(accountRepository.save(account));
    }

    @Override
    public Account findById(Long id) {
        Optional<Account> optionalAccount = accountRepository.findById(id);
        if (optionalAccount.isPresent()) {
            return optionalAccount.get();
        }
        throw new CustomException("Given id is not exist: " + id, HttpStatus.BAD_REQUEST);
    }

    @Override
    public List<AccountResponse> findAll() {
        return DtoConverter.convertToAccountResponseList(accountRepository.findAll());
    }

    @Override
    public AccountResponse remove(Long id) {
        Account willRemoveAccount = findById(id);
        accountRepository.delete(willRemoveAccount);
        return DtoConverter.convertToAccountResponse(willRemoveAccount);
    }

    @Override
    public AccountResponse getById(Long id){
        return DtoConverter.convertToAccountResponse(findById(id));
    }
}
