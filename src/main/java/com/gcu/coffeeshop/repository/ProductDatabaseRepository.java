package com.gcu.coffeeshop.repository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.gcu.coffeeshop.model.ProductModel;

/**
 * Database implementation of the ProductRepository
 * Handles database operations using JdbcTemplate
 * Added for Activity 2 to execute database operations
 */
@Repository
public class ProductDatabaseRepository implements ProductRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * Returns all products from the PRODUCTS table and maps them to objects
     */
    @Override
    public List<ProductModel> getAllProducts() {
        String sql = "SELECT * FROM PRODUCTS";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            ProductModel product = new ProductModel();
            product.setId(String.valueOf(rs.getInt("ID")));
            product.setName(rs.getString("NAME"));
            product.setDescription(rs.getString("DESCRIPTION"));
            product.setPrice(rs.getDouble("PRICE"));
            product.setQuantity(rs.getInt("QUANTITY"));
            return product;
        });
    }

    /**
     * Inserts a new row into the PRODUCTS table
     */
    @Override
    public boolean addProduct(ProductModel product) {
        String sql = "INSERT INTO PRODUCTS (NAME, DESCRIPTION, PRICE, QUANTITY) VALUES (?, ?, ?, ?)";
        int rowsAffected = jdbcTemplate.update(sql, product.getName(), product.getDescription(), product.getPrice(), product.getQuantity());
        return rowsAffected > 0;
    }

    /**
     * Updates a row in the PRODUCTS table
     */
    @Override
    public boolean updateProduct(ProductModel product) {
        String sql = "UPDATE PRODUCTS SET NAME = ?, DESCRIPTION = ?, PRICE = ?, QUANTITY = ? WHERE ID = ?";
        int rowsAffected = jdbcTemplate.update(sql, product.getName(), product.getDescription(), product.getPrice(), product.getQuantity(), Integer.parseInt(product.getId()));
        return rowsAffected > 0;
    }

    /**
     * Deletes a row from the PRODUCTS table
     */
    @Override
    public boolean deleteProduct(String id) {
        String sql = "DELETE FROM PRODUCTS WHERE ID = ?";
        int rowsAffected = jdbcTemplate.update(sql, Integer.parseInt(id));
        return rowsAffected > 0;
    }

    /**
     * Gets a single product from the PRODUCTS table by its id
     */
    @Override
    public ProductModel getProductById(String id) {
        String sql = "SELECT * FROM PRODUCTS WHERE ID = ?";
        try {
            return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
                ProductModel product = new ProductModel();
                product.setId(String.valueOf(rs.getInt("ID")));
                product.setName(rs.getString("NAME"));
                product.setDescription(rs.getString("DESCRIPTION"));
                product.setPrice(rs.getDouble("PRICE"));
                product.setQuantity(rs.getInt("QUANTITY"));
                return product;
            }, Integer.parseInt(id));
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
}