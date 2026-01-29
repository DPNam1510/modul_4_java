package com.example.demo_customer.service;

import com.example.demo_customer.entity.Product;
import com.example.demo_customer.repository.IProductRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Transactional
@Service
public class ProductService implements IProductService {

    private IProductRepo productRepo;
    public ProductService(IProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public List<Product> findAll() {
        return productRepo.findAll();
    }

    @Override
    public Product findById(int id) {
        return productRepo.findById(id).orElse(null);
    }

    @Override
    public Product searchByName(String name) {
        return null;
    }

    @Override
    public boolean addProduct(Product product) {

        try{
            productRepo.save(product);
            return true;
        }catch(Exception e){
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean deleteProduct(int id) {
        try{
            productRepo.deleteById(id);
            return true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
