package com.example.SalesCompaign.Repository;

import com.example.SalesCompaign.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product,Integer> {
}
