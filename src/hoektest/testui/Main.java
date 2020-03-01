package hoektest.testui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("view/MainWindow.fxml"));
        stage.setTitle("Afskrivning");
        stage.setScene(new Scene(root, root.getLayoutX(), root.getLayoutY()));
        stage.setResizable(false);
        stage.show();
    }
}