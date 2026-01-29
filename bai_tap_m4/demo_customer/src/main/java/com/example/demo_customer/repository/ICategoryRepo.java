package com.example.demo_customer.repository;

import com.example.demo_customer.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepo extends JpaRepository<Category,Integer> {
}
