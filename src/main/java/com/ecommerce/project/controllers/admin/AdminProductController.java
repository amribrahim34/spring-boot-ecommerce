package com.ecommerce.project.controllers.admin;


import com.ecommerce.project.entities.Category;
import com.ecommerce.project.entities.Product;
import com.ecommerce.project.services.CategoryService;
import com.ecommerce.project.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin/products")
public class AdminProductController {
    private ProductService productService;
    private CategoryService categoryService;

    @Autowired
    public AdminProductController(ProductService productService , CategoryService categoryService){
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @GetMapping
    public String listProducts(Model model){
        Product product = new Product();
        List<Product> products = productService.findAll();
        List<Category> categories = categoryService.findAll();
        model.addAttribute("product" , product);
        model.addAttribute("categories" , categories);
        model.addAttribute("products" , products);
        return "products/list";
    }

    @PostMapping
    public String storeProduct(@Valid @ModelAttribute("product")  Product product, BindingResult br, Model model){
        if (br.hasErrors()) {
            // لازم ترجّع نفس صفحة الفورم وتعيد تعبئة الداتا
            return "redirect:/admin/products";
        }
        productService.save(product);
        return "redirect:/admin/products";
    }

    @GetMapping("/{id}/edit")
    public String editProducts(@PathVariable Long id,Model model){
        Product product = productService.findById(id);
        List<Category> categories = categoryService.findAll();
        model.addAttribute("product" , product);
        model.addAttribute("categories" , categories);
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
