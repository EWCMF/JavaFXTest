package hoektest.afskrivning.view.subwindow;

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
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class AfskrivningSubWindowController {
    private Scene previousScene;
    private NodeController nodeController = new NodeController();

    @FXML
    private Button buttonTilbage, buttonUdregn;

    @FXML
    private TextField tfNavn;

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
//        Parent root = FXMLLoader.load(getClass().getResource("../mainwindow/AfskrivningMainWindow.fxml"));
        Stage stage = (Stage) buttonTilbage.getScene().getWindow();
//        Scene newScene = new Scene(root, 270, 400);
        stage.setScene(previousScene);
    }

    private void loadAllNodes() throws IOException {
        FXMLLoader loader1 = new FXMLLoader(getClass().getResource("../subwindow/LinearMetodeNode.fxml"));
        loader1.setController(nodeController);
        node1 = loader1.load();

        FXMLLoader loader2 = new FXMLLoader(getClass().getResource("../subwindow/SaldoMetodeNode.fxml"));
        loader2.setController(nodeController);
        node2 = loader2.load();

        FXMLLoader loader3 = new FXMLLoader(getClass().getResource("../subwindow/StraksAfskrivningNode.fxml"));
        loader3.setController(nodeController);
        node3 = loader3.load();
    }

    @FXML
    private void calculate() {
        if (choiceBoxMetode.getValue() != null) {
            switch (choiceBoxMetode.getValue()) {
                case "Lineær metode":
                    linearMetode();
                    break;
                case "Saldometode":
                    saldoMetode();
                    break;
                case "Straksafskrivning":
                    straksMetode();
                    break;
            }
        }
        else {
            System.out.println("Vælg en metode først.");
        }
    }

    private void linearMetode() {
        String afskrivning = "Årlig afskrivning = ";
        double anskaf = nodeController.getTfAnskaf();
        double skrap = nodeController.getTfSkrap();
        double brugstid = nodeController.getTfBrugs();
        double udregning = (anskaf - skrap) / brugstid;
        System.out.println(afskrivning + udregning);
    }
    private void saldoMetode() {
        String afskrivning = "Årlig afskrivning = ";
        double nutids = nodeController.getTfNutids();
        double procent = nodeController.getTfProcent();
        double udregning = (nutids * procent) / 100;
        System.out.println(afskrivning + udregning);

    }
    private void straksMetode() {
        String afskrivning = "Årlig afskrivning = ";
        double straks = nodeController.getTfStraks();
        System.out.println(afskrivning + straks);
    }

    public void setPreviousScene(Scene previousScene) {
        this.previousScene = previousScene;
    }
}
