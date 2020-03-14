package hoektest.treeview;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

public class TreeViewUIController {
    @FXML
    private TreeView<String> testTreeView;

    public void initialize() {
        TreeItem<String> rootNode = new TreeItem<>("root");
        rootNode.setExpanded(true);
        TestObject testObject1 = new TestObject("test1", "gruppe1", 200);
        TestObject testObject2 = new TestObject("test2", "gruppe2",  500);
        TestObject testObject3 = new TestObject("test3", "gruppe2", 700);
        List<TestObject> testObjects = new ArrayList<>();
        testObjects.add(testObject1);
        testObjects.add(testObject2);
        testObjects.add(testObject3);
        for (TestObject testObject : testObjects) {
            Label labelWithPadding = new Label(testObject.getNavn());
            labelWithPadding.setPadding(new Insets(0, 16, 0, 0));
            HBox hBox = new HBox(labelWithPadding, new Label(String.format("%.2f", testObject.getBeloeb()) + " kr."));
            TreeItem<String> testLeaf = new TreeItem<>("");
            testLeaf.setGraphic(hBox);
            boolean found = false;
            for (TreeItem<String> gruppeNode : rootNode.getChildren()) {
                if (gruppeNode.getValue().contentEquals(testObject.getGruppe())) {
                    gruppeNode.getChildren().add(testLeaf);
                    found = true;
                    break;
                }
            }
            if (!found) {
                TreeItem<String> gruppeNode = new TreeItem<>(testObject.getGruppe());
                rootNode.getChildren().add(gruppeNode);
                gruppeNode.getChildren().add(testLeaf);
            }
        }

        testTreeView.setRoot(rootNode);
        testTreeView.setShowRoot(false);
        testTreeView.setStyle("-fx-background-insets: 0");
    }
}
