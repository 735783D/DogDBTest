module com.example.dogdbtest {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.dogdbtest to javafx.fxml;
    exports com.example.dogdbtest;
}