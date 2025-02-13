package com.example.util;

import org.owasp.encoder.Encode;

public class Sanitizer {
    public static String sanitize(String str) {
        if (str == null) {
            return "";
        }

        String allowedChars = str.replaceAll("[^a-zA-Zа-яА-Я0-9\\s@._\\-!&#+]", "");

        return Encode.forHtml(allowedChars);
    }
}
