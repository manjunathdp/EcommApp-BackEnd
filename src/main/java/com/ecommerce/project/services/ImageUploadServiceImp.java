package com.ecommerce.project.services;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class ImageUploadServiceImp implements ImageUploadService{

    @Override
    public String uploadImage(String path, MultipartFile image) throws IOException {
        String originalFileName = image.getOriginalFilename();
        String randomId = UUID.randomUUID().toString();
        //assert originalFileName != null;
        String imageName = randomId.concat(originalFileName.substring(originalFileName.lastIndexOf('.')));
        String imagePath = path + File.separator + imageName;
        File folder = new File(path);
        if (!folder.exists()) {
            folder.mkdir();
        }
        Files.copy(image.getInputStream(), Paths.get(imagePath));
        return imageName;
    }
}
