package ru.inno.ec.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.inno.ec.models.Product;
import ru.inno.ec.security.details.CustomUserDetails;
import ru.inno.ec.services.ProductsService;

@RequiredArgsConstructor
@Controller
@RequestMapping("/products")
public class ProductsController {

    private final ProductsService productsService;

    @GetMapping
    public String getProductsPage(@AuthenticationPrincipal CustomUserDetails customUserDetails, Model model) {
        model.addAttribute("role", customUserDetails.getCustomer().getRole());
        model.addAttribute("products", productsService.getAllProducts());
        return "products/products_page";
    }

    @PostMapping
    public String addProduct(Product product) {
        productsService.addProduct(product);
        return "redirect:/products";
    }

    @GetMapping("/{product-id}/delete")
    public String deleteProduct(@PathVariable("product-id") Long id) {
        productsService.deleteProduct(id);
        return "redirect:/products";
    }

    @GetMapping("/{product-id}")
    public String getProductPage(@AuthenticationPrincipal CustomUserDetails customUserDetails,
                                 @PathVariable("product-id") Long id, Model model) {
        model.addAttribute("role", customUserDetails.getCustomer().getRole());
        model.addAttribute("product", productsService.getProduct(id));
        return "products/product_page";
    }

    @PostMapping("/{product-id}/update")
    public String updateProduct(@PathVariable("product-id") Long id, Product product) {
        productsService.updateProduct(id, product);
        return "redirect:/products/" + id;
    }
}
