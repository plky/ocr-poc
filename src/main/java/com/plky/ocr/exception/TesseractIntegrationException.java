package com.plky.ocr.exception;

import lombok.Getter;

@Getter
public class TesseractIntegrationException extends RuntimeException {
    public TesseractIntegrationException() {
        super("Tesseract integration exception");
    }
}
