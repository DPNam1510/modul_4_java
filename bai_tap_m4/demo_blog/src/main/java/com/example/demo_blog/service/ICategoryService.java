package com.example.demo_blog.service;

import com.example.demo_blog.entity.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();
    Category findById(int id);
    boolean save(Category category);
    boolean delete(int id);
}
