package com.test.crm.service;

import com.test.crm.entity.Product;
import com.test.crm.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional
    public List<Product> findAllByName(String name){
        return productRepository.findAllByName(name);
    }

    @Transactional
    public void createProduct(Product product){
        productRepository.saveAndFlush(product);
    }

    @Transactional
    public List<Product> findAll(){
        return productRepository.findAll();
    }
}
