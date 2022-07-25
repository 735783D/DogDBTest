package com.example.dogdbtest;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class mysqlconnect {
    private static final String protocol = "jdbc";
    private static final String vendorName = ":mysql:";
    private static final String ipAddress = "//localhost:3306";
    private static final String dbName = "usersdb";

    private static final String jdbcURL = protocol + vendorName + ipAddress + "/" + dbName;

    private static final String MYSQLJBCDriver = "com.mysql.jdbc.Driver";

    private static final String username = "root";
    private static final String password = "toor";
    private static Connection conn = null;
    public static Connection ConnectDb() throws ClassNotFoundException {

        try{
            Class.forName(MYSQLJBCDriver);
            conn = DriverManager.getConnection(jdbcURL, username, password);
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/usersdb");

            System.out.println("Connection Established");
            return conn;
        }catch (Exception e){
            System.out.println("It's broke!" + e);
            return null;
        }
    }
    public static ObservableList<dogs> getDatausers() throws ClassNotFoundException {
        Connection conn = ConnectDb();
        ObservableList<dogs> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = conn.prepareStatement("select * from dogs");
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                list.add(new dogs(Integer.parseInt(rs.getString("id")), Integer.parseInt(rs.getString("lifespan")), rs.getString("breed"), Double.parseDouble(rs.getString("price")), Boolean.parseBoolean(rs.getString("vaccinated"))));
            }
        }catch (Exception e){

        }

        return list;

    }
}
