package com.plky.ocr.service.impl;

import com.plky.ocr.service.TesseractOCRService;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

@Service
public class TesseractOCRServiceImpl implements TesseractOCRService {

    private final Tesseract tesseract;

    public TesseractOCRServiceImpl(@Autowired final Tesseract tesseract) {
        this.tesseract = tesseract;
    }

    @Override
    public String extractText(final InputStream inputStream) throws IOException {
        final BufferedImage image = ImageIO.read(inputStream);
        try (inputStream) {
            return tesseract.doOCR(image);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "failed";
    }
}
