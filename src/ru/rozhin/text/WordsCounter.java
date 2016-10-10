package ru.rozhin.text;

import java.util.HashMap;

public class WordsCounter {
    public static HashMap<String, Integer> getDictionaryFromSpeech(String input) {
        HashMap<String, Integer> result = new HashMap<>();

        String word = "";
        String letter = "";

        int n = input.length();
        for (int i = 0; i < n; i++) {
            letter = input.substring(i, i + 1);
            if (!isDelimeter(letter)) {
                word = word.concat(letter);
            } else {
                addToDictionary(word, result);
                word = "";
            }
        }
        if (!isDelimeter(letter))
            addToDictionary(word, result);
        return result;
    }

    private static void addToDictionary(String word, HashMap<String, Integer> result) {
        if (word.isEmpty()) return;

        if (result.containsKey(word))
            result.put(word, result.get(word) + 1);
        else
            result.put(word, 1);
    }

    private final static String[] delimiters = {",", " ", ".", ";", "-", "?", "!", "\n", "\t", "\r", "'", "\"", "(", ")", "[", "]", "<", ">", ":"};

    private static boolean isDelimeter(String symbol) {
        int n = delimiters.length;
        for (int i = 0; i < n; i++) {
            if (symbol.equals(delimiters[i]))
                return true;
        }
        return false;
    }
}
