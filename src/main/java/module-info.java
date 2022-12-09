module com.example.javafxtest2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.RandomForceGenerator to javafx.fxml;
    exports com.example.RandomForceGenerator;
}