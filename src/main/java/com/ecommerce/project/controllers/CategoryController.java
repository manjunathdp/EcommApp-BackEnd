package com.ecommerce.project.controllers;

import com.ecommerce.project.models.Category;
import com.ecommerce.project.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@RestController
@RequestMapping("/api")
public class CategoryController {

    @Autowired
    private  CategoryService categoryService;

//    public CategoryController(CategoryService categoryService) {
//        this.categoryService = categoryService;
//    }



    @GetMapping("/public/categories")
    public List<Category> getCategoryList() {
        return categoryService.getCategoryList();
    }


    @PostMapping("/admin/category")
    public String createCategory(@RequestBody Category category) {
        categoryService.createCategory(category);
        return "Category Added Successfully";
    }

    @DeleteMapping("/admin/category/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long id) {
        try {
            String status = categoryService.deleteCategory(id);
            //return new ResponseEntity<>(status, HttpStatus.OK);
            return ResponseEntity.ok(status);
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(e.getReason(),e.getStatusCode());
        }

    }

    @PutMapping("/admin/category/{id}")
    public ResponseEntity<String> updateCategory( @RequestBody Category category , @PathVariable long id) {
        try {
            String status = categoryService.updateCategory(category,id);
            //return new ResponseEntity<>(status, HttpStatus.OK);
            return ResponseEntity.ok(status);
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(e.getReason(),e.getStatusCode());
        }
    }


}
