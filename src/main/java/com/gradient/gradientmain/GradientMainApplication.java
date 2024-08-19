package com.gradient.gradientmain;

import nu.pattern.OpenCV;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GradientMainApplication {

    public static void main(String[] args) {
        SpringApplication.run(GradientMainApplication.class, args);
        System.out.println("OpenCV version: " + Core.VERSION);
    }
}
