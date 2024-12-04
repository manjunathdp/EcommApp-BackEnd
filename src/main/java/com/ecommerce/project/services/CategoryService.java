package com.ecommerce.project.services;

import com.ecommerce.project.models.Category;
import com.ecommerce.project.payload.CategoryDTO;
import com.ecommerce.project.payload.CategoryResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

public interface CategoryService {
    public CategoryResponse getCategoryList(Integer pageNumber, Integer pageSize, String sortBy, String sortOrder);

    public CategoryDTO createCategory(CategoryDTO categoryDTO);

    public CategoryDTO deleteCategory(long id);

    public CategoryDTO updateCategory(CategoryDTO categoryDTO, long id);
}
