package com.plky.ocr.service;

import java.io.IOException;
import java.io.InputStream;

public interface TesseractOCRService {
    String extractText(InputStream inputStream) throws IOException;
}
