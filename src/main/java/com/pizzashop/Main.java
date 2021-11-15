package com.pizzashop;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * The Main class, which handles setting up and running the Main Menu GUI
 */
public class Main extends Application {

    /**
     * Calls launch(args) to launch the GUI
     * @param args Arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Starts the Main Menu GUI, sets up the scene and stage, and loads the FXML file
     * @param primaryStage Stage to be displayed to the user
     * @throws IOException Errors from GUI I/O
     */
    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 250, 250);
        primaryStage.setResizable(false);
        primaryStage.setTitle("Main Menu");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
