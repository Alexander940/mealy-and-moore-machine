package main;

import javafx.application.Application;
import javafx.stage.Stage;
import ui.MainGUI;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        MainGUI mainWindow = new MainGUI();
        mainWindow.show();
    }
}
