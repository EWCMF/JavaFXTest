package hoektest.testui.view;

import hoektest.testui.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class MessageBoxController {
    private static String message;

    @FXML
    Label labelMessage;

    public static void newMessage(String message, Stage caller) {
        MessageBoxController.message = message;

        Parent root = null;
        try {
            root = FXMLLoader.load(Main.class.getResource("view/MessageBox.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert root != null;
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);

        stage.setResizable(false);
        stage.initOwner(caller);
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initStyle(StageStyle.UTILITY);

        stage.show();
    }

    @FXML
    public void initialize() {
        labelMessage.setText(message);
    }

    @FXML
    public void close() {
        Stage stage = (Stage) labelMessage.getScene().getWindow();
        stage.close();
    }
}
