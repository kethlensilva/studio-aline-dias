package com.studioalinedias.hair_products.controller;

import com.studioalinedias.hair_products.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CartController {
    @Autowired
    private CartService cartService;
    @PostMapping("/cart")
    public String addToCart(@RequestParam Long productId, @RequestParam Long userId) {
        // lógica para adicionar produto ao carrinho
        return "redirect:/catalog";
    }

    @GetMapping("/cart")
    public String viewCart(Model model, @RequestParam Long userId) {
        // lógica para visualizar o carrinho
        return "cart";
    }
}
