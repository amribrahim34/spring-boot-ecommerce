package com.ecommerce.project.controllers;

import com.ecommerce.project.dto.products.GetAllProductsApiRequest;
import com.ecommerce.project.entities.Product;
import com.ecommerce.project.services.api.ApiProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/products")
public class ProductController {

    private ApiProductService apiProductService;

    @Autowired
    public ProductController(ApiProductService apiProductService){
        this.apiProductService = apiProductService;
    }

    @GetMapping
    @CrossOrigin(origins = {"http://localhost:5173","http://127.0.0.1:5173"})
    public Page<Product> getProducts(@ModelAttribute GetAllProductsApiRequest request){
        Page<Product> products =apiProductService.getPaginatedProducts(request);
        return products;
    }
}
