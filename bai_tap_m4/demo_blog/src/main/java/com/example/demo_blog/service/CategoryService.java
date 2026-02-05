package com.example.demo_blog.service;

import com.example.demo_blog.entity.Category;
import com.example.demo_blog.repository.ICategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CategoryService implements ICategoryService{
    @Autowired
    private ICategoryRepo categoryRepo;
    @Override
    public List<Category> findAll() {
        return categoryRepo.findAll();
    }
    @Override
    public Category findById(int id) {
        return categoryRepo.findById(id).orElse(null);
    }
    @Override
    public boolean save(Category category) {
        try {
            categoryRepo.save(category);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    @Override
    public boolean delete(int id) {
        try {
            categoryRepo.deleteById(id);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
