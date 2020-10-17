package com.example.javaatspring.service;

import com.example.javaatspring.FileProcessor;
import com.example.javaatspring.WordCounter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.validation.constraints.NotNull;
import java.util.HashMap;

class WordServiceTest {

    @Test
    void getBookWords() {
        WordService wordService = new WordService(new FileProcessor(), new WordCounter());

        HashMap<String, Long> bookWords = wordService.getBookWords("src/test/java/com/example/javaatspring/repository/testText");

        HashMap<String, Long> expectedBookWords = getStringLongHashMap();

        Assertions.assertTrue(bookWords.equals(expectedBookWords));
    }

    @NotNull
    private HashMap<String, Long> getStringLongHashMap() {
        HashMap<String, Long> expectedBookWords = new HashMap<>();
        expectedBookWords.put("это", 1L);
        expectedBookWords.put("тестовый", 1L);
        expectedBookWords.put("текстфайл", 1L);
        expectedBookWords.put("его", 1L);
        expectedBookWords.put("изменение", 1L);
        expectedBookWords.put("приведет", 1L);
        expectedBookWords.put("к", 1L);
        expectedBookWords.put("падению", 1L);
        expectedBookWords.put("тестов", 1L);
        return expectedBookWords;
    }
}