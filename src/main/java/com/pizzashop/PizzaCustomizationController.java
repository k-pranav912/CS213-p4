package com.pizzashop;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * The PizzaCustomizationController class, which controls the Pizza Customization GUI. This controller handles changing
 * a pizzas size/toppings and adding it to an order
 */
public class PizzaCustomizationController {

    private Pizza pizza;
    private ArrayList<Topping> availableToppings = new ArrayList<Topping>();
    private static final DecimalFormat df = new DecimalFormat("0.00");


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

    /**
     * Sets the Main Menu controller for access to its methods
     * @param controller
     */
    public void setMainController(MainController controller) {
        this.mainController = controller;
    }

    /**
     * Constructor that creates the pizza based on the flavor and sets the appropriate toppings in the listview
     * @param flavor String describing the pizza's flavor
     */
    public PizzaCustomizationController(String flavor) {
        this.pizza = PizzaMaker.createPizza(flavor);
        for (Topping x: Topping.values()) {
            availableToppings.add(x);
        }
        removeDuplicates(availableToppings, this.pizza.toppings);
    }

    /**
     * Initializes the necessary text boxes, radio buttons, imageview, and lists to display their default data
     */
    @FXML
    public void initialize() throws FileNotFoundException {
        s1TextArea.setText(this.pizza.toString());
        s1Small.setSelected(true);
        s1PriceTextField.setText(this.pizza.price() + "");
        s1AvailableList.getItems().addAll(this.availableToppings);
        s1SelectedList.getItems().addAll(this.pizza.toppings);
        s1ImageView.setImage(new Image(new FileInputStream(this.pizza.getImagePath())));
    }

    /**
     * Sets the pizza size to small and recalculates price
     * @param event Event when Small radio button is pressed
     */
    @FXML
    public void selectSmall(ActionEvent event) {
        this.pizza.setSize(Size.SMALL);
        s1PriceTextField.setText(df.format(this.pizza.price()) + "");
    }

    /**
     * Sets the pizza size to medium and recalculates price
     * @param event Event when Medium radio button is pressed
     */
    @FXML
    public void selectMedium(ActionEvent event) {
        this.pizza.setSize(Size.MEDIUM);
        s1PriceTextField.setText(df.format(this.pizza.price()) + "");
    }

    /**
     * Sets the pizza size to large and recalculates price
     * @param event Event when Large radio button is pressed
     */
    @FXML
    public void selectLarge(ActionEvent event) {
        this.pizza.setSize(Size.LARGE);
        s1PriceTextField.setText(df.format(this.pizza.price()) + "");
    }

    /**
     * Removes all duplicates of toppings already on the pizza from the list of available toppings
     * @param target Available toppings list
     * @param source List of toppings on the pizza
     */
    private void removeDuplicates(ArrayList<Topping> target, ArrayList<Topping> source) {
        for (Topping x: source) {
            target.remove(x);
        }
    }

    /**
     * Adds selected topping to the pizza, if it is less than the maximum number allowed. Reconfigures the listviews to
     * show the correct toppings. Recalculates price.
     * @param event Event when user presses to add a topping =>
     */
    @FXML
    public void addTopping(ActionEvent event) {
        if (s1AvailableList.getSelectionModel().getSelectedItem() == null) return;
        if (this.pizza.toppings.size() == this.pizza.getMaxToppings()) {
            s1ErrorTextField.setText("You can only have max " + this.pizza.getMaxToppings() +" toppings.\n");
        } else {
            this.pizza.toppings.add(s1AvailableList.getSelectionModel().getSelectedItem());
            this.availableToppings.remove(s1AvailableList.getSelectionModel().getSelectedItem());
            s1SelectedList.getItems().clear();
            s1SelectedList.getItems().addAll(this.pizza.toppings);
            s1AvailableList.getItems().clear();
            s1AvailableList.getItems().addAll(this.availableToppings);
            s1TextArea.setText(this.pizza.toString());
            s1PriceTextField.setText(df.format(this.pizza.price()) + "");
        }
    }

    /**
     * Removes selected topping from the pizza. Reconfigures the listviews to show the correct toppings.
     * Recalculates price.
     * @param event Event when user presses to add a topping =>
     */
    @FXML
    public void removeTopping(ActionEvent event) {
        if (s1SelectedList.getSelectionModel().getSelectedItem() == null) return;
        this.availableToppings.add(s1SelectedList.getSelectionModel().getSelectedItem());
        this.pizza.toppings.remove(s1SelectedList.getSelectionModel().getSelectedItem());
        s1SelectedList.getItems().clear();
        s1SelectedList.getItems().addAll(this.pizza.toppings);
        s1AvailableList.getItems().clear();
        s1AvailableList.getItems().addAll(this.availableToppings);
        s1TextArea.setText(this.pizza.toString());
        s1PriceTextField.setText(df.format(this.pizza.price()) + "");
        s1ErrorTextField.setText("");
    }

    /**
     * Adds the pizza to the current order and closes the Pizza Customization stage
     * @param event Event when user presses Add To Order button
     */
    @FXML
    public void addToOrder(ActionEvent event) {
        mainController.getCurrentOrder().add(this.pizza);
        Stage stage = (Stage) s1AddToOrderButton.getScene().getWindow();
        stage.close();

    }
}
