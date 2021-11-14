package com.pizzashop;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class StoreOrderController {

    private MainController mainController;
    @FXML
    private TextArea s3TextArea;

    @FXML
    private TextField s3TotalPriceTextField;

    @FXML
    private ComboBox<Order> s3ComboBox;

    @FXML
    private Button s3DeleteOrderButton;

    public void setMainController(MainController controller) {
        mainController = controller;
    }

    public void initialize() {
        s3TextArea.setText(mainController.getStore().toString());
        s3ComboBox.getItems().addAll(this.mainController.getStore().orders);
    }

    @FXML
    public void deleteOrder(ActionEvent event) {
        if (s3ComboBox.getSelectionModel().getSelectedItem() == null) return;

        this.mainController.getStore().remove(s3ComboBox.getSelectionModel().getSelectedItem());
        s3ComboBox.getItems().clear();
        s3ComboBox.getItems().addAll(this.mainController.getStore().orders);
        s3TextArea.setText(mainController.getStore().toString());
    }
}

