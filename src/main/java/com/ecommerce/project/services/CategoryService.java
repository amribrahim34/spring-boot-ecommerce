package com.ecommerce.project.services;

import com.ecommerce.project.entities.Category;
import com.ecommerce.project.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ServiceInterface<Category> {

    public CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(Long theId) {
        return categoryRepository.findById(theId)
                .orElseThrow(() -> new RuntimeException("Category not found: " + theId));
    }

    @Override
    public Category save(Category entity) {
        return categoryRepository.save(entity);
    }

    @Override
    public void delete(Long theId) {
        categoryRepository.deleteById(theId);
    }
}
