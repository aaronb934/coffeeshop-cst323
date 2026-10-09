package com.gcu.coffeeshop.controller;

import org.slf4j.Logger; 
import org.slf4j.LoggerFactory; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.coffeeshop.model.ProductModel;
import com.gcu.coffeeshop.repository.ProductRepository;

/**
 * This controller handles the web pages for products
 * Updated for Activity 2: Integrated ProductRepository, CRUD mapping, and SLF4J logging.
 */
@Controller
@RequestMapping("/product")
public class ProductController {

    // Instantiates the logger 
    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductRepository productRepository;

    /**
     * Shows the product list page
     * @param model holds data for the view
     * @return the productList html page
     */
    @GetMapping
    public String showProducts(Model model) {
        logger.info("Navigating to the Product List page");
        
        model.addAttribute("title", "Product List");
        model.addAttribute("products", productRepository.getAllProducts());
        return "productList";
    }

    /**
     * Shows the create product page
     * @param model holds data for the view
     * @return the createProduct html page
     */
    @GetMapping("/create")
    public String showCreate(Model model) {
        logger.info("Navigating to the Add New Product page");
        
        // This method displays the empty form to the user
        model.addAttribute("title", "Add New Product");
        model.addAttribute("productModel", new ProductModel());
        return "createProduct";
    }

    /**
     * Processes the create product form submission
     * @param productModel the product data from the form
     * @param model holds data for the view
     * @return redirects to product list on success, back to create on fail
     */
    @PostMapping("/create")
    public String processCreate(ProductModel productModel, Model model) {
        logger.info("Attempting to create a new product: {}", productModel.getName());
        
        if (productRepository.addProduct(productModel)) {
            logger.info("Successfully created product: {}", productModel.getName());
            return "redirect:/product";
        } else {
            logger.warn("Failed to create product: {}", productModel.getName());
            model.addAttribute("title", "Add New Product");
            return "createProduct";
        }
    }

    /**
     * Shows the edit product page for a specific product
     * @param id the id of the product to edit
     * @param model holds data for the view
     * @return the editProduct html page
     */
    @GetMapping("/edit/{id}")
    public String showEdit(@PathVariable String id, Model model) {
        logger.info("Navigating to the Edit Product page for ID: {}", id);
        
        ProductModel product = productRepository.getProductById(id);
        model.addAttribute("title", "Edit Product");
        model.addAttribute("productModel", product);
        return "editProduct";
    }

    /**
     * Processes the edit product form submission
     * @param id the id of the product being updated
     * @param productModel the updated product data
     * @param model holds data for the view
     * @return redirects to product list on success, back to edit on fail
     */
    @PostMapping("/edit/{id}")
    public String processEdit(@PathVariable String id, ProductModel productModel, Model model) {
        logger.info("Attempting to update product ID: {}", id);
        
        productModel.setId(id);
        if (productRepository.updateProduct(productModel)) {
            logger.info("Successfully updated product ID: {}", id);
            return "redirect:/product";
        } else {
            logger.warn("Failed to update product ID: {}", id);
            model.addAttribute("title", "Edit Product");
            return "editProduct";
        }
    }

    /**
     * Processes a product delete request
     * @param id the id of the product to delete
     * @return redirects to the product list
     */
    @PostMapping("/delete/{id}")
    public String deleteProduct(@PathVariable String id) {
        logger.info("Attempting to delete product ID: {}", id);
        
        productRepository.deleteProduct(id);
        return "redirect:/product";
    }
}