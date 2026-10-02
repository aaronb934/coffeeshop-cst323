package com.gcu.coffeeshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.coffeeshop.model.ProductModel;

/**
 * This controller handles the web pages for products
 */
@Controller
@RequestMapping("/product")
public class ProductController {
    
    /**
     * Shows the create product page
     * @param model holds data for the view
     * @return the createProduct html page
     */
    @GetMapping("/create")
    public String showCreate(Model model) {
        // This method displays the empty form to the user
        model.addAttribute("title", "Add New Product");
        model.addAttribute("productModel", new ProductModel());
        return "createProduct";
    }
}