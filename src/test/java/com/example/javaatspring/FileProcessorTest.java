package com.example.javaatspring;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FileProcessorTest {

    FileProcessor fileProcessor = new FileProcessor();

    @Test
    void readLineByLineJava8() {
        String text = fileProcessor.readLineByLineJava8("src/test/java/com/example/javaatspring/repository/testText");
        Assertions.assertEquals("Это тестовый текст-файл. Его изменение приведет к падению тестов!\n",text);
    }

    @Test
    void failReadLineByLineJava8() {
        String text = fileProcessor.readLineByLineJava8("src/test/java/com/example/javaatspring/repository/testText")
                + "Кто-то поменял текст. Возможно, криминал!";
        Assertions.assertTrue(!text.equals("Это тестовый текст-файл. Его изменение приведет к падению тестов!\n"));
    }
}