package hoektest.afskrivning.viewmodel;

import hoektest.afskrivning.model.List;
import hoektest.afskrivning.model.Model;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Presenter {
    private List list;
    private ObservableList<PresentedModel> presentedList;

    public Presenter() {
        list = new List();
        presentedList = FXCollections.observableArrayList();
    }

    public Presenter(List list) {
        this.list = list;
    }

    public void addModel(String navn, double[] beregningstal, double afskrivningsvaerdi) {
        list.addModel(navn, beregningstal, afskrivningsvaerdi);
        PresentedModel presentedModel = new PresentedModel();
        presentedModel.setNavn(navn);
        String formatted = String.format("%,.2f", afskrivningsvaerdi);
        presentedModel.setAfskrivning(formatted + " kr.");
        presentedList.add(presentedModel);
    }

    public ObservableList<PresentedModel> getPresentedList() {
        return presentedList;
    }

    public String getKumuleret() {
        double kumuleret = list.getKumuleretAfskrivinger();
        String formatted = String.format("%,.2f", kumuleret);
        return formatted + " kr.";
    }
}
