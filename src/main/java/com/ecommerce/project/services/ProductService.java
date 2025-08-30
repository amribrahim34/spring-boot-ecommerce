package com.ecommerce.project.services;

import com.ecommerce.project.entities.Product;
import com.ecommerce.project.repositories.ProductRepository;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements ServiceInterface <Product>{
    protected ProductRepository productRepository;

    @Autowired
    public  ProductService(ProductRepository theProductRepository){
        productRepository = theProductRepository;
    }

    @Override
    public List<Product> findAll(){
        return productRepository.findAll();
    }

    @Override
    public Product findById(Long theId) {
        return productRepository.findById(theId)
                .orElseThrow(() -> new RuntimeException("Product not found: " + theId));
    }

    @Override
    public Product save(Product entity) {
        return productRepository.save(entity);
    }

//    @Override
//    public Product update(Product entity) {
//        return productRepository.update();
//    }

    @Override
    public void delete(Long theId) {
         productRepository.deleteById(theId);
    }
}
