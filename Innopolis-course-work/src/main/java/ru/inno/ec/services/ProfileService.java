package ru.inno.ec.services;

import ru.inno.ec.models.Customer;
import ru.inno.ec.security.details.CustomUserDetails;

public interface ProfileService {
    Customer getCurrent(CustomUserDetails userDetails);
}
