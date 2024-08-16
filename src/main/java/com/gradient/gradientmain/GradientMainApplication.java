package com.gradient.gradientmain;

import org.opencv.core.Core;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GradientMainApplication {

    public static void main(String[] args) {
        SpringApplication.run(GradientMainApplication.class, args);
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }
}
