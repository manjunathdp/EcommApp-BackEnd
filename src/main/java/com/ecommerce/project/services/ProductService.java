package com.ecommerce.project.services;

import com.ecommerce.project.models.Product;
import com.ecommerce.project.payload.ProductDTO;

public interface ProductService {
    ProductDTO addProduct(Long categoryId, Product product);
}
