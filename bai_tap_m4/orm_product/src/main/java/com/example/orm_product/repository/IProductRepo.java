package com.example.orm_product.repository;
import com.example.orm_product.entity.Product;

import java.util.List;

public interface IProductRepo {
    List<Product> getList();
    boolean add(Product product);
    Product findById(int id);
    boolean edit(Product product);
    boolean deleteById(int id);
    Product detail(int id);
    List<Product> search(String searchName,String searchProduce);
}
