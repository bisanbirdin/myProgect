package ru.inno.ec.services;

import ru.inno.ec.dto.CustomerForm;
import ru.inno.ec.models.Customer;
import ru.inno.ec.models.Product;

import java.util.List;

public interface CustomersService {
    List<Customer> getAllCustomers();

    void addCustomer(CustomerForm customer);

    Customer getCustomer(Long id);

    Customer getCustomer(String email);

    void updateCustomerForm(Long id, CustomerForm customer);

    void updateCustomer(Long id);

    void deleteCustomer(Long id);

    void registrationCustomer(Customer customer);

    void addProductsToCustomer(Long customerId, Long productId);

    List<Product> getInCustomerProducts(Long customerId);
}
