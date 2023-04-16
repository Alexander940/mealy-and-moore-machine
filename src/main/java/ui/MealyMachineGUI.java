package ui;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;

public class MealyMachineGUI extends Stage {

    TextField ftStates, ftInitialState, ftAlphabet, ftOutputs;


    public MealyMachineGUI() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/MealyMachine.fxml"));
            Parent root = loader.load();

            ftStates = (TextField) loader.getNamespace().get("ftStates");
            ftInitialState = (TextField) loader.getNamespace().get("ftInitialState");
            ftAlphabet = (TextField) loader.getNamespace().get("ftAlphabet");
            ftOutputs = (TextField) loader.getNamespace().get("ftOutputs");

            Scene scene = new Scene(root, 600,400);
            setScene(scene);

            init();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void init() {

    }

}
