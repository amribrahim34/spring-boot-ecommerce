package com.ecommerce.project.controllers.admin;

import com.ecommerce.project.entities.Category;
import com.ecommerce.project.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;

@RequestMapping("/admin/categories")
@Controller
public class CategoryController {
    protected CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @GetMapping
    public String listCategories (Model model){
        Category category = new Category();
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories" , categories);
        model.addAttribute("category" , category);
        return "categories/list";
    }

    @PostMapping
    public String storeCategory(@ModelAttribute("category" )Category category , @RequestParam("image") MultipartFile image){
        categoryService.save(category);
        return "redirect:/admin/categories";
    }

    @GetMapping("/{id}/edit")
    public String editCategory (Model model , @PathVariable Long id){
        Category category = categoryService.findById(id);
        List<Category> categories = categoryService.findAll();
        model.addAttribute("category" , category);
        model.addAttribute("categories" , categories);
        return "categories/edit";
    }

    @PutMapping("{id}/update")
    public String updateCategory(@ModelAttribute("category" )Category category , @RequestParam("image") MultipartFile image){
        try {
            // حافظ على الصورة القديمة لو مرفعتش جديد
            Category existing = categoryService.findById(category.getId());
            category.setImage_url(existing != null ? existing.getImage_url() : null);

            if (image != null && !image.isEmpty()) {
                Path uploadDir = Paths.get("uploads");
                Files.createDirectories(uploadDir);

                String ext = StringUtils.getFilenameExtension(image.getOriginalFilename());
                String filename = UUID.randomUUID().toString() + (ext != null ? "." + ext : "");
                Path target = uploadDir.resolve(filename);
                Files.copy(image.getInputStream(), target, StandardCopyOption.REPLACE_EXISTING);

                category.setImage_url("/uploads/" + filename);
            }
            categoryService.save(category);
            return "redirect:/admin/categories";
        } catch (Exception e) {
            return "redirect:/admin/categories";
        }
//        categoryService.save(category);
//        return "redirect:/admin/categories";
    }

    @DeleteMapping("/{id}/delete")
    public String deleteCategory(@PathVariable Long id){
        categoryService.delete(id);
        return "redirect:/admin/categories";
    }
}
