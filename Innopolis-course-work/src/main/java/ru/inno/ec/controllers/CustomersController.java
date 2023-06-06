package ru.inno.ec.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.inno.ec.dto.CustomerForm;
import ru.inno.ec.services.CustomersService;

@RequiredArgsConstructor
@Controller
@RequestMapping("/customers")
public class CustomersController {

    private final CustomersService customersService;

    @GetMapping
    public String getCustomersPage(@RequestParam(value = "orderBy", required = false) String orderBy,
                                   @RequestParam(value = "dir", required = false) String direction, Model model) {
        model.addAttribute("customers", customersService.getAllCustomers());
        return "customers/customers_page";
    }

    @PostMapping
    public String addCustomer(CustomerForm customer) {
        customersService.addCustomer(customer);
        return "redirect:/customers";
    }

    @GetMapping("/{customer-id}")
    public String getCustomerPage(@PathVariable("customer-id") Long id, Model model) {
        model.addAttribute("role", customersService.getCustomer(id).getRole());
        model.addAttribute("customer", customersService.getCustomer(id));
        return "customers/customer_page";
    }

    @PostMapping("/{customer-id}/update")
    public String updateCustomer(@PathVariable("customer-id") Long id, CustomerForm customer) {
        customersService.updateCustomerForm(id, customer);
        return "redirect:/customers/" + id;
    }

    @GetMapping("/{customer-id}/delete")
    public String deleteCustomer(@PathVariable("customer-id") Long id) {
        customersService.deleteCustomer(id);
        return "redirect:/customers/";
    }
}
