package ru.rozhin;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import ru.rozhin.model.WordData;
import ru.rozhin.text.WordsCounter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Controller {
    @FXML
    private TextArea textInput;

    @FXML
    private TableView tableView;

    @FXML
    private ImageView userPhoto;

    @FXML
    protected void photoDragged(DragEvent event) {
        Dragboard db = event.getDragboard();
        boolean success = false;
        if (db.hasFiles()) {
            success = true;
            final File file = db.getFiles().get(0);
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    try {
                        Image img = new Image(new FileInputStream(file.getAbsolutePath()));
                        userPhoto.setImage(img);
                    } catch (FileNotFoundException ex) {

                    }
                }
            });
        }
        event.setDropCompleted(success);
        event.consume();
    }

    @FXML
    protected void photoDraggedOver(DragEvent event) {
        Dragboard db = event.getDragboard();
        if (db.hasFiles()) {
            event.acceptTransferModes(TransferMode.COPY);
        } else {
            event.consume();
        }
    }

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
