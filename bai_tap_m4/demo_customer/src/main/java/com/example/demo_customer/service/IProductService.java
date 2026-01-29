package com.example.demo_customer.service;

import com.example.demo_customer.entity.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    Product findById(int id);

    Product searchByName(String name);

    boolean addProduct(Product product);

    boolean deleteProduct(int id);
}
