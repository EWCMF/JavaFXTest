package hoektest.afskrivning.model;
import javafx.collections.ObservableList;

public class List {
    ObservableList<Model> models;

    public ObservableList<Model> getModels() {
        return models;
    }

    public void addModel(Model model) {
        models.add(model);
    }

}
