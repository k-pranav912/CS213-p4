package com.pizzashop;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * The CurrentOrder class, which handles setting up and running the Current Order GUI
 */
public class CurrentOrder extends Application {

    /**
     * Calls launch(args) to launch the GUI
     * @param args Arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Starts the Current Order GUI, sets up the scene and stage, and loads the FXML file
     * @param primaryStage Stage to be displayed to the user
     * @throws IOException Errors from GUI I/O
     */
    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("order-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500, 400);
        primaryStage.setResizable(false);
        primaryStage.setTitle("Current Order");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
