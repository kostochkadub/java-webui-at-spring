package com.example.javaatspring;

import java.util.*;
import java.util.Map.Entry;

public class ResultAggregator {
    // который принимаетString[] words и возвращает WordCountResult, в котором лежит обобщенный результат в виде Map

    //Спасибо coderoad.ru
    private static Map<String, Long> sortByComparator(Map<String, Long> unsortMap, final boolean order) {

        List<Entry<String, Long>> list = new LinkedList<Entry<String, Long>>(unsortMap.entrySet());

        // Sorting the list based on values
        Collections.sort(list, new Comparator<Entry<String, Long>>() {
            public int compare(Entry<String, Long> o1,
                               Entry<String, Long> o2) {
                if (order) {
                    return o1.getValue().compareTo(o2.getValue());
                } else {
                    return o2.getValue().compareTo(o1.getValue());

                }
            }
        });

        // Maintaining insertion order with the help of LinkedList
        Map<String, Long> sortedMap = new LinkedHashMap<String, Long>();
        for (Entry<String, Long> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
    }

    public HashMap<String, Long> getHashMapFromStringArray(String[] words) {
        HashMap<String, Long> wordCountResult = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            Long frequency = wordCountResult.get(words[i]);
            wordCountResult.put(words[i], frequency == null ? 1L : frequency + 1L);
        }
        wordCountResult = (HashMap<String, Long>) sortByComparator(wordCountResult, false);
        wordCountResult.remove(""); //удаляем пустые значения
        return wordCountResult;
    }


}
