package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DbConnection {


    private    final String   username="root";

    private    final String   password="Root";


    private   final  String url="jdbc:mysql://localhost:3306/sakshidb";

    public    Connection getConnection() throws SQLException {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e){
            throw  new RuntimeException("driver not found exception"+ e);
        }

        return DriverManager.getConnection(url, username, password);
    }





}
