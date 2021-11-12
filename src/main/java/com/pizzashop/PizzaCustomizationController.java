package com.pizzashop;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class PizzaCustomizationController {

    @FXML
    private Button s1PriceButton;

    @FXML
    private TextField s1PriceTextField;

    @FXML
    void updatePrice(ActionEvent event) {
        s1PriceTextField.setText("$100.00");
    }

}
