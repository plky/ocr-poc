package com.plky.ocr.service.impl;

import com.plky.ocr.service.TesseractOCRService;
import lombok.extern.slf4j.Slf4j;
import net.sourceforge.tess4j.Tesseract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.InputStream;

@Service
@Slf4j
public class TesseractOCRServiceImpl implements TesseractOCRService {

    private final Tesseract tesseract;

    public TesseractOCRServiceImpl(@Autowired final Tesseract tesseract) {
        this.tesseract = tesseract;
    }

    @Override
    public String extractText(final InputStream inputStream) {
        try (inputStream) {
            final BufferedImage image = ImageIO.read(inputStream);
            return tesseract.doOCR(image);
        } catch (Exception e) {
            log.error("A problem occurred extracting text - Message: {}",  e.getMessage());
        }
        return "OCR failed";
    }
}
