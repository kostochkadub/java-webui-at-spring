package com.example.javaatspring.serializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class JsonSerializerHashMapStringLong {

    public File serialize(HashMap<String, Long> map, String filename) {
        File file = new File(filename);
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter objectWriter = mapper.writerFor(map.getClass());
        try {
            objectWriter.writeValue(file, map);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }


}
