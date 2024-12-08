package com.ecommerce.project.services;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ImageUploadService {
    String uploadImage(String path, MultipartFile image) throws IOException;
}