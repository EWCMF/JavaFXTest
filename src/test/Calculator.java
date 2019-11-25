package test;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;


public class Calculator extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Addition Calculator");

        Label label1 = new Label("First number");

        TextField textField1 = new TextField();

        Label label2 = new Label("Second number");
        label2.setStyle("-fx-padding: 10 0 0 0;");

        TextField textField2 = new TextField();

        Label label3 = new Label("Result here");
        label3.setStyle("-fx-padding: 10 0 0 0; -fx-font-size: 16pt;");
        AtomicReference<Double> calc = new AtomicReference<>();
        AtomicInteger chosen = new AtomicInteger();

        chosen.set(1);
        Label labelChosen = new Label("Addition is chosen.");
        labelChosen.setStyle("-fx-padding: 20 0 10 0; -fx-font-size: 16pt;");

        Button add = new Button("Add");
        add.setOnAction(actionEvent -> {
            chosen.set(1);
            labelChosen.setText("Addition is chosen.");
        });
        Button sub = new Button("Subtract");
        sub.setOnAction(actionEvent -> {
            chosen.set(2);
            labelChosen.setText("Subtract is chosen.");
        });
        Button div = new Button("Divide");
        div.setOnAction(actionEvent -> {
            chosen.set(3);
            labelChosen.setText("Divide is chosen.");
        });
        Button mul = new Button("Multiply");
        mul.setOnAction(actionEvent -> {
            chosen.set(4);
            labelChosen.setText("Multiply is chosen.");
        });


        HBox hbox = new HBox(add, sub, div, mul);

        Button button = new Button("Calculate");
        button.setOnAction(actionEvent ->  {
            if (isNumeric(textField1.getText()) && isNumeric(textField2.getText())) {
                switch (chosen.get()) {
                    case 1:
                        calc.set(add(Double.parseDouble(textField1.getText()), Double.parseDouble(textField2.getText())));
                        if (calc.get() % 1 > 0) {
                            label3.setText("" + calc);
                            break;
                        }
                        else
                            label3.setText("" + calc.get().longValue());
                        break;
                    case 2:
                        calc.set(sub(Double.parseDouble(textField1.getText()), Double.parseDouble(textField2.getText())));
                        if (calc.get() % 1 > 0) {
                            label3.setText("" + calc);
                            break;
                        }
                        else
                            label3.setText("" + calc.get().longValue());
                        break;
                    case 3:
                        calc.set(div(Double.parseDouble(textField1.getText()), Double.parseDouble(textField2.getText())));
                        if (calc.get() % 1 > 0) {
                            label3.setText("" + calc);
                            break;
                        }
                        else
                            label3.setText("" + calc.get().longValue());
                        break;
                    case 4:
                        calc.set(mul(Double.parseDouble(textField1.getText()), Double.parseDouble(textField2.getText())));
                        if (calc.get() % 1 > 0) {
                            label3.setText("" + calc);
                            break;
                        }
                        else
                            label3.setText("" + calc.get().longValue());
                        break;
                }
            }
            else
                label3.setText("Can't use text!");

        });



        VBox vBox = new VBox(hbox, labelChosen, label1, textField1, label2, textField2, button, label3);


        Scene scene = new Scene(vBox, 400, 250);
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

    private static double add(double first, double second) {
        return first + second;
    }

    private static double sub(double first, double second) {
        return first - second;
    }

    private static double div(double first, double second) {
        return first / second;
    }

    private static double mul(double first, double second) {
        return first * second;
    }

    private static boolean isNumeric(String strNum) {
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException | NullPointerException nfe) {
            return false;
        }
        return true;
    }
}
