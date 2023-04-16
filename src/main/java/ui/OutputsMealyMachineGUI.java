package ui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.awt.event.ActionEvent;

public class OutputsMealyMachineGUI {

    @FXML
    private TableColumn<?, ?> outputColumn;

    @FXML
    private Button btnAddRow;

    @FXML
    private TableColumn<?, ?> nextStateColumn;

    @FXML
    private TableColumn<?, ?> inputColumn;

    @FXML
    private TableView<?> table;

    @FXML
    private TableColumn<?, ?> currentStateColumn;

    @FXML
    void addRow(ActionEvent event) {

    }

}
