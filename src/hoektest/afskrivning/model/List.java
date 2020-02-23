package hoektest.afskrivning.model;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class List {
    ObservableList<Model> models;

    double kumuleretAfskrivinger;

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
        updateKumuleret();
    }

    public void updateKumuleret() {
        kumuleretAfskrivinger = 0;
        for (Model model : models) {
            kumuleretAfskrivinger += model.getAfskrivningsvaerdi();
        }
    }

    public double getKumuleretAfskrivinger() {
        return kumuleretAfskrivinger;
    }
}
