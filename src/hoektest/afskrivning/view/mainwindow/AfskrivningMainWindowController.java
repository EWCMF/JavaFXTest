package hoektest.afskrivning.view.mainwindow;

import hoektest.afskrivning.view.subwindow.AfskrivningSubWindowController;
import hoektest.afskrivning.viewmodel.PresentedModel;
import hoektest.afskrivning.viewmodel.Presenter;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;

public class AfskrivningMainWindowController {
    private Presenter presenter;

    @FXML
    private Button buttonNyAfskrivning;

    @FXML
    private TableView<PresentedModel> tvAfskrivninger;

    public void initialize() {
        if (presenter == null) {
            presenter = new Presenter();
            System.out.println("test");
            tvAfskrivninger.setItems(presenter.getPresentedList());
        }
    }

    @FXML
    public void nyAfskrivning() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../subwindow/AfskrivningSubWindow.fxml"));
        Parent root = loader.load();

        AfskrivningSubWindowController controller = loader.getController();
        Scene scene = buttonNyAfskrivning.getScene();
        controller.setPreviousScene(scene);

        Stage stage = (Stage) buttonNyAfskrivning.getScene().getWindow();
        Scene newScene = new Scene(root, 470, 670);
        stage.setScene(newScene);
    }
}
