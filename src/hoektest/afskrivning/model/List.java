package hoektest.afskrivning.model;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class List {
    ObservableList<Model> models;

    public List() {
        models = FXCollections.observableArrayList();
    }

    public ObservableList<Model> getModels() {
        return models;
    }

    public void addModel(String navn, double[] beregningstal, double afskrivningsvaerdi) {
        Model model = new Model();
        model.setNavn(navn);
        model.setBeregningstal(beregningstal);
        model.setAfskrivningsvaerdi(afskrivningsvaerdi);
        models.add(model);
    }

}
