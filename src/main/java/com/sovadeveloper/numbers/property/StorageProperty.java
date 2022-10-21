package com.sovadeveloper.numbers.property;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.nio.file.Paths;

@Configuration
@Getter
@Setter
public class StorageProperty {
    @Value("${upload.directory}")
    private String path;

    private String uploadDirectory;

    @PostConstruct
    private void init(){
        uploadDirectory = Paths.get("").toAbsolutePath() + path;
    }
}
