module com.p4.cs213p4 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.pizzashop to javafx.fxml;
    exports com.pizzashop;
}