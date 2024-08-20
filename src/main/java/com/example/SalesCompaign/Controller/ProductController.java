package com.example.SalesCompaign.Controller;

import com.example.SalesCompaign.Entity.Product;
import com.example.SalesCompaign.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping
    public boolean insert(@RequestBody Product product){
        productService.add(product);
        return true;
    }

    @GetMapping
    public List<Product> allProduct(){
        return productService.get();
    }
}
