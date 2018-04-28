package com.thaontm.project.notefeapp.backend.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public final class GsonUtils {
    private static Gson gson;

    private GsonUtils() {
    }

    public static Gson getGson() {
        if (gson == null) {
            gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        }
        return gson;
    }
}
