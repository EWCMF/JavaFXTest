package hoektest.afskrivning;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("mainwindow/AfskrivningMainWindow.fxml"));
        stage.setTitle("Afskrivning");
        stage.setScene(new Scene(root, 270, 400));
        stage.show();
    }
}
