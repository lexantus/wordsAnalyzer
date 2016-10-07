package ru.rozhin;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import ru.rozhin.model.WordData;
import ru.rozhin.text.WordsCounter;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Controller {
    @FXML
    private TextArea textInput;

    @FXML
    private TableView tableView;

    @FXML
    protected void analyze(ActionEvent event) {
        HashMap<String, Integer> dictionary = WordsCounter.getDictionaryFromSpeech(textInput.getText());

        ObservableList<WordData> data = FXCollections.observableArrayList();
        Iterator it = dictionary.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            System.out.println(pair.getKey() + " = " + pair.getValue());
            data.add(new WordData((String) pair.getKey(), (Integer) pair.getValue()));
        }
        tableView.setItems(data);
    }
}
