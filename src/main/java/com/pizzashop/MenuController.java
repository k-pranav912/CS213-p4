package com.pizzashop;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

public class MenuController {

    @FXML
    private ComboBox<String> s0ComboBox;

    @FXML
    private TextArea s0TextArea;

    @FXML
    public void initialize() {
       s0ComboBox.getItems().addAll("Pepperoni", "Hawaiian", "Deluxe");
    }
    private StoreOrders store;
    private Order currentOrder;

    public MenuController() {
        this.store = new StoreOrders();
        this.currentOrder = null;
    }

}
