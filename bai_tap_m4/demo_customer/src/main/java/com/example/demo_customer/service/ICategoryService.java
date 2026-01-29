package com.example.demo_customer.service;

import com.example.demo_customer.entity.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();
    Category findById(int id);
}
