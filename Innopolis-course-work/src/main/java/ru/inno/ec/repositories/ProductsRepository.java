package ru.inno.ec.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.inno.ec.models.Customer;
import ru.inno.ec.models.Product;

import java.util.List;

public interface ProductsRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByStateNot(Product.State state);

    List<Product> findAllByCustomersContains(Customer customer);
}
