package com.ecommerce.project.services;

import com.ecommerce.project.models.Category;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@Service
public class CategoryServiceImp implements CategoryService {
    private List<Category> categoryList = new ArrayList<>();
    private long id = 1;

    @Override
    public List<Category> getCategoryList() {
        return categoryList;
    }

    @Override
    public void createCategory(Category category) {
        category.setCategoryId(id++);
        categoryList.add(category);
    }

    @Override
    public String deleteCategory(long id) {
        Category category = categoryList.stream()
                .filter(c -> c.getCategoryId() == id)
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category with CategoryId: " + id + " not Found"));

        categoryList.remove(category);
        return "Category with CategoryId: " + id + " is Deleted Successfully";


    }

    @Override
    public String updateCategory(Category category, long id) {
        Category updateCategory = categoryList.stream()
                .filter(c -> c.getCategoryId() == id)
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category with CategoryId: " + id + " not Found"));
        updateCategory.setCategoryName(category.getCategoryName());

        return "Category with CategoryId: " + id + " is Updated Successfully";

    }
}
