package hoektest.testui.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class MainWindowController {

    @FXML
    Button buttonBeregnOmsaetning, buttonBeregnAfskrivning;

    @FXML
    AnchorPane apPaneHolder;

    public void initialize() {
        buttonBeregnAfskrivning.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                nyAfskrivning();
            }
        });

        buttonBeregnOmsaetning.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                nyOmsaetning();
            }
        });


    }

    public void nyAfskrivning() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AfskrivningPane.fxml"));

        Node node = null;
        try {
            node = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        apPaneHolder.getChildren().setAll(node);
    }

    public void nyOmsaetning() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("OmsaetningPane.fxml"));

        Node node = null;
        try {
            node = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        apPaneHolder.getChildren().setAll(node);
    }
}
