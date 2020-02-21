package hoektest.afskrivning.subwindow;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class AfskrivningSubWindowController {

    @FXML
    private Button buttonTilbage;

    @FXML
    private ChoiceBox<String> choiceBoxMetode;

    @FXML
    private VBox vBoxSubWindow;

    private Node node1;
    private Node node2;
    private Node node3;

    public void initialize() throws IOException {
        loadAllNodes();
        ObservableList<String> items = FXCollections.observableArrayList("Lineær metode", "Saldometode", "Straksafskrivning");
        choiceBoxMetode.setItems(items);
        choiceBoxMetode.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                switch (choiceBoxMetode.getValue()) {
                    case "Lineær metode":
                        vBoxSubWindow.getChildren().removeAll(node1, node2, node3);
                        vBoxSubWindow.getChildren().add(node1);
                        break;
                    case "Saldometode":
                        vBoxSubWindow.getChildren().removeAll(node1, node2, node3);
                        vBoxSubWindow.getChildren().add(node2);
                        break;
                    case "Straksafskrivning":
                        vBoxSubWindow.getChildren().removeAll(node1, node2, node3);
                        vBoxSubWindow.getChildren().add(node3);
                        break;
                }
            }
        });
    }

    @FXML
    private void tilbage() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../mainwindow/AfskrivningMainWindow.fxml"));
        Stage stage = (Stage) buttonTilbage.getScene().getWindow();
        Scene newScene = new Scene(root, 270, 400);
        stage.setScene(newScene);
    }

    private void loadAllNodes() throws IOException {
        node1 = FXMLLoader.load(getClass().getResource("../subwindow/LinearMetodeNode.fxml"));
        node2 = FXMLLoader.load(getClass().getResource("../subwindow/SaldoMetodeNode.fxml"));
        node3 = FXMLLoader.load(getClass().getResource("../subwindow/StraksAfskrivningNode.fxml"));
    }
}
