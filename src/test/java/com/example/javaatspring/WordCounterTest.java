package com.example.javaatspring;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class WordCounterTest {

    WordCounter wordCounter = new WordCounter();

    @Test
    void getStringArrayFromString() {
        String text = "I am Grout!";
        String[] expectedTextArray = {"i", "am", "grout"};
        String[] actualTextArray = wordCounter.getStringArrayFromString(text);

        Assertions.assertTrue(Arrays.equals(expectedTextArray, actualTextArray));
    }

}