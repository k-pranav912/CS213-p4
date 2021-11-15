package com.pizzashop;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * The MainController class, which controls the Main Menu GUI. This controller sends you to the corresponding
 * GUI when adding a pizza, checking an order, or checking the store orders.
 */
public class MainController {

    @FXML
    private ComboBox<String> s0ComboBox;

    @FXML
    private TextArea s0TextArea;

    @FXML
    private TextField s0PhoneTextField;

    private StoreOrders store;
    private Order currentOrder;

    /**
     * MainController constructore, which creates the Store Orders (store) and initializes currentOrder
     */
    public MainController() {
        this.store = new StoreOrders();
        this.currentOrder = null;
    }

    /**
     * Gets the Store Orders (store)
     * @return StoreOrders of the user
     */
    public StoreOrders getStore() {
        return store;
    }

    /**
     * Gets the Current Order
     * @return Order the user is working on
     */
    public Order getCurrentOrder() {
        return currentOrder;
    }

    /**
     * Sets the current order to null
     */
    public void setOrderNull() {
        this.currentOrder = null;
    }

    /**
     * Clears the Phone Number text field
     */
    public void clearPhoneField() {
        s0PhoneTextField.setText("");
    }

    /**
     * Intializes an order based on the user entered phone number, if it is not already on order or invalid
     * @param event Event when user presses the Start Order button
     * @throws NumberFormatException If the Phone Number was not a valid integer
     */
    @FXML
    void startOrder(ActionEvent event) throws NumberFormatException {
        currentOrder = null;
        String temp = s0PhoneTextField.getText();
        long phoneNumber = 0;
        if (temp.equals("")) s0TextArea.setText("Enter Valid Phone Number (Numbers Only)\n");

        try {
            phoneNumber = Long.parseLong(temp);
        } catch (NumberFormatException e) {
            s0TextArea.setText("Enter Valid Phone Number (Numbers Only)\n");
            return;
        }

        if (phoneNumber < 0) {
            s0TextArea.setText("Enter Valid Phone Number (Numbers Only)\n");
            return;
        }

        this.currentOrder = new Order(phoneNumber);
        s0TextArea.setText("Order " + phoneNumber + " started.\n");

        if (store.checkOrder(this.currentOrder)) {
            s0TextArea.setText("Order " + phoneNumber + " already exists.\n");
            currentOrder = null;
            return;
        }
    }

    /**
     * Goes to the Pizza Customization GUI to add a pepperoni pizza in the user entered Order (if it exists)
     * @param event Event when user presses Pepperoni button
     * @throws IOException If FXML loader does not work
     */
    @FXML
    void addPepperoni(ActionEvent event) throws IOException {
        if (this.currentOrder == null) {
            s0TextArea.setText("Please initiate an order first.\n");
            return;
        }
        FXMLLoader loader = new FXMLLoader(getClass().getResource("pizza-view.fxml"));
        PizzaCustomizationController controller = new PizzaCustomizationController("Pepperoni");
        loader.setController(controller);
        Stage stage = new Stage();
        Scene scene = new Scene(loader.load(), 600, 400);
        PizzaCustomizationController pizzaView = loader.getController();
        pizzaView.setMainController(this);
        stage.setResizable(false);
        stage.setTitle("Pizza Customization");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Goes to the Pizza Customization GUI to add a hawaiian pizza in the user entered Order (if it exists)
     * @param event Event when user presses Hawaiian button
     * @throws IOException If FXML loader does not work
     */
    @FXML
    void addHawaiian(ActionEvent event) throws IOException {
        if (this.currentOrder == null) {
            s0TextArea.appendText("Please initiate an order first.\n");
            return;
        }
        FXMLLoader loader = new FXMLLoader(getClass().getResource("pizza-view.fxml"));
        PizzaCustomizationController controller = new PizzaCustomizationController("Hawaiian");
        loader.setController(controller);
        Stage stage = new Stage();
        Scene scene = new Scene(loader.load(), 600, 400);
        PizzaCustomizationController pizzaView = loader.getController();
        pizzaView.setMainController(this);
        stage.setResizable(false);
        stage.setTitle("Pizza Customization");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Goes to the Pizza Customization GUI to add a Deluxe pizza in the user entered Order (if it exists)
     * @param event Event when user presses Deluxe button
     * @throws IOException If FXML loader does not work
     */
    @FXML
    void addDeluxe(ActionEvent event) throws IOException {
        if (this.currentOrder == null) {
            s0TextArea.setText("Please initiate an order first.\n");
            return;
        }
        FXMLLoader loader = new FXMLLoader(getClass().getResource("pizza-view.fxml"));
        PizzaCustomizationController controller = new PizzaCustomizationController("Deluxe");
        loader.setController(controller);
        Stage stage = new Stage();
        Scene scene = new Scene(loader.load(), 600, 400);
        PizzaCustomizationController pizzaView = loader.getController();
        pizzaView.setMainController(this);
        stage.setResizable(false);
        stage.setTitle("Pizza Customization");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Goes to the Current Order GUI for the user to review their order (if it exists) and place it if need be.
     * @param event Event when user presses Check Current Order button
     * @throws IOException If FXML loader does not work
     */
    @FXML
    void checkOrder(ActionEvent event) throws IOException {
        if (this.currentOrder == null) {
            s0TextArea.setText("Please initiate an order first.\n");
            return;
        }
        FXMLLoader loader = new FXMLLoader(getClass().getResource("order-view.fxml"));
        CurrentOrderController controller = new CurrentOrderController();
        controller.setMainController(this);
        loader.setController(controller);
        Stage stage = new Stage();
        Scene scene = new Scene(loader.load(), 500, 400);
        stage.setResizable(false);
        stage.setTitle("Current Order");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Goes to the Store Orders GUI for the user to review all orders and delete or export them
     * @param event Event when user presses Check Store Orders button
     * @throws IOException If FXML loader does not work
     */
    @FXML
    void checkStore(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("store-view.fxml"));
        StoreOrderController controller = new StoreOrderController();
        controller.setMainController(this);
        loader.setController(controller);
        Stage stage = new Stage();
        Scene scene = new Scene(loader.load(), 500, 300);
        StoreOrderController storeView = loader.getController();
        stage.setResizable(false);
        stage.setTitle("Store Orders");
        stage.setScene(scene);
        stage.show();
    }
}
