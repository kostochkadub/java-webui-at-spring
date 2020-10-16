package com.example.javaatspring.service;

import com.example.javaatspring.FileProcessor;
import com.example.javaatspring.ResultAggregator;
import com.example.javaatspring.WordCounter;
import com.example.javaatspring.serializer.JsonSerializerHashMapStringLong;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.HashMap;

@Service
public class WordService {

    FileProcessor fileProcessor = new FileProcessor();
    WordCounter wordCounter = new WordCounter();
    JsonSerializerHashMapStringLong jsonSerializerHashMapStringLong = new JsonSerializerHashMapStringLong();

    public HashMap<String, Long> getBookWords(String bookName) {

        String text = fileProcessor.readLineByLineJava8(bookName);
        String[] actualTextArray = wordCounter.getStringArrayFromString(text);
        ResultAggregator resultAggregator = new ResultAggregator();
        HashMap<String, Long> hashmap = resultAggregator.getHashMapFromStringArray(actualTextArray);

        return hashmap;
    }
}
