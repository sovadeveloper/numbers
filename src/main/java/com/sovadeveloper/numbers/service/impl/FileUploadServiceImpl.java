package com.sovadeveloper.numbers.service.impl;

import com.sovadeveloper.numbers.property.StorageProperty;
import com.sovadeveloper.numbers.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Service
public class FileUploadServiceImpl implements FileUploadService {

    private final StorageProperty storageProperty;

    @Autowired
    public FileUploadServiceImpl(StorageProperty storageProperty) {
        this.storageProperty = storageProperty;
    }

    @Override
    public String uploadFile(MultipartFile file) throws IOException {
        if (file != null) {
            File uploadPackage = new File("uploads");
            if (!uploadPackage.exists()) {
                uploadPackage.mkdir();
            }
            byte[] bytes = file.getBytes();
            BufferedOutputStream stream =
                    new BufferedOutputStream(new FileOutputStream(storageProperty.getUploadDirectory()
                            + file.getOriginalFilename()));
            stream.write(bytes);
            stream.close();
        }
        return file.getOriginalFilename();
    }
}
