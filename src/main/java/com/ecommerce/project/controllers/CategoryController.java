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

import static com.ecommerce.project.config.AppConstants.*;


@RestController
@RequestMapping("/api")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

//    public CategoryController(CategoryService categoryService) {
//        this.categoryService = categoryService;
//    }


    @GetMapping("/public/categories")
    public ResponseEntity<CategoryResponse> getCategoryList(@RequestParam(name = "pageNumber", defaultValue = DEFAULT_PAGE_NUMBER, required = false) Integer pageNumber,
                                                            @RequestParam(name = "pageSize", defaultValue = DEFAULT_PAGE_SIZE, required = false) Integer pageSize,
                                                            @RequestParam(name = "sortBy", defaultValue = DEFAULT_SORT_BY, required = false) String sortBy,
                                                            @RequestParam(name = "sortOrder", defaultValue = DEFAULT_SORT_ORDER, required = false) String sortOrder) {
        return ResponseEntity.ok(categoryService.getCategoryList(pageNumber,pageSize,sortBy,sortOrder));
    }


    @PostMapping("/admin/category")
    public ResponseEntity<CategoryDTO> createCategory(@Valid @RequestBody CategoryDTO categoryDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.createCategory(categoryDTO));

    }

    @DeleteMapping("/admin/category/{id}")
    public ResponseEntity<CategoryDTO> deleteCategory(@PathVariable Long id) {
        //return new ResponseEntity<>(status, HttpStatus.OK);
        return ResponseEntity.ok(categoryService.deleteCategory(id));


    }

    @PutMapping("/admin/category/{id}")
    public ResponseEntity<CategoryDTO> updateCategory(@Valid @RequestBody CategoryDTO categoryDTO, @PathVariable long id) {
        //return new ResponseEntity<>(status, HttpStatus.OK);
        return ResponseEntity.ok(categoryService.updateCategory(categoryDTO, id));

    }


}
