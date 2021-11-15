package com.pizzashop;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * The StoreOrder class, which handles setting up and running the Store Orders GUI
 */
public class StoreOrder extends Application {

    /**
     * Calls launch(args) to launch the GUI
     * @param args Arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Starts the Store Orders GUI, sets up the scene and stage, and loads the FXML file
     * @param primaryStage Stage to be displayed to the user
     * @throws IOException Errors from GUI I/O
     */
    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("store-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500, 300);
        primaryStage.setResizable(false);
        primaryStage.setTitle("Store Orders");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
