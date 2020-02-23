package hoektest.afskrivning.view.mainwindow;

import hoektest.afskrivning.view.subwindow.AfskrivningSubWindowController;
import hoektest.afskrivning.viewmodel.PresentedModel;
import hoektest.afskrivning.viewmodel.Presenter;
import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class AfskrivningMainWindowController {
    private Presenter presenter;

    @FXML
    private Button buttonNyAfskrivning;

    @FXML
    private TableView<PresentedModel> tvAfskrivninger;

    @FXML
    private TableColumn<PresentedModel, String> tcNavn;

    @FXML
    private TableColumn<PresentedModel, String> tcTal;

    @FXML
    private Label labelResultat;

    public void initialize() {
        if (presenter == null) {
            labelResultat.setVisible(false);
            presenter = new Presenter();
            System.out.println("test");
            tvAfskrivninger.setItems(presenter.getPresentedList());
            tvAfskrivninger.getItems().addListener(new ListChangeListener<PresentedModel>() {
                @Override
                public void onChanged(Change<? extends PresentedModel> change) {
                    if (tvAfskrivninger.getItems().size() > 0) {
                        labelResultat.setVisible(true);
                        labelResultat.setText(presenter.getKumuleret());
                    }
                    else {
                        labelResultat.setVisible(false);
                    }
                }
            });
            tcNavn.setCellValueFactory(new PropertyValueFactory<>("navn"));
            tcTal.setCellValueFactory(new PropertyValueFactory<>("afskrivning"));
        }
    }

    @FXML
    public void nyAfskrivning() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../subwindow/AfskrivningSubWindow.fxml"));
        Parent root = loader.load();

        AfskrivningSubWindowController controller = loader.getController();
        Scene scene = buttonNyAfskrivning.getScene();
        controller.setPreviousScene(scene);
        controller.setPresenter(presenter);

        Stage stage = (Stage) buttonNyAfskrivning.getScene().getWindow();
        Scene newScene = new Scene(root, 470, 670);
        stage.setScene(newScene);
    }
}
