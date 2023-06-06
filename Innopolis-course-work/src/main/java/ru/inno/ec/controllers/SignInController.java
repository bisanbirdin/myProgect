package ru.inno.ec.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.inno.ec.services.CustomersService;

@RequiredArgsConstructor
@Controller
public class SignInController {

    private final CustomersService customersService;

    @GetMapping("/signIn")
    public String getSignInPage() {
        return "signIn_page";
    }

    @GetMapping("/signInNew/{customer-id}")
    public String getSignInPageForNewCustomer(@PathVariable("customer-id") Long id, Model model) {
        model.addAttribute("customer", customersService.getCustomer(id));
        customersService.updateCustomer(id);
        return "signInNew";
    }

    @GetMapping("/localhost/signInNew/{customer-id}")
    public String getProfilePage(@RequestParam(value = "email", required = false) String email,
                                   @RequestParam(value = "password", required = false) String password) {
        return "profile_page";
    }
}
