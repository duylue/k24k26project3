package com.example.K2426Project3.service.impl;

import com.example.K2426Project3.model.Product;
import com.example.K2426Project3.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> list() {
        List<Product> list = productRepository.findAll();
        return list;
    }
    @Override
    public void save(Product product) {
        productRepository.save(product);
    }
    @Override
    public Product findById(int id) {
        Optional<Product> optional = productRepository.findById(id);
        if (optional.isEmpty()) {
            throw new RuntimeException("khong ton tai");
        } else {
            Product product = optional.get();
            return product;
        }

    }
    @Override
    public void delete(int id) {
        productRepository.deleteById(id);
    }
}
