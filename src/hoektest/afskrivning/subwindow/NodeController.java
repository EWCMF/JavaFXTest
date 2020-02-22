package hoektest.afskrivning.subwindow;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class NodeController {

    @FXML
    private TextField tfAnskaf, tfSkrap, tfBrugs;

    @FXML
    private TextField tfNutids, tfProcent;

    @FXML
    private TextField tfStraks;

    public double getTfAnskaf() {
        return Double.parseDouble(tfAnskaf.getText());
    }

    public double getTfSkrap() {
        return Double.parseDouble(tfSkrap.getText());
    }

    public double getTfBrugs() {
        return Double.parseDouble(tfBrugs.getText());
    }

    public double getTfNutids() {
        return Double.parseDouble(tfNutids.getText());
    }

    public double getTfProcent() {
        return Double.parseDouble(tfProcent.getText());
    }

    public double getTfStraks() {
        return Double.parseDouble(tfStraks.getText());
    }
}
