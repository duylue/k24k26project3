package com.example.K2426Project3.service.impl;

import com.example.K2426Project3.model.Category;
import com.example.K2426Project3.model.Product;
import com.example.K2426Project3.model.ProductDto;
import com.example.K2426Project3.repository.CategoryRepository;
import com.example.K2426Project3.repository.ProductRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    ObjectMapper objectMapper;

    @Override
    public List<Product> list() {
        List<Product> list = productRepository.findAll();
        return list;
    }

    @Override
    public List<Map<String, Object>> find(String p) {
        List<ProductDto> list = new ArrayList<>();
        List<Map<String, Object>> maps = productRepository.findProduct(p);
        for (Map<String, Object> m : maps
        ) {
            ProductDto productDto = objectMapper.convertValue(m, ProductDto.class);
            list.add(productDto);
        }

        return productRepository.findProduct(p);
    }

    @Override
    public List<Product> findByPnameAndPrice(String pname, int pid) {
        boolean check = productRepository.existsByPid(pid);
        return productRepository.searchProductsByPname(pname);
    }

    @Override
    public List<Map<String, Object>> getList() {
        return productRepository.getProductList();
    }
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> categoryList() {
        return categoryRepository.findAll();
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
