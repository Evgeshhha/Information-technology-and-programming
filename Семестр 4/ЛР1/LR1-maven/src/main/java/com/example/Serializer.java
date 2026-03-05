package com.example;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Serializer {
    private static final ObjectMapper mapper = new ObjectMapper();

    public static String toJson(Monster monster) throws Exception {
        return mapper.writeValueAsString(monster);
    }

    public static <T> T fromJson(String json, Class<T> clazz) throws Exception {
        return mapper.readValue(json, clazz);
    }
}