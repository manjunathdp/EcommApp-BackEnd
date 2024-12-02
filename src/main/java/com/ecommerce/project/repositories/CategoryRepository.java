package com.ecommerce.project.repositories;

import com.ecommerce.project.models.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {

    Category findByCategoryName(@NotBlank @Size(min = 3,message = "Category name must contain at least 3 characters") String categoryName);
}
