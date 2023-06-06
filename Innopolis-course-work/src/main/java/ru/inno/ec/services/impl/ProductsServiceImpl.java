package ru.inno.ec.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.inno.ec.models.Product;
import ru.inno.ec.repositories.ProductsRepository;
import ru.inno.ec.services.ProductsService;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductsServiceImpl implements ProductsService {

    private final ProductsRepository productsRepository;

    @Override
    public List<Product> getAllProducts() {
        return productsRepository.findAllByStateNot(Product.State.DELETED);
    }

    @Override
    public void addProduct(Product product) {
        Product newProduct = Product.builder()
                .name(product.getName())
                .price(product.getPrice())
                .state(Product.State.CONFIRMED)
                .build();

        productsRepository.save(newProduct);
    }

    @Override
    public void deleteProduct(Long id) {
        Product productForDelete = productsRepository.findById(id).orElseThrow();

        productForDelete.setState(Product.State.DELETED);

        productsRepository.save(productForDelete);
    }

    @Override
    public Product getProduct(Long id) {
        return productsRepository.findById(id).orElseThrow();
    }

    @Override
    public void updateProduct(Long id, Product product) {
        Product productForUpdate = productsRepository.findById(id).orElseThrow();
        productForUpdate.setName(product.getName());
        productForUpdate.setPrice(product.getPrice());

        productsRepository.save(productForUpdate);
    }
}
