package com.example.dogdbtest;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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

    ObservableList<dogs> listM;

    int index = -1;

    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    @Override
    public void initialize(URL url, ResourceBundle rb){
        col_id.setCellValueFactory(new PropertyValueFactory<dogs,Integer>("id"));
        col_breed.setCellValueFactory(new PropertyValueFactory<dogs,String >("breed"));
        col_lifespan.setCellValueFactory(new PropertyValueFactory<dogs,Integer>("lifespan"));
        col_price.setCellValueFactory(new PropertyValueFactory<dogs,Double>("price"));
        col_vaccinated.setCellValueFactory(new PropertyValueFactory<dogs,Boolean>("vaccinated"));

        try {
            listM = mysqlconnect.getDatausers();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        table_users.setItems(listM);

    }
}