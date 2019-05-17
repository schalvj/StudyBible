package Connectivity;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionClass {
    private Connection connection;

    public Connection getConnection(){

        String dbName= "bible_app";
        String userName= "root";
        String password= "";

        try {
            Class.forName("com.mysql.jdbc.Driver");

            connection= DriverManager.getConnection("jdbc:mysql://localhost:8080/"+dbName,userName,password);
        }catch (Exception e){
            e.printStackTrace();
        }


        return connection;
    }
}
