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

//    private void observeModel() {
//        list.addPropertyChangeListener(new PropertyChangeListener() {
//            @Override
//            public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
//                List newValues = (List) propertyChangeEvent.getNewValue();
//            }
//        });
//    }

    public void addModel(Model model) {
        list.addModel(model);
    }

    public ObservableList<PresentedModel> getPresentedList() {
        return presentedList;
    }
}
