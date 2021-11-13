package com.pizzashop;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class PizzaCustomizationController {

    private static final double pepperoniPrice = 8.99;
    private static final double hawaiianPrice = 10.99;
    private static final double deluxePrice = 12.99;
    private static final double sizeUpgradePrice = 1.49;


    private String pizza;
    private double basePrice;
    private double price;

    @FXML
    private TextField s1PriceTextField;

    @FXML
    private TextArea s1TextArea;

    @FXML
    private ToggleGroup pizzaViewSizeToggle;

    @FXML
    private RadioButton s1Small;

    @FXML
    private RadioButton s1Medium;

    @FXML
    private RadioButton s1Large;

    @FXML
    void updatePrice(ActionEvent event) {
        s1PriceTextField.setText("$100.00");
    }

    private MainController mainController;

    public void setMainController(MainController controller) {
        this.mainController = controller;
    }

    public PizzaCustomizationController(String pizza) {
        this.pizza = pizza;
        if (pizza.equals("Pepperoni")) {
            basePrice = pepperoniPrice;
        } else if (pizza.equals("Hawaiian")) {
            basePrice = hawaiianPrice;
        } else {
            basePrice = deluxePrice;
        }
    }

    @FXML
    public void initialize() {
        s1TextArea.setText(pizza + "\n");
        s1Small.setSelected(true);
        s1PriceTextField.setText(basePrice + "");
    }

    private double calcPrice() {
        return this.price;
    }

    @FXML
    public void selectSmall(ActionEvent event) {
        this.price = basePrice;
        s1PriceTextField.setText(calcPrice() + "");
    }

    @FXML
    public void selectMedium(ActionEvent event) {
        this.price = basePrice + sizeUpgradePrice;
        s1PriceTextField.setText(calcPrice() + "");
    }

    @FXML
    public void selectLarge(ActionEvent event) {
        this.price = basePrice + sizeUpgradePrice + sizeUpgradePrice;
        s1PriceTextField.setText(calcPrice() + "");
    }



}
