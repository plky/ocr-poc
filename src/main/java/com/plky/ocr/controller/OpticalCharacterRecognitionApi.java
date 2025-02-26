package com.plky.ocr.controller;

import com.plky.ocr.service.TesseractOCRService;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class OpticalCharacterRecognitionApi {

    private TesseractOCRService tesseractOCRService;

    public OpticalCharacterRecognitionApi(@Autowired final TesseractOCRService tesseractOCRService) {
        this.tesseractOCRService = tesseractOCRService;
    }

    @PostMapping("/ocr/convert")
    public String ocr(
        @RequestParam("file")
        @NotNull
        final MultipartFile file
    ) throws IOException {
        return tesseractOCRService.extractText(file.getInputStream());
    }
}
