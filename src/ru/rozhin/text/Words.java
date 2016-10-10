package ru.rozhin.text;

import ru.rozhin.model.Word;

import java.util.Vector;

public class Words {

    public static Vector<Word> getWordChain(String text) {
        return parseText(text);
    }

    private static Vector<Word> parseText(String text) {
        Vector<Word> words = new Vector<>();
        String wordStr = "";
        String letter = "";

        int n = text.length();
        for (int i = 0; i < n; i++) {
            letter = text.substring(i, i + 1);
            if (!isDelimeter(letter)) {
                wordStr = wordStr.concat(letter);
            } else {
                addToVector(wordStr, words);
                wordStr = "";
            }
        }
        if (!isDelimeter(letter))
            addToVector(wordStr, words);

        return words;
    }

    private static void addToVector(String wordStr, Vector<Word> result) {
        if (wordStr.isEmpty()) return;

        int wordIndex = getWordIndex(wordStr, result);

        if (wordIndex == -1) {
            Word word = new Word(wordStr, 1);
            result.add(word);
        } else {
            result.get(wordIndex).count++;
        }
    }

    private static int getWordIndex(String word, Vector<Word> result) {
        int n = result.size();
        for (int i = 0; i < n; i++) {
            if (result.get(i).word.equals(word))
                return i;
        }
        return -1;
    }

    private final static String[] delimiters = {",", " ", ".", ";", "-", "?", "!", "\n", "\t", "\r", "'", "\"", "(", ")", "[", "]", "<", ">", ":", "{", "}"};

    private static boolean isDelimeter(String symbol) {
        int n = delimiters.length;
        for (int i = 0; i < n; i++) {
            if (symbol.equals(delimiters[i]))
                return true;
        }
        return false;
    }
}
