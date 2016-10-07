package ru.rozhin.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class WordData {
    private final SimpleStringProperty word = new SimpleStringProperty("");
    private final SimpleIntegerProperty count = new SimpleIntegerProperty();

    public WordData(String word, Integer count) {
        setWord(word);
        setCount(count);
    }

    public void setWord(String value) {
        word.set(value);
    }

    public void setCount(Integer value) {
        count.set(value);
    }

    public String getWord() {
        return word.get();
    }

    public Integer getCount() {
        return count.get();
    }
}
