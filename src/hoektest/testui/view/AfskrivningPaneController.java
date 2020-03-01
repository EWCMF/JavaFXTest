package hoektest.testui.view;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AfskrivningPaneController {
    @FXML
    Text textHelp1, textHelp2, textHelp3;

    public void initialize() {
        textHelp1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Stage caller = (Stage) textHelp1.getScene().getWindow();
                MessageBoxController.newMessage("Årlig afskrivning = (anskaffelsesværdi - scrapværdi) / brugstid", caller);
            }
        });
    }
}
