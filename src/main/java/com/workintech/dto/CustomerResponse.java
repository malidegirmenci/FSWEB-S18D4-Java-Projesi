package com.workintech.dto;

import com.workintech.entity.Address;

public record CustomerResponse(Long id,
                               String firstName,
                               String lastName,
                               String email,
                               Integer salary,
                               AddressResponse addressResponse) {
}
