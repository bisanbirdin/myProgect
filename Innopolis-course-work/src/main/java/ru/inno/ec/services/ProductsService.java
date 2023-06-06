package ru.inno.ec.services;

import ru.inno.ec.models.Product;

import java.util.List;

public interface ProductsService {
    List<Product> getAllProducts();

    void addProduct(Product product);

    void deleteProduct(Long id);

    Product getProduct(Long id);

    void updateProduct(Long id, Product product);
}
