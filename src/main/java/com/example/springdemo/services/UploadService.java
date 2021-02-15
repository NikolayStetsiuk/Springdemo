package com.example.springdemo.services;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

@Component
public interface UploadService {

    void init();

    void store(MultipartFile file);

    Stream<Path> loadAll();

    Path load (String fileName);

    Resource loadAsResource(String filename);

    void deleteAll();

}
