package com.example.javaatspring.serializer;

import com.example.javaatspring.FileProcessor;
import com.example.javaatspring.ResultAggregator;
import com.example.javaatspring.WordCounter;
import com.sun.istack.NotNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class JsonSerializerHashMapStringLongTest {

    JsonSerializerHashMapStringLong jsonSerializerHashMapStringLong = new JsonSerializerHashMapStringLong();

    @Test
    void serialize() {

        ResultAggregator resultAggregator = new ResultAggregator();
        String[] testTextArray = getStrings();
        HashMap<String,Long> hashmap = resultAggregator.getHashMapFromStringArray(testTextArray);

        jsonSerializerHashMapStringLong.serialize(hashmap, "testJson.json");
        File file = new File("testJson.json");
        Assertions.assertTrue(file.exists());
    }

    @Test
    void serializeTestBook() {

        FileProcessor fileProcessor = new FileProcessor();
        String text = fileProcessor.readLineByLineJava8("src/test/java/com/example/javaatspring/repository/Dune.txt");

        WordCounter wordCounter = new WordCounter();
        String[] actualTextArray = wordCounter.getStringArrayFromString(text);

        ResultAggregator resultAggregator = new ResultAggregator();

        HashMap<String,Long> hashmap = resultAggregator.getHashMapFromStringArray(actualTextArray);

        jsonSerializerHashMapStringLong.serialize(hashmap, "testJsonDune.json");
        File file = new File("testJsonDune.json");

        Assertions.assertTrue(file.exists());
    }

    @NotNull
    private String[] getStrings() {
        String[] testTextArray = {"i", "am", "grout", "grout", "i", "grout"};
        return testTextArray;
    }
}