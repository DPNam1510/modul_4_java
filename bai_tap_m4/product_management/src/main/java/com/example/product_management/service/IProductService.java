package com.example.product_management.service;

import com.example.product_management.entity.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    Product findById(int id);

    Product searchByName(String name);

    boolean addProduct(Product product);

    boolean updateProduct(Product product);

    boolean deleteProduct(int id);
}
