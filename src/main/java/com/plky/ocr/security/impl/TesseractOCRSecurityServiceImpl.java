package com.plky.ocr.security.impl;

import com.plky.ocr.security.TesseractOCRSecurityService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Objects;

@Service
public class TesseractOCRSecurityServiceImpl implements TesseractOCRSecurityService {
    @Override
    public boolean canConvert(final MultipartFile file) {
        return Objects.nonNull(file);
    }
}
