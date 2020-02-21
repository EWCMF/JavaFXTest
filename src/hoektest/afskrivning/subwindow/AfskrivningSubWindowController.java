package hoektest.afskrivning.subwindow;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class AfskrivningSubWindowController {

    @FXML
    private Button buttonTilbage;

    public void initialize() {

    }

    @FXML
    private void tilbage() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../mainwindow/AfskrivningMainWindow.fxml"));
        Stage stage = (Stage) buttonTilbage.getScene().getWindow();
        Scene newScene = new Scene(root, 270, 400);
        stage.setScene(newScene);
    }
}
