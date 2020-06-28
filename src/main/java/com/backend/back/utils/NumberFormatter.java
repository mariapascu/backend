package com.backend.back.utils;

public class NumberFormatter {
    public static Number getNumber(Float n) {
        if (n == Math.round(n)) {
            return n.intValue();
        }
        return n;
    }
}
