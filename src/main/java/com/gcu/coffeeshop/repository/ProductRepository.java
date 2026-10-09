package com.gcu.coffeeshop.repository;

import java.util.List;
import com.gcu.coffeeshop.model.ProductModel;

/**
 * Interface defining the data access operations for products
 * Added for Activity 2 to establish database CRUD requirements
 */
public interface ProductRepository {
	
	/**
	 * Returns all products from the data source
	 * @return A list of ProductModel objects
	 */
    public List<ProductModel> getAllProducts();
    
    /**
     * Adds a new product to the data source
     * @param product The ProductModel containing details to save
     * @return true if successful, false otherwise
     */
    public boolean addProduct(ProductModel product);
    
    /**
     * Updates a product to the data source
     * @param product The ProductModel containing details to update
     * @return true if successful, false otherwise
     */
    public boolean updateProduct(ProductModel product);
    
    /**
     * Deletes a product from the database by its id
     * @param id The id of the product 
     * @return true if successful, false otherwise
     */
    public boolean deleteProduct(String id);
    
    /**
     * Gets a single product from the database by its id
     * @param id The id of the product
     * @return The matching ProductModel
     */
    public ProductModel getProductById(String id);
}