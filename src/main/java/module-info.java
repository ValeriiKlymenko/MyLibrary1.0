module com.example.mylibrary1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.mylibrary1 to javafx.fxml;
    exports com.example.mylibrary1;
}