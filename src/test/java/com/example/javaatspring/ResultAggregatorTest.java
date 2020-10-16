package com.example.javaatspring;

import com.sun.istack.NotNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

class ResultAggregatorTest {

    ResultAggregator resultAggregator = new ResultAggregator();

    @Test
    void getHashMapFromStringArray() {
        String[] testTextArray = getStrings();
        HashMap<String, Long> expectedHashmap = getStringLongHashMap();

        HashMap<String,Long> actualHashmap = resultAggregator.getHashMapFromStringArray(testTextArray);

        Assertions.assertEquals(expectedHashmap,actualHashmap);
    }

    @Test
    void getFailHashMapFromStringArray() {
        String[] testTextArray = getStrings();
        //Добавляем неверные данные
        testTextArray[0] = "Хрень";

        HashMap<String, Long> expectedHashmap = getStringLongHashMap();
        HashMap<String,Long> actualHashmap = resultAggregator.getHashMapFromStringArray(testTextArray);

        Assertions.assertTrue(!expectedHashmap.equals(actualHashmap));
    }

    @NotNull
    private String[] getStrings() {
        String[] testTextArray = {"i", "am", "grout", "grout", "i", "grout"};
        return testTextArray;
    }

    @NotNull
    private HashMap<String, Long> getStringLongHashMap() {
        HashMap<String,Long> expectedHashmap = new HashMap<>();
        expectedHashmap.put("i", 2l);
        expectedHashmap.put("am", 1l);
        expectedHashmap.put("grout", 3l);
        return expectedHashmap;
    }
}