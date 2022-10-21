package com.sovadeveloper.numbers.controller;

import com.sovadeveloper.numbers.service.FileUploadService;
import com.sovadeveloper.numbers.service.NumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/numbers")
public class NumberController {

    private final FileUploadService fileUploadService;
    private final NumberService numberService;

    @Autowired
    public NumberController(FileUploadService fileUploadService, NumberService numberService) {
        this.fileUploadService = fileUploadService;
        this.numberService = numberService;
    }

    @PostMapping("/upload")
    public @ResponseBody
    ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file){
        try {
            return ResponseEntity.ok(fileUploadService.uploadFile(file));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Не удалось загрузить файл");
        }
    }

    @GetMapping("/get_max_value")
    public ResponseEntity getMaxNumber(){
        try {
            return ResponseEntity.ok(numberService.getMaxNumber());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @GetMapping("/get_min_value")
    public ResponseEntity getMinNumber(){
        try {
            return ResponseEntity.ok(numberService.getMinNumber());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("error");
        }
    }

    @GetMapping("/get_median")
    public ResponseEntity getMedian(){
        try {
            return ResponseEntity.ok(numberService.getMedian());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("error");
        }
    }

    @GetMapping("/get_average")
    public ResponseEntity getAverage(){
        try {
            return ResponseEntity.ok(numberService.getAverage());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("error");
        }
    }

    @GetMapping("/get_increasing_sequence")
    public ResponseEntity getIncreasingSequence(){
        try {
            return ResponseEntity.ok(numberService.getIncreasingSequence());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("error");
        }
    }

    @GetMapping("/get_decreasing_sequence")
    public ResponseEntity getDecreasingSequence(){
        try {
            return ResponseEntity.ok(numberService.getDecreasingSequence());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("error");
        }
    }
}
