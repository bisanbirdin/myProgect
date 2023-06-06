package ru.inno.ec.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.inno.ec.models.Customer;
import ru.inno.ec.repositories.CustomersRepository;
import ru.inno.ec.security.details.CustomUserDetails;
import ru.inno.ec.services.ProfileService;

@RequiredArgsConstructor
@Service
public class ProfileServiceImpl implements ProfileService {

    private final CustomersRepository customersRepository;

    @Override
    public Customer getCurrent(CustomUserDetails userDetails) {
        return customersRepository.findById(userDetails.getCustomer().getId()).orElseThrow();
    }
}
