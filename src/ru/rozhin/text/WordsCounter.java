package ru.rozhin.text;

import java.util.HashMap;

public class WordsCounter {
    public static HashMap<String, Integer> getDictionaryFromSpeech(String input) {
        HashMap<String, Integer> result = new HashMap<>();

        String word = "";
        String letter;

        int n = input.length();
        for (int i = 0; i < n; i++) {
            letter = input.substring(i, i + 1);
            if (!isDelimeter(letter)) {
                word = word.concat(letter);
            } else {
                if (result.containsKey(word))
                    result.put(word, result.get(word) + 1);
                else
                    result.put(word, 1);
                word = "";
            }
        }
        return result;
    }

    private final static String[] delimiters = {",", " ", ".", ";", "-", "?", "!"};

    private static boolean isDelimeter(String symbol) {
        int n = delimiters.length;
        for (int i = 0; i < n; i++) {
            if (symbol.equals(delimiters[i]))
                return true;
        }
        return false;
    }
}
