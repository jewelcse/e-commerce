package com.productservice.entity;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Product {
    @Id
    private String productId;
    private String productTitle;
    private Category category;
    private String productDescription;
    private String productImagePath;
    private double productPrice;

    public Product() {
    }

    public Product(String productTitle, Category category, String productDescription, String productImagePath, double productPrice) {
        this.productTitle = productTitle;
        this.category = category;
        this.productDescription = productDescription;
        this.productImagePath = productImagePath;
        this.productPrice = productPrice;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductImagePath() {
        return productImagePath;
    }

    public void setProductImagePath(String productImagePath) {
        this.productImagePath = productImagePath;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productTitle='" + productTitle + '\'' +
                ", category=" + category +
                ", productDescription='" + productDescription + '\'' +
                ", productImagePath='" + productImagePath + '\'' +
                ", productPrice=" + productPrice +
                '}';
    }
}
