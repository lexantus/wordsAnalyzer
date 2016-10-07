package ru.rozhin.model;

import javafx.beans.property.SimpleStringProperty;

public class WordData {
    private final SimpleStringProperty word = new SimpleStringProperty("");
    private final SimpleStringProperty count = new SimpleStringProperty("");

    public WordData(String word, Integer count) {
        setWord(word);
        setCount(count);
    }

    public void setWord(String value) {
        word.set(value);
    }

    public void setCount(Integer value) {
        count.set(value.toString());
    }

    public String getWord() {
        return word.get();
    }

    public String getCount() {
        return count.get();
    }
}
