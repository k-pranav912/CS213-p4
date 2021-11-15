package com.pizzashop;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.DecimalFormat;

/**
 * The StoreOrderController class, which controls the Store Order GUI. Handles deleting placed orders and exporting the
 * store orders to a text file
 */
public class StoreOrderController {

    private static final DecimalFormat df = new DecimalFormat("0.00");
    private MainController mainController;
    @FXML
    private TextArea s3TextArea;

    @FXML
    private TextField s3TotalPriceTextField;

    @FXML
    private ComboBox<Order> s3ComboBox;

    @FXML
    private TextField s3ExportTextField;

    /**
     * Sets the Main Menu controller for access to its methods
     * @param controller
     */
    public void setMainController(MainController controller) {
        mainController = controller;
    }

    /**
     * Initializes the text area and combo box to display all orders,
     */
    public void initialize() {
        s3TextArea.setText(mainController.getStore().toString());
        s3ComboBox.getItems().addAll(this.mainController.getStore().orders);
        s3TotalPriceTextField.setText(df.format(this.mainController.getStore().calculateTotal()) + "");
    }

    /**
     * Deletes the order from the store orders. Reconfigures text areas and combobox and recalculates the total
     * @param event Event when user presses Delete Order Button
     */
    @FXML
    public void deleteOrder(ActionEvent event) {
        if (s3ComboBox.getSelectionModel().getSelectedItem() == null) return;

        this.mainController.getStore().remove(s3ComboBox.getSelectionModel().getSelectedItem());
        s3ComboBox.getItems().clear();
        s3ComboBox.getItems().addAll(this.mainController.getStore().orders);
        s3TextArea.setText(mainController.getStore().toString());
        s3TotalPriceTextField.setText(df.format(this.mainController.getStore().calculateTotal()) + "");
        s3ExportTextField.setText("");
    }

    /**
     * Exports the placed store orders to a text file, "StoreOrders.txt", unless the store orders are empty
     * @param event Event when user presses Export Orders button
     * @throws FileNotFoundException Exception when file doesn't exist
     */
    @FXML
    public void export(ActionEvent event) throws FileNotFoundException {
        if (mainController.getStore().orders.isEmpty()) {
            s3ExportTextField.setText("No orders available to export.");
            return;
        }
        File file = new File("StoreOrders.txt");
        PrintWriter pw = new PrintWriter(file);
        pw.print(mainController.getStore().toString());
        pw.close();
        s3ExportTextField.setText("File Created: StoreOrders.txt");
    }
}

