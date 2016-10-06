package ru.rozhin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import ru.rozhin.text.WordsCounter;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Controller {
    @FXML
    private TextArea textInput;

    @FXML
    private Text result;

    @FXML
    protected void analyze(ActionEvent event) {
        HashMap<String, Integer> dictionary = WordsCounter.getDictionaryFromSpeech(textInput.getText());

        Iterator it = dictionary.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            System.out.println(pair.getKey() + " = " + pair.getValue());
        }
    }
}
