package com.plky.ocr.exception;

public class NotAuthorisedException extends RuntimeException{
    public NotAuthorisedException() {
        super("Not Authorised to perform this action");
    }
}
