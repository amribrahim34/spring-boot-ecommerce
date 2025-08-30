package com.ecommerce.project.controllers.admin;


import com.ecommerce.project.entities.Product;
import com.ecommerce.project.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/products")
public class ProductController {
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping
    public String listProducts(Model model){
        Product product = new Product();
        List<Product> products = productService.findAll();
        model.addAttribute("product" , product);
        model.addAttribute("products" , products);
        return "products/list";
    }

    @PostMapping
    public String storeProduct(@ModelAttribute("product")  Product product, Model model){
        productService.save(product);
//        model.addAttribute("product", product);
        return "redirect:/admin/products";
    }

    @GetMapping("/{id}/edit")
    public String editProducts(@PathVariable Long id,Model model){
        Product product = productService.findById(id);
        model.addAttribute("product" , product);
        return "products/edit";
    }

    @PutMapping("/{id}/update")
    public String updateProduct(@PathVariable Long id ,@ModelAttribute("product")  Product product){
        productService.save(product);
        return "redirect:/admin/products";
    }

    @DeleteMapping("/{id}/delete")
    public String deleteProduct(@PathVariable Long id){
        productService.delete(id);
        return "redirect:/admin/products";
    }
}
