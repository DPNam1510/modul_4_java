package com.example.demo_blog.repository;

import com.example.demo_blog.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepo extends JpaRepository<Category,Integer> {

}
