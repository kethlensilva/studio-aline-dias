package com.studioalinedias.hair_products.controller;

import com.studioalinedias.hair_products.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/catalog")
    public String catalog(Model model) {
        model.addAttribute("products", productService.findAll());
        return "catalog";
    }

}
