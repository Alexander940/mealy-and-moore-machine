package ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;

import java.io.IOException;

public class MainGUI extends Stage {

        Button createMachine;
        RadioButton mealyMachine, mooreMachine;

        public MainGUI() {
                try {
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/MainGUI.fxml"));
                        Parent root = loader.load();

                        createMachine = (Button) loader.getNamespace().get("createMachine");
                        mealyMachine = (RadioButton) loader.getNamespace().get("mealyMachine");
                        mooreMachine = (RadioButton) loader.getNamespace().get("mooreMachine");

                        Scene scene = new Scene(root, 600,400);
                        setScene(scene);

                        init();
                } catch (IOException e) {
                        e.printStackTrace();
                }
        }

        private void init() {
                createMachine.setOnAction(event -> {
                        if(mealyMachine.isSelected()){
                                MealyMachineGUI mealyMachineGUI = new MealyMachineGUI();
                                mealyMachineGUI.show();
                        } else if(mooreMachine.isSelected()){
                                /*MooreMachineGUI mooreMachineGUI = new MooreMachineGUI();
                                mooreMachineGUI.show();*/
                        }
                });
        }

}




