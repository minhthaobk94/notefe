package com.thaontm.project.notefeapp.backend.utils;

import java.util.ArrayList;
import java.util.List;

public class StringUtils {
    private static StringUtils instance;

    private StringUtils() {
    }

    public static StringUtils getInstance() {
        if (instance == null) {
            instance = new StringUtils();
        }
        return instance;
    }

    public List<String> breakPostToSegments(final String content) {
        final List<String> result = new ArrayList<>();
        if (!org.apache.commons.lang3.StringUtils.isEmpty(content)) {
            final String[] tokens = content.split(Character.toString((char) 32));
            for (final String token : tokens) {
                if (!org.apache.commons.lang3.StringUtils.isEmpty(token)) {
                    result.add(token.trim());
                }
            }
        }
        return result;
    }
}
