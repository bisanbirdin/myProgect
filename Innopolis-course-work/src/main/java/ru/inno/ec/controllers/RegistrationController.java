package ru.inno.ec.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.inno.ec.models.Customer;
import ru.inno.ec.services.CustomersService;

@RequiredArgsConstructor
@Controller
public class RegistrationController {

    private final CustomersService customersService;

    @GetMapping("/registration")
    public String getRegistrationPage() {
        return "/registration_page";
    }

    @PostMapping("/registration")
    public String registrationCustomer(Customer customer) {
        customersService.registrationCustomer(customer);
        return "/email_page";
    }
}
