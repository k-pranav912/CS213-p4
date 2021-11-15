module com.p4.cs213p4 {
    requires javafx.controls;
    requires javafx.fxml;
    requires junit;


    opens com.pizzashop to javafx.fxml;
    exports com.pizzashop;
}