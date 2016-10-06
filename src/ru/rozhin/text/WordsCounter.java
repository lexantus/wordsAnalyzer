package ru.rozhin.text;

import java.util.HashMap;

public class WordsCounter {
    public static HashMap<String, Integer> getDictionaryFromSpeech(String input) {
        HashMap<String, Integer> result = new HashMap<>();

        String word = "";
        String letter;

        int n = input.length();
        for (int i = 0; i < n; i++) {
            letter = input.substring(i, i+1);
            if (!letter.equals(",")) {
                word = word.concat(letter);
            } else {
                result.put(word, 1);
            }
        }
        return result;
    }
}
