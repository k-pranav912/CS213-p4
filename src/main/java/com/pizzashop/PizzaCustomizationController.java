package com.pizzashop;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.ArrayList;
import java.util.List;

public class PizzaCustomizationController {

    private Pizza pizza;
    private ObservableList<Topping> availableToppings = FXCollections.observableArrayList(Topping.values());

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
    private ListView<Topping> s1AvailableList;

    @FXML
    private ListView<Topping> s1SelectedList;

    @FXML
    private Button s1AddButton;

    @FXML
    private Button s1RemoveButton;

    private MainController mainController;

    public void setMainController(MainController controller) {
        this.mainController = controller;
    }

    public PizzaCustomizationController(String pizza) {
        this.pizza = PizzaMaker.createPizza(pizza);
        removeDuplicates(availableToppings, this.pizza.toppings);
    }

    @FXML
    public void initialize() {
        s1TextArea.setText(this.pizza.toString());
        s1Small.setSelected(true);
        s1PriceTextField.setText(this.pizza.price() + "");
        s1AvailableList.getItems().addAll(this.availableToppings);
        s1SelectedList.getItems().addAll(this.pizza.toppings);
    }

    @FXML
    public void selectSmall(ActionEvent event) {
        this.pizza.setSize(Size.SMALL);
        s1PriceTextField.setText(this.pizza.price() + "");
    }

    @FXML
    public void selectMedium(ActionEvent event) {
        this.pizza.setSize(Size.MEDIUM);
        s1PriceTextField.setText(this.pizza.price() + "");
    }

    @FXML
    public void selectLarge(ActionEvent event) {
        this.pizza.setSize(Size.LARGE);
        s1PriceTextField.setText(this.pizza.price() + "");
    }

    private void removeDuplicates(ObservableList<Topping> target, ObservableList<Topping> source) {
        for (Topping x: source) {
            target.remove(x);
        }
    }

    @FXML
    public void addTopping(ActionEvent event) {
        if (s1AvailableList.getSelectionModel().getSelectedItem() == null) return;
        if (this.pizza.toppings.size() == this.pizza.getMaxSize()) {
            s1TextArea.setText("You can only have max 7 toppings.\n");
        } else {
            this.pizza.toppings.add(s1AvailableList.getSelectionModel().getSelectedItem());
            this.availableToppings.remove(s1AvailableList.getSelectionModel().getSelectedItem());
            s1SelectedList.setItems(this.pizza.toppings);
            s1AvailableList.setItems(this.availableToppings);
            s1TextArea.setText(this.pizza.toString());
            s1PriceTextField.setText(this.pizza.price() + "");
        }
    }

    @FXML
    public void removeTopping(ActionEvent event) {
        if (s1SelectedList.getSelectionModel().getSelectedItem() == null) return;
        this.availableToppings.add(s1SelectedList.getSelectionModel().getSelectedItem());
        this.pizza.toppings.remove(s1SelectedList.getSelectionModel().getSelectedItem());
        s1SelectedList.setItems(this.pizza.toppings);
        s1AvailableList.setItems(this.availableToppings);
        s1TextArea.setText(this.pizza.toString());
        s1PriceTextField.setText(this.pizza.price() + "");
    }

    @FXML
    public void addToOrder(ActionEvent event) {
        mainController.getCurrentOrder().add(this.pizza);

    }



}
