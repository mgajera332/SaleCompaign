package com.example.SalesCompaign.Service;

import com.example.SalesCompaign.Entity.Product;
import com.example.SalesCompaign.Repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepo productRepo;

    public void add(Product product){
        productRepo.save(product);
    }

    public List<Product> get(){
        return productRepo.findAll();
    }
}
