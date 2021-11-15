package com.pizzashop;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.text.DecimalFormat;

/**
 * The CurrentOrderController class, which controls the Current Order GUI. Handles removing pizzas from the order,
 * displaying the subtotal, sales tax, and total prices, and placing the order.
 */
public class CurrentOrderController {
    private MainController mainController;

    @FXML
    private TextArea s2TextArea;

    @FXML
    private TextField s2PhoneTextField;

    @FXML
    private ComboBox<Pizza> s2ComboBox;

    @FXML
    private Button s2PlaceOrderButton;

    @FXML
    private TextField s2SubTotalTextField;

    @FXML
    private TextField s2SalesTaxTextField;

    @FXML
    private TextField s2TotalTextField;

    private static final DecimalFormat df = new DecimalFormat("0.00");

    /**
     * Sets the Main Menu controller for access to its methods
     * @param controller
     */
    public void setMainController(MainController controller) {
        this.mainController = controller;
    }

    /**
     * Calculates and displays the subtotal, sales tax, and total prices
     */
    private void calcTotals() {
        s2SubTotalTextField.setText(df.format(mainController.getCurrentOrder().getSubTotal()));
        s2SalesTaxTextField.setText(df.format(mainController.getCurrentOrder().getSalesTax()));
        s2TotalTextField.setText(df.format(mainController.getCurrentOrder().getTotal()));
    }

    /**
     * Initializes the phone number text field, the text field and combo box to show the pizzas in the order,
     * as well as calculate the totals.
     */
    @FXML
    public void initialize() {
        s2PhoneTextField.setText(mainController.getCurrentOrder().getPhoneNumber() + "");
        s2ComboBox.getItems().addAll(this.mainController.getCurrentOrder().getList());
        calcTotals();
        s2TextArea.setText(mainController.getCurrentOrder().toString());
    }

    /**
     * Removes a pizza from the order and recalculates the totals
     */
    @FXML
    public void removePizza() {
        if (s2ComboBox.getSelectionModel().getSelectedItem() == null) return;

        this.mainController.getCurrentOrder().getList().remove(s2ComboBox.getSelectionModel().getSelectedItem());
        s2ComboBox.getItems().clear();
        s2ComboBox.getItems().addAll(this.mainController.getCurrentOrder().getList());
        calcTotals();
        s2TextArea.setText(mainController.getCurrentOrder().toString());
    }

    /**
     * Places the order and closes the Current Order stage
     */
    @FXML
    public void placeOrder() {
        if (mainController.getCurrentOrder().getTotal() == 0) {
            s2TextArea.setText("Cannot place an empty order.\nPlease return to the main menu.\n");
            return;
        }
        mainController.getStore().add(mainController.getCurrentOrder());
        mainController.setOrderNull();
        Stage stage = (Stage) s2PlaceOrderButton.getScene().getWindow();
        stage.close();
        mainController.clearPhoneField();
    }
}
