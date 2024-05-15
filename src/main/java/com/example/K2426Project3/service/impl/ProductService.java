package com.example.K2426Project3.service.impl;

import com.example.K2426Project3.model.Category;
import com.example.K2426Project3.model.Customer;
import com.example.K2426Project3.model.Product;
import com.example.K2426Project3.model.Zone;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;


public interface ProductService {
    List<Product> list();
    List<Category> categoryList();
    List<Product> findByPnameAndPrice(String pname, int price);
    List<Map<String, Object>> getList();
    List<Map<String, Object>> find(String id);
    void save(Product product);
    Product findById(int id);
    void delete(int id);
}
