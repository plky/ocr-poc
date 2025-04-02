package com.plky.ocr.service;

import java.io.InputStream;

public interface TesseractOCRService {
    String extractText(final InputStream inputStream);
}
