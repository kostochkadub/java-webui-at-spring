package com.example.javaatspring.controller;

import com.example.javaatspring.service.WordService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class Controller {

    final
    WordService wordService;

    public Controller(WordService wordService) {
        this.wordService = wordService;
    }

    @GetMapping("/book")
    public HashMap<String, Long> getBookWords(@RequestParam String bookName) {
        return wordService.getBookWords(bookName);
    }
}
