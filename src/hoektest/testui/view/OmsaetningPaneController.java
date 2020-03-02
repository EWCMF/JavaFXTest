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

public class OmsaetningPaneController {
    @FXML
    Text textHelp1, textHelp2, textHelp3;

    @FXML
    Button buttonProcent, buttonBruttoVare, buttonAfsaetningSalgspris;

    @FXML
    AnchorPane apMetodeHolder;

    public void initialize() {
        textHelp1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Stage caller = (Stage) textHelp1.getScene().getWindow();
                MessageBoxController.newMessage("Omsætning = Primo år omsætning * procentstigning", caller);
            }
        });
        textHelp2.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Stage caller = (Stage) textHelp2.getScene().getWindow();
                MessageBoxController.newMessage("Omsætning = bruttofortjeneste + vareforbrug", caller);
            }
        });
        textHelp3.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Stage caller = (Stage) textHelp3.getScene().getWindow();
                MessageBoxController.newMessage("Omsætning = afsætning * salgspris", caller);
            }
        });
    }

    public void procentValgt() throws IOException {
        Node node = FXMLLoader.load(getClass().getResource("OmsaetningPaneProcent.fxml"));
        apMetodeHolder.getChildren().setAll(node);
    }

    public void bruttofortjenesteOgVareforbrugValgt() throws IOException {
        Node node = FXMLLoader.load(getClass().getResource("OmsaetningPaneBruttofortjenesteVareforbrug.fxml"));
        apMetodeHolder.getChildren().setAll(node);
    }

    public void afsaetningOgSalgspris() throws IOException {
        Node node = FXMLLoader.load(getClass().getResource("OmsaetningPaneAfsaetningSalgspris.fxml"));
        apMetodeHolder.getChildren().setAll(node);
    }
}
