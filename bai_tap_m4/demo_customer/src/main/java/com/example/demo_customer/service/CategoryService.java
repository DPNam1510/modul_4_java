package com.example.demo_customer.service;


import com.example.demo_customer.entity.Category;
import com.example.demo_customer.repository.ICategoryRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    private ICategoryRepo categoryRepo;
    public CategoryService(ICategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    @Override
    public List<Category> findAll() {
        return categoryRepo.findAll();
    }

    @Override
    public Category findById(int id) {
        return categoryRepo.findById(id).orElse(null);
    }
}
