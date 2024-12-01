package com.ecommerce.project.services;

import com.ecommerce.project.models.Category;
import com.ecommerce.project.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@Service
public class CategoryServiceImp implements CategoryService {
    //private List<Category> categoryList = new ArrayList<>();
    private long id = 1;
    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<Category> getCategoryList() {
        return categoryRepository.findAll();
    }

    @Override
    public void createCategory(Category category) {
        category.setCategoryId(id++);
        categoryRepository.save(category);
    }

    @Override
    public String deleteCategory(long id) {
        List<Category> categoryList = categoryRepository.findAll();
        Category category = categoryList.stream()
                .filter(c -> c.getCategoryId() == id)
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category with CategoryId: " + id + " not Found"));

        categoryRepository.delete(category);
        return "Category with CategoryId: " + id + " is Deleted Successfully";


    }

    @Override
    public String updateCategory(Category category, long id) {
        // Find the category to update
        Category existingCategory = categoryRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category with CategoryId: " + id + " not Found"));

        // Update the category's fields
        existingCategory.setCategoryName(category.getCategoryName());


        // Save the updated category to the repository
        categoryRepository.save(existingCategory);

        return "Category with CategoryId: " + id + " is Updated Successfully";
    }

}
