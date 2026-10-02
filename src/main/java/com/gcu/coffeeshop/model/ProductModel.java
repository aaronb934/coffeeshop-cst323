package com.gcu.coffeeshop.model;

/**
 * This is the model class for a Product
 */
public class ProductModel {
    private String id;
    private String name;
    private String description;
    private Double price;
    private Integer quantity;
    
    /**
     * Default empty constructor
     */
    public ProductModel() {
        
    }
    
    /**
     * Constructor to set up a product 
     * @param id the product id
     * @param name the name of the product
     * @param description what the product is
     * @param price how much it costs
     * @param quantity how many are in stock
     */
    public ProductModel(String id, String name, String description, Double price, Integer quantity) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    /**
     * Gets the id
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the id
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets the name
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the description
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the price
     * @return the price
     */
    public Double getPrice() {
        return price;
    }

    /**
     * Sets the price
     * @param price the price to set
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * Gets the quantity
     * @return the quantity
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity
     * @param quantity the quantity to set
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}