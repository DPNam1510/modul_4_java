package com.example.product_management.service;

import com.example.product_management.entity.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService implements IProductService {
    private final static List<Product> productList = new ArrayList<>();

    static {
        productList.add(new Product(1, "Iphone", 1000, "Apple phone", "Apple"));
        productList.add(new Product(2, "Samsung", 2000, "phone", "Samsung"));
        productList.add(new Product(3, "Xiaomi", 3000, "phone", "Xiaomi"));
    }

    @Override
    public List<Product> findAll() {
        return productList;
    }
    @Override
    public Product findById(int id) {
        for (Product product : productList) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }
    @Override
     public boolean addProduct(Product product){
       productList.add(product);
       return true;
    }
    @Override
    public boolean updateProduct(Product product){
        for (Product product1 : productList) {
            if (product1.getId() == product.getId()) {
                product1.setName(product.getName());
                product1.setPrice(product.getPrice());
                product1.setStatus(product.getStatus());
                product1.setManufacturer(product.getManufacturer());
                return true;
            }
        }
        return false;
    }
    @Override
    public boolean deleteProduct(int id){
        for (Product product : productList) {
            if (product.getId() == id) {
                productList.remove(product);
            }
        }
        return true;
    }
    @Override
    public Product searchByName(String name) {
        for (Product product : productList) {
            if (product.getName().equals(name)) {
                return product;
            }
        }
        return null;
    }
}
