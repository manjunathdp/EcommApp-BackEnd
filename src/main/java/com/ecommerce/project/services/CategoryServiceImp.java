package com.ecommerce.project.services;

import com.ecommerce.project.exceptions.APIException;
import com.ecommerce.project.exceptions.ResourceNotFoundException;
import com.ecommerce.project.models.Category;
import com.ecommerce.project.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CategoryServiceImp implements CategoryService {
    //private List<Category> categoryList = new ArrayList<>();
    private long id = 1;
    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<Category> getCategoryList() {
        var categories = categoryRepository.findAll();
        if (categories.isEmpty()) {
            throw new APIException("Categories Not Added Yet!!!!!!!! ");
        }
        return categoryRepository.findAll();
    }

    @Override
    public void createCategory(Category category) {
        Category savedCategory = categoryRepository.findByCategoryName(category.getCategoryName());
        if (savedCategory != null) {
            throw new APIException("Category with name "+category.getCategoryName()+" already Exists");
        }
        category.setCategoryId(id++);
        categoryRepository.save(category);
    }

    @Override
    public String deleteCategory(long id) {
        List<Category> categoryList = categoryRepository.findAll();
        Category category = categoryList.stream()
                .filter(c -> c.getCategoryId() == id)
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("Category","categoryId",id));

        categoryRepository.delete(category);
        return "Category with CategoryId: " + id + " is Deleted Successfully";


    }

    @Override
    public String updateCategory(Category category, long id) {
        Category savedCategory = categoryRepository.findByCategoryName(category.getCategoryName());
        if (savedCategory != null) {
            throw new APIException("Category with name "+category.getCategoryName()+" already Exists");
        }
        // Find the category to update
        Category existingCategory = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category","categoryId",id));

        // Update the category's fields
        existingCategory.setCategoryName(category.getCategoryName());


        // Save the updated category to the repository
        categoryRepository.save(existingCategory);

        return "Category with CategoryId: " + id + " is Updated Successfully";
    }

}
