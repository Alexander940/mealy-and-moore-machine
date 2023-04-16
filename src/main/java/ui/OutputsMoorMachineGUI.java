package ui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.awt.event.ActionEvent;

public class OutputsMoorMachineGUI {

    @FXML
    private TableColumn<?, ?> colNextState;

    @FXML
    private TableColumn<?, ?> colInput;

    @FXML
    private TableColumn<?, ?> colOutput;

    @FXML
    private TableColumn<?, ?> colCurrentState;

    @FXML
    private Button btnAddTransition;

    @FXML
    private TableView<?> tableTransitions;

    @FXML
    void addTransition(ActionEvent event) {

    }

}
