package com.workintech.converter;

import com.workintech.dto.AccountResponse;
import com.workintech.dto.AddressResponse;
import com.workintech.dto.CustomerResponse;
import com.workintech.entity.Account;
import com.workintech.entity.Address;
import com.workintech.entity.Customer;

import java.util.ArrayList;
import java.util.List;


public class DtoConverter {
    public static CustomerResponse convertToCustomerResponse(Customer customer) {
        return new CustomerResponse(
                customer.getId(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getEmail(),
                customer.getSalary(),
                new AddressResponse(
                        customer.getAddress().getStreet(),
                        customer.getAddress().getNo(),
                        customer.getAddress().getCity(),
                        customer.getAddress().getCountry(),
                        customer.getAddress().getDescription()));
    }

    public static List<CustomerResponse> convertToCustomerResponseList(List<Customer> customers) {
        List<CustomerResponse> responses = new ArrayList<>();
        customers.forEach(customer -> responses.add(new CustomerResponse(
                customer.getId(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getEmail(),
                customer.getSalary(),
                new AddressResponse(
                        customer.getAddress().getStreet(),
                        customer.getAddress().getNo(),
                        customer.getAddress().getCity(),
                        customer.getAddress().getCountry(),
                        customer.getAddress().getDescription()))));
        return responses;
    }

    public static AccountResponse convertToAccountResponse(Account account){
        return new AccountResponse(
                account.getId(),
                account.getAccountName(),
                account.getMoneyAmount()
        );
    }

    public static List<AccountResponse> convertToAccountResponseList(List<Account> accounts){
        List<AccountResponse> responses = new ArrayList<>();
        accounts.forEach(account -> responses.add(
                new AccountResponse(
                        account.getId(),
                        account.getAccountName(),
                        account.getMoneyAmount()
                )));
        return responses;
    }
    public static AddressResponse convertToAddressResponse(Address address){
        return new AddressResponse(
                address.getStreet(),
                address.getNo(),
                address.getCity(),
                address.getCountry(),
                address.getDescription()
        );
    }
}
