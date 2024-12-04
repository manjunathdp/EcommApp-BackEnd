package com.ecommerce.project.controllers;

import com.ecommerce.project.models.Category;
import com.ecommerce.project.payload.CategoryDTO;
import com.ecommerce.project.payload.CategoryResponse;
import com.ecommerce.project.services.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

//    public CategoryController(CategoryService categoryService) {
//        this.categoryService = categoryService;
//    }


    @GetMapping("/public/categories")
    public ResponseEntity<CategoryResponse> getCategoryList() {
        return ResponseEntity.ok(categoryService.getCategoryList());
    }


    @PostMapping("/admin/category")
    public ResponseEntity<CategoryDTO> createCategory(@Valid @RequestBody CategoryDTO categoryDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.createCategory(categoryDTO));

    }

    @DeleteMapping("/admin/category/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long id) {
        //return new ResponseEntity<>(status, HttpStatus.OK);
        return ResponseEntity.ok(categoryService.deleteCategory(id));


    }

    @PutMapping("/admin/category/{id}")
    public ResponseEntity<CategoryDTO> updateCategory(@Valid @RequestBody CategoryDTO categoryDTO, @PathVariable long id) {
        //return new ResponseEntity<>(status, HttpStatus.OK);
        return ResponseEntity.ok(categoryService.updateCategory(categoryDTO, id));

    }


}
