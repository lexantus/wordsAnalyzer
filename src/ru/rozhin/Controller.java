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
import ru.rozhin.model.Word;
import ru.rozhin.model.WordData;
import ru.rozhin.text.Words;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Vector;

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
        Vector<Word> words = Words.getWordChain(textInput.getText());
        ObservableList<WordData> data = FXCollections.observableArrayList();

        int n = words.size();
        for (int i = 0; i < n; i++)
            data.add(new WordData(words.get(i).word, words.get(i).count));

        tableView.setItems(data);
    }
}
