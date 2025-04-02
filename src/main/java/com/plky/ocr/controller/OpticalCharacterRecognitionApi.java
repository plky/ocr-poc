package com.plky.ocr.controller;

import com.plky.ocr.exception.NotAuthorisedException;
import com.plky.ocr.security.TesseractOCRSecurityService;
import com.plky.ocr.service.TesseractOCRService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import static com.plky.ocr.utils.ExceptionUtils.throwIfFalse;

@RestController
@Slf4j
public class OpticalCharacterRecognitionApi {

    private final TesseractOCRService tesseractOCRService;
    private final TesseractOCRSecurityService tesseractOCRSecurityService;

    public OpticalCharacterRecognitionApi(@Autowired final TesseractOCRService tesseractOCRService,
                                          @Autowired final TesseractOCRSecurityService tesseractOCRSecurityService) {
        this.tesseractOCRService = tesseractOCRService;
        this.tesseractOCRSecurityService = tesseractOCRSecurityService;
    }

    @PostMapping("/ocr/convert-to-text")
    public String ocr(
        @RequestParam("file")
        @NotNull
        @Valid
        final MultipartFile file
    ) throws Exception {

        throwIfFalse(
            NotAuthorisedException::new,
            tesseractOCRSecurityService.canConvert(file)
        );

        return tesseractOCRService.extractText(file.getInputStream());
    }
}
