package hoektest.afskrivning.mainwindow;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class AfskrivningMainWindowController {

    @FXML
    private Button buttonNyAfskrivning;

    public void initialize() {

    }

    @FXML
    public void nyAfskrivning() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../subwindow/AfskrivningSubWindow.fxml"));
        Stage stage = (Stage) buttonNyAfskrivning.getScene().getWindow();
        Scene newScene = new Scene(root, 640, 400);
        stage.setScene(newScene);
    }
}
