package com.pizzashop;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.text.DecimalFormat;

public class PizzaCustomizationController {

    private Pizza pizza;
    private ObservableList<Topping> availableToppings = FXCollections.observableArrayList(Topping.values());
    private static final DecimalFormat df = new DecimalFormat("0.00");
    private String pizzaName;


    @FXML
    private TextField s1PriceTextField;

    @FXML
    private TextArea s1TextArea;

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
    private Button s1AddToOrderButton;

    @FXML
    private TextField s1ErrorTextField;

    @FXML
    private ImageView s1ImageView;

    private MainController mainController;

    public void setMainController(MainController controller) {
        this.mainController = controller;
    }

    public PizzaCustomizationController(String pizza) throws FileNotFoundException {
        this.pizza = PizzaMaker.createPizza(pizza);
        this.pizzaName = pizza;
        removeDuplicates(availableToppings, this.pizza.toppings);
    }

    private void setImageView(String pizza) {
        switch (pizza.toLowerCase()) {
            case "deluxe":
                Image imageDeluxe = new Image("/DeluxePizza.png");
                s1ImageView.setImage(imageDeluxe);
                break;
            case "hawaiian":
                Image imageHawaiian = new Image("/HawaiianPizza.png");
                s1ImageView.setImage(imageHawaiian);
                break;
            case "pepperoni":
                Image imagePepperoni = new Image("/PepperoniPizza.png");
                s1ImageView.setImage(imagePepperoni);
                break;
        }
    }

    @FXML
    public void initialize() {
        s1TextArea.setText(this.pizza.toString());
        s1Small.setSelected(true);
        s1PriceTextField.setText(this.pizza.price() + "");
        s1AvailableList.getItems().addAll(this.availableToppings);
        s1SelectedList.getItems().addAll(this.pizza.toppings);
        s1ImageView = new ImageView();
        //setImageView(pizzaName);
    }

    @FXML
    public void selectSmall(ActionEvent event) {
        this.pizza.setSize(Size.SMALL);
        s1PriceTextField.setText(df.format(this.pizza.price()) + "");
    }

    @FXML
    public void selectMedium(ActionEvent event) {
        this.pizza.setSize(Size.MEDIUM);
        s1PriceTextField.setText(df.format(this.pizza.price()) + "");
    }

    @FXML
    public void selectLarge(ActionEvent event) {
        this.pizza.setSize(Size.LARGE);
        s1PriceTextField.setText(df.format(this.pizza.price()) + "");
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
            s1ErrorTextField.setText("You can only have max 7 toppings.\n");
        } else {
            this.pizza.toppings.add(s1AvailableList.getSelectionModel().getSelectedItem());
            this.availableToppings.remove(s1AvailableList.getSelectionModel().getSelectedItem());
            s1SelectedList.setItems(this.pizza.toppings);
            s1AvailableList.setItems(this.availableToppings);
            s1TextArea.setText(this.pizza.toString());
            s1PriceTextField.setText(df.format(this.pizza.price()) + "");
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
        s1PriceTextField.setText(df.format(this.pizza.price()) + "");
        s1ErrorTextField.setText("");
    }

    @FXML
    public void addToOrder(ActionEvent event) {
        mainController.getCurrentOrder().add(this.pizza);
        Stage stage = (Stage) s1AddToOrderButton.getScene().getWindow();
        stage.close();

    }



}
