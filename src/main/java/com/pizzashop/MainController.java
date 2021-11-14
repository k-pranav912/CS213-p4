package com.pizzashop;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {

    @FXML
    private ComboBox<String> s0ComboBox;

    @FXML
    private TextArea s0TextArea;

    @FXML
    private TextField s0PhoneTextField;

    @FXML
    private Button s0CheckCurrentOrderButton;

    @FXML
    private Button s0CheckStoreOrderButton;

    private static final int TEN_DIGIT_NUMBER = 1000000000;

    @FXML
    public void initialize() {
    }

    private StoreOrders store;
    private Order currentOrder;

    public MainController() {
        this.store = new StoreOrders();
        this.currentOrder = null;
    }

    public StoreOrders getStore() {
        return store;
    }

    public Order getCurrentOrder() {
        return currentOrder;
    }

    public void setOrderNull() {this.currentOrder = null;}

    public void clearPhoneField() {s0PhoneTextField.setText("");}

    @FXML
    void startOrder(ActionEvent event) throws NumberFormatException {
        currentOrder = null;
        String temp = s0PhoneTextField.getText();
        int phoneNumber = 0;
        if (temp.equals("")) s0TextArea.setText("Enter Valid Phone Number (10 digit number: no spaces, " +
                                                                                     "parentheses, or hyphens)\n");

        try {
            phoneNumber = Integer.parseInt(temp);
        } catch (NumberFormatException e) {
            s0TextArea.setText("Enter Valid Phone Number (10 digit number: no spaces, parentheses, or hyphens)\n");
            return;
        }

        //TODO: isnt working
        if (phoneNumber / TEN_DIGIT_NUMBER < 0 || phoneNumber / TEN_DIGIT_NUMBER > 9) {
            s0TextArea.setText("Enter Valid Phone Number (10 digit number: no spaces, parentheses, or hyphens)");
        }

        this.currentOrder = new Order(phoneNumber);
        s0TextArea.appendText("Order started, in progress.\n");

        if (store.checkOrder(this.currentOrder)) {
            s0TextArea.setText("Order already exists.\n");
            currentOrder = null;
            return;
        }

    }

    @FXML
    void addPepperoni(ActionEvent event) throws IOException {
        if (this.currentOrder == null) {
            s0TextArea.appendText("Please initiate an order first.\n");
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

    @FXML
    void addDeluxe(ActionEvent event) throws IOException {
        if (this.currentOrder == null) {
            s0TextArea.appendText("Please initiate an order first.\n");
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

    @FXML
    void checkOrder(ActionEvent event) throws IOException {
        if (this.currentOrder == null) {
            s0TextArea.appendText("Please initiate an order first.\n");
            return;
        }
        FXMLLoader loader = new FXMLLoader(getClass().getResource("order-view.fxml"));
        CurrentOrderController controller = new CurrentOrderController();
        controller.setMainController(this);
        loader.setController(controller);
        Stage stage = new Stage();
        Scene scene = new Scene(loader.load(), 500, 400);
        CurrentOrderController orderView = loader.getController();
        orderView.setPhoneNumber();
        stage.setResizable(false);
        stage.setTitle("Current Order");
        stage.setScene(scene);
        stage.show();
    }

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
