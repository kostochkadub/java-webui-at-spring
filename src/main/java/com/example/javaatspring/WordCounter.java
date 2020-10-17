package com.example.javaatspring;

import org.springframework.stereotype.Service;

@Service
public class WordCounter {

    public WordCounter() {
    }

    public String[] getStringArrayFromString(String strings) {
        String[] words = strings.split("\\s");
        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].toLowerCase();
            words[i] = words[i].replaceAll("[^a-zа-я0-9ё]", "");
        }
        return words;
    }

}
