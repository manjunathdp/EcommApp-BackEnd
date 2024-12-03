package com.ecommerce.project.services;

import com.ecommerce.project.models.Category;
import com.ecommerce.project.payload.CategoryResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

public interface CategoryService {
    public CategoryResponse getCategoryList();
    public String createCategory(Category category);

    public String deleteCategory(long id);
    public String updateCategory( Category category , long id);
}
