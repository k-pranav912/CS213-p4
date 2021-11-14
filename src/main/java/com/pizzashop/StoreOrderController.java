package com.pizzashop;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class StoreOrderController {

    private MainController mainController;
    @FXML
    private TextArea s3TextArea;

    @FXML
    private TextField s3TotalPriceTextField;

    public void setMainController(MainController controller) {
        mainController = controller;
    }

    public void initialize() {
        s3TextArea.setText(mainController.getStore().toString());
    }
}

