package com.gradient.gradientmain.service;

import org.jetbrains.annotations.NotNull;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
public class ImageProcessingService {

    private static final String UPLOAD_DIR = "C:\\Users\\Kieran McDougall\\IdeaProjects\\gradient-main\\src\\main\\resources\\images";

    public String saveImage(@NotNull MultipartFile file) throws IOException {
        String filename = file.getOriginalFilename();
        Path path = Paths.get(UPLOAD_DIR + filename);
        Files.createDirectories(path.getParent());
        Files.write(path, file.getBytes());
        return filename;
    }

    public void analyzeColors(String filename) {
        Mat image = loadImage(filename);
        // TODO: Implement color analysis using OpenCV
        // This method should extract dominant colors and store the results
    }

    private Mat loadImage(String filename) {
        return Imgcodecs.imread(UPLOAD_DIR + filename);
    }

    public List<String> getGradientImages() {
        // TODO: Implement logic to return list of image filenames in gradient order
        return new ArrayList<>();
    }

    public void organizeGradient() {
        // TODO: Implement gradient organization logic
        // This method should use the color analysis results to order the images
    }

    // TODO: Add method for gradient download/export
}