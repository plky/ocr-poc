package com.plky.ocr.utils;

import lombok.experimental.UtilityClass;

import java.util.function.Supplier;

@UtilityClass
public class ExceptionUtils {
    public static <T extends Exception> void throwIfTrue(
        final Supplier<T> supplier,
        final boolean doThrow
    ) throws T {
        if (doThrow) {
            throw supplier.get();
        }
    }

    public static <T extends Exception> void throwIfFalse(
        final Supplier<T> supplier,
        final boolean doNotThrow
    ) throws T {
        throwIfTrue(supplier, !doNotThrow);
    }
}
