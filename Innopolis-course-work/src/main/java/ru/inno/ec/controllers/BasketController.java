package ru.inno.ec.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.inno.ec.services.*;

@RequiredArgsConstructor
@Controller
public class BasketController {

    private final CustomersService customersService;
    private final ProductsService productsService;
    private final MoviesService moviesService;
    private final SessionsService sessionsService;

    @GetMapping("/basket/{movie-id}/{session-id}")
    public String getBasketPage(@PathVariable("movie-id") Long movieId,
                                @PathVariable("session-id") Long sessionId, Model model) {
//        model.addAttribute("products", productsService.getAllProducts());
        model.addAttribute("movie", moviesService.getMovie(movieId));
        model.addAttribute("session", sessionsService.getSession(sessionId));
//        model.addAttribute("inCustomerProducts", customersService.getInCustomerProducts(customerId));
        return "basket";
    }

//    @PostMapping("/basket/{customer-id}")
//    public String addProductsToCustomer(@PathVariable("customer-id") Long customerId,
//                                        @RequestParam("product-id") Long productId, Model model) {
//        model.addAttribute("customer", customersService.getCustomer(customerId));
//
//        customersService.addProductsToCustomer(customerId, productId);
//        return "basket";
//    }
}
