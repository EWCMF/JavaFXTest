package hoektest.testui.view;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class AfskrivningPaneController {
    @FXML
    Text textHelp1, textHelp2, textHelp3;

    @FXML
    Button buttonLinear, buttonSaldo, buttonStraks;

    @FXML
    AnchorPane apMetodeHolder;

    public void initialize() {
        textHelp1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Stage caller = (Stage) textHelp1.getScene().getWindow();
                MessageBoxController.newMessage("Årlig afskrivning = (anskaffelsesværdi - scrapværdi) / brugstid", caller);
            }
        });
        textHelp2.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Stage caller = (Stage) textHelp2.getScene().getWindow();
                MessageBoxController.newMessage("Årlig afskrivning = anskaffelsesværdi * afskrivningsprocent", caller);
            }
        });
        textHelp3.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Stage caller = (Stage) textHelp3.getScene().getWindow();
                MessageBoxController.newMessage("Hvis beløbet er under 14200 kr. uden moms kan det afskrives straks", caller);
            }
        });
    }

    public void linearMetodeValgt() throws IOException {
        Node node = FXMLLoader.load(getClass().getResource("AfskrivningPaneLinear.fxml"));
        apMetodeHolder.getChildren().setAll(node);
    }

    public void saldoMetodeValgt() throws IOException {
        Node node = FXMLLoader.load(getClass().getResource("AfskrivningPaneSaldo.fxml"));
        apMetodeHolder.getChildren().setAll(node);
    }

    public void straksMetodeValgt() throws IOException {
        Node node = FXMLLoader.load(getClass().getResource("AfskrivningPaneStraks.fxml"));
        apMetodeHolder.getChildren().setAll(node);
    }
}
