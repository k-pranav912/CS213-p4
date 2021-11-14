package com.pizzashop;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.text.DecimalFormat;

public class CurrentOrderController {
    private MainController mainController;

    @FXML
    private TextArea s2TextArea;

    @FXML
    private TextField s2PhoneTextField;

    @FXML
    private ComboBox<Pizza> s2ComboBox;

    @FXML
    private Button s2RemoveButton;

    @FXML
    private Button s2PlaceOrderButton;

    @FXML
    private TextField s2SubTotalTextField;

    @FXML
    private TextField s2SalesTaxTextField;

    @FXML
    private TextField s2TotalTextField;

    private static final DecimalFormat df = new DecimalFormat("0.00");

    public void setMainController(MainController controller) {
        this.mainController = controller;
    }

    public void setPhoneNumber() {

    }

    public CurrentOrderController() {}

    private void calcTotals() {
        s2SubTotalTextField.setText(df.format(mainController.getCurrentOrder().getSubTotal()));
        s2SalesTaxTextField.setText(df.format(mainController.getCurrentOrder().getSalesTax()));
        s2TotalTextField.setText(df.format(mainController.getCurrentOrder().getTotal()));
    }

    @FXML
    public void initialize() {
        s2PhoneTextField.setText(mainController.getCurrentOrder().getPhoneNumber() + "");
        s2ComboBox.getItems().addAll(this.mainController.getCurrentOrder().getList());
        calcTotals();
        s2TextArea.setText(mainController.getCurrentOrder().toString());
    }

    @FXML
    public void removePizza() {
        if (s2ComboBox.getSelectionModel().getSelectedItem() == null) return;

        this.mainController.getCurrentOrder().getList().remove(s2ComboBox.getSelectionModel().getSelectedItem());
        s2ComboBox.getItems().clear();
        s2ComboBox.getItems().addAll(this.mainController.getCurrentOrder().getList());
        calcTotals();
        s2TextArea.setText(mainController.getCurrentOrder().toString());
    }

    @FXML
    public void placeOrder() {
        mainController.getStore().add(mainController.getCurrentOrder());
        mainController.setOrderNull();
        Stage stage = (Stage) s2PlaceOrderButton.getScene().getWindow();
        stage.close();
        mainController.clearPhoneField();

    }

}
