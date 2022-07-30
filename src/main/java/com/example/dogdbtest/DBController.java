package com.example.dogdbtest;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class DBController implements Initializable {

    @FXML
    private TableColumn<dogs, String> col_breed;

    @FXML
    private TableColumn<dogs, Integer> col_id;

    @FXML
    private TableColumn<dogs, Integer> col_lifespan;

    @FXML
    private TableColumn<dogs, Double> col_price;

    @FXML
    private TableColumn<dogs, String> col_special;

    @FXML
    private TableColumn<dogs, Boolean> col_vaccinated;

    @FXML
    private TableView<dogs> table_users;

    @FXML
    private TextField txt_breed;

    @FXML
    private TextField txt_id;

    @FXML
    private TextField txt_lifespan;

    @FXML
    private TextField txt_price;

    @FXML
    private TextField txt_special;

    @FXML
    private TextField txt_vaccinated;

    ObservableList<dogs> listM;

    int index = -1;

    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;

    public void Add_dogs() throws ClassNotFoundException {
        conn = mysqlconnect.ConnectDb();
        String sql = "insert into dogs (id,breed,lifespan,price,vaccinated,special)values(?,?,?,?,?,?)";
                try {
                    pst = conn.prepareStatement(sql);
                    pst.setInt(1, Integer.parseInt(txt_id.getText()));
                    pst.setString(2, txt_breed.getText());
                    pst.setInt(3, Integer.parseInt(txt_lifespan.getText()));
                    pst.setDouble(4, Double.parseDouble(txt_price.getText()));
                    pst.setBoolean(5, Boolean.parseBoolean(txt_vaccinated.getText()));
                    pst.setString(6, txt_special.getText());
                    pst.execute();

                    Alert alert = new Alert(Alert.AlertType.INFORMATION,"Doggo Added");
                    System.out.println("This worked!");
                }catch (Exception e){
                    Alert alert = new Alert(Alert.AlertType.INFORMATION,"It broke!");
                    System.out.println("Didn't work!");
                }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb){
        col_id.setCellValueFactory(new PropertyValueFactory<dogs,Integer>("id"));
        col_breed.setCellValueFactory(new PropertyValueFactory<dogs,String >("breed"));
        col_lifespan.setCellValueFactory(new PropertyValueFactory<dogs,Integer>("lifespan"));
        col_price.setCellValueFactory(new PropertyValueFactory<dogs,Double>("price"));
        col_vaccinated.setCellValueFactory(new PropertyValueFactory<dogs,Boolean>("vaccinated"));
        col_special.setCellValueFactory(new PropertyValueFactory<dogs, String>("special"));
        try {
            listM = mysqlconnect.getDatausers();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        table_users.setItems(listM);

    }
}