package com.example.demo_customer.repository;

import com.example.demo_customer.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepo extends JpaRepository<Product,Integer>{
}
