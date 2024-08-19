package com.gradient.gradientmain.controller;

import com.gradient.gradientmain.service.ImageProcessingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/images")
public class ImageProcessingController {

    private final ImageProcessingService imageProcessingService;

    public ImageProcessingController(ImageProcessingService imageProcessingService) {
        this.imageProcessingService = imageProcessingService;
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) {
        try {
            String filename = imageProcessingService.saveImage(file);
            imageProcessingService.analyzeColors(filename);
            return ResponseEntity.ok("Image uploaded and analyzed successfully: " + filename);
        } catch (IOException e) {
            return ResponseEntity.badRequest().body("Failed to upload image: " + e.getMessage());
        }
    }

    @GetMapping("/gradient")
    public ResponseEntity<List<String>> getImageGradient() {
        List<String> gradientImages = imageProcessingService.getGradientImages();
        return ResponseEntity.ok(gradientImages);
    }

    @PostMapping("/organize")
    public ResponseEntity<String> organizeGradient() {
        imageProcessingService.organizeGradient();
        return ResponseEntity.ok("Gradient organized successfully");
    }

    @GetMapping("/download")
    public ResponseEntity<byte[]> downloadGradient() {
        // Implement download logic
        // Return image data with appropriate headers
        return ResponseEntity.ok().body(new byte[0]); // Placeholder
    }
}