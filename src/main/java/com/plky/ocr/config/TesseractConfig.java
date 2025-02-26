package com.plky.ocr.config;

import net.sourceforge.tess4j.Tesseract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TesseractConfig {
    @Bean
    Tesseract tesseract() {
        Tesseract tesseract = new Tesseract();
        return tesseract;
    }
}
