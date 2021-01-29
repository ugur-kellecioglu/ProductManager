package com.ugurk.ProductManager;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    
    public List<Product> listAll(){
	return productRepository.findAll();
    }
    
    public void save(Product product) {
	
	productRepository.save(product);
    }
    
    public Product get(int id) {

	return productRepository.findById(id).get();
	
    }
    
    public void delete(int id) {

	productRepository.deleteById(id);
    }
    
}
