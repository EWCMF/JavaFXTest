package test;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.FileInputStream;

public class LabelTest extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("HBox Experiment 1");

        FileInputStream input = new FileInputStream("resources/images/serveimage.png");
        Image image = new Image(input);
        ImageView imageView = new ImageView(image);


        Label label = new Label("A label with custom font set.", imageView);

        label.setFont(new Font("Arial", 24));

        Scene scene = new Scene(label, 200, 100);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
