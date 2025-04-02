package com.plky.ocr.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartException;

import java.util.Arrays;

@Slf4j
@ControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(MultipartException.class)
    public  ResponseEntity<Object> handleMultipartException(final MultipartException ex) {
        logError(ex);
        return getErrorResponse(HttpStatus.BAD_REQUEST, ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> exceptionHandler(final Exception ex) {
        logError(ex);
        return getErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, "An internal server error occurred");
    }

    @ExceptionHandler(NotAuthorisedException.class)
    public ResponseEntity<Object> notAuthorisedException(final NotAuthorisedException ex) {
        logError(ex);
        return getErrorResponse(HttpStatus.UNAUTHORIZED, ex.getMessage());
    }

    @ExceptionHandler(TesseractIntegrationException.class)
    public ResponseEntity<Object> exceptionHandler(final TesseractIntegrationException ex) {
        logError(ex);
        return getErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
    }

    public void logError(final Exception ex) {
        log.error("Exception Occurred: " + ex.getMessage() + " - " + Arrays.toString(ex.getStackTrace()));
    }

    private ResponseEntity<Object> getErrorResponse(final HttpStatus status, final String message) {
        final ApiError apiError = new ApiError(status, message);
        return new ResponseEntity<>(apiError, new HttpHeaders(), status);
    }
}
