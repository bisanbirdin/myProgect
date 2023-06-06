package ru.inno.ec.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.inno.ec.dto.CustomerForm;
import ru.inno.ec.models.Customer;
import ru.inno.ec.models.Product;
import ru.inno.ec.models.Session;
import ru.inno.ec.repositories.CustomersRepository;
import ru.inno.ec.repositories.ProductsRepository;
import ru.inno.ec.services.CustomersService;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CustomersServiceImpl implements CustomersService {

    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    private final CustomersRepository customersRepository;
    private final ProductsRepository productsRepository;

    @Override
    public List<Customer> getAllCustomers() {
        return customersRepository.findAllByStateNot(Customer.State.DELETED);
    }

    @Override
    public void addCustomer(CustomerForm customer) {
        Customer newCustomer = Customer.builder()
                .email(customer.getEmail())
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .age(customer.getAge())
                .state(Customer.State.NOT_CONFIRMED)
                .build();

        customersRepository.save(newCustomer);
    }

    @Override
    public Customer getCustomer(Long id) {
        return customersRepository.findById(id).orElseThrow();
    }

    @Override
    public Customer getCustomer(String email) {
        return customersRepository.findByEmail(email).orElseThrow();
    }

    @Override
    public void updateCustomerForm(Long id, CustomerForm customer) {
        Customer customerForUpdate = customersRepository.findById(id).orElseThrow();

        customerForUpdate.setEmail(customerForUpdate.getEmail());
        customerForUpdate.setFirstName(customer.getFirstName());
        customerForUpdate.setLastName(customer.getLastName());
        customerForUpdate.setAge(customer.getAge());

        customersRepository.save(customerForUpdate);
    }

    @Override
    public void updateCustomer(Long id) {
        Customer customerConfirmed=customersRepository.findById(id).orElseThrow();

        customerConfirmed.setState(Customer.State.CONFIRMED);

        customersRepository.save(customerConfirmed);
    }

    @Override
    public void deleteCustomer(Long id) {
        Customer customerForDelete = customersRepository.findById(id).orElseThrow();
        customerForDelete.setState(Customer.State.DELETED);

        customersRepository.save(customerForDelete);
    }

    @Override
    public void registrationCustomer(Customer customer) {
        String password = customer.getPassword();
        String encoderPassword = passwordEncoder.encode(password);

        Customer regCustomer = Customer.builder()
                .email(customer.getEmail())
                .password(encoderPassword)
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .age(customer.getAge())
                .role(Customer.Role.USER)
                .state(Customer.State.NOT_CONFIRMED)
                .build();

        customersRepository.save(regCustomer);
    }

    @Override
    public void addProductsToCustomer(Long customerId, Long productId) {
        Customer customer = customersRepository.findById(customerId).orElseThrow();
        Product product = productsRepository.findById(productId).orElseThrow();

        customer.getProducts().add(product);

        customersRepository.save(customer);
    }

    @Override
    public List<Product> getInCustomerProducts(Long customerId) {
        Customer customer = customersRepository.findById(customerId).orElseThrow();
        return productsRepository.findAllByCustomersContains(customer);
    }
}
