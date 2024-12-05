package com.ecommerce.project.services;

import com.ecommerce.project.exceptions.ResourceNotFoundException;
import com.ecommerce.project.models.Category;
import com.ecommerce.project.models.Product;
import com.ecommerce.project.payload.ProductDTO;
import com.ecommerce.project.repositories.CategoryRepository;
import com.ecommerce.project.repositories.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImp implements ProductService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public ProductDTO addProduct(Long categoryId, Product product) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(()-> new ResourceNotFoundException("Category","categoryId",categoryId));

        product.setImage("default.png");
        product.setCategory(category);
        double specialPrice = product.getPrice() - ((product.getDiscount()*0.01)*product.getPrice());
        product.setSpecialPrice(specialPrice);
        Product savedProduct=productRepository.save(product);
        return modelMapper.map(savedProduct, ProductDTO.class);
    }
}
