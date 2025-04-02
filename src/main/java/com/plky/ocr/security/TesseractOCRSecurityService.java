package com.plky.ocr.security;

import org.springframework.web.multipart.MultipartFile;

public interface TesseractOCRSecurityService {
    boolean canConvert(final MultipartFile file);
}
