package com.ecommerce.project.services.api;

import com.ecommerce.project.dto.products.GetAllProductsApiRequest;
import com.ecommerce.project.entities.Product;
import com.ecommerce.project.repositories.CategoryRepository;
import com.ecommerce.project.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;


import java.util.List;

@Service
public class ApiProductService  {
    private ProductRepository productRepository;

    @Autowired
    public ApiProductService(ProductRepository productRepository ){
        this.productRepository = productRepository;
    }

    public Page<Product> getPaginatedProducts(GetAllProductsApiRequest request){
        int page = Math.max(request.getPage(), 0);
        int size = request.getLimit() > 0 ? request.getLimit() : 20;
        Pageable pageable = PageRequest.of(page, size);
        Page<Product> result = productRepository.findAll(pageable);
        return result;
    }

}
