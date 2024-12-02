package com.ecommerce.project.controllers;

import com.ecommerce.project.models.Category;
import com.ecommerce.project.services.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

//    public CategoryController(CategoryService categoryService) {
//        this.categoryService = categoryService;
//    }


    @GetMapping("/public/categories")
    public List<Category> getCategoryList() {
        return categoryService.getCategoryList();
    }


    @PostMapping("/admin/category")
    public ResponseEntity<String> createCategory(@Valid @RequestBody Category category) {
        //categoryService.createCategory(category);
        return ResponseEntity.ok(categoryService.createCategory(category));
    }

    @DeleteMapping("/admin/category/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long id) {
        //return new ResponseEntity<>(status, HttpStatus.OK);
        return ResponseEntity.ok(categoryService.deleteCategory(id));


    }

    @PutMapping("/admin/category/{id}")
    public ResponseEntity<String> updateCategory(@Valid @RequestBody Category category, @PathVariable long id) {
        //return new ResponseEntity<>(status, HttpStatus.OK);
        return ResponseEntity.ok(categoryService.updateCategory(category, id));

    }


}
