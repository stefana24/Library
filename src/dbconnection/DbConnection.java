package dbconnection;

/*
1. import the packages
2. Load and register jdbc driver
3. open a connection with DriverManager.getConnection method


close all the database resources
 */

import java.sql.*;
public class DbConnection {

    private static final String url="jdbc:sqlserver://DESKTOP-LSU9RMJ\\SQLEXPRESS;databaseName=Library";
    //database credentials
    private static final String user="orderuser";
    private static final String password="stefana1234";

    private static DbConnection singleInstance = new DbConnection();

    //singleton pattern
    private DbConnection(){
        try{
            //register driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    private Connection createConnection(){
        Connection connection = null;
        try{
            connection = DriverManager.getConnection(url,user,password);
        }catch(SQLException e){
            e.printStackTrace();
        }
        return connection;
    }

    public static Connection getConnection(){
        return singleInstance.createConnection();
    }

    public static void close(Connection connection){
        if(connection!=null){
            try{
                connection.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
    }

}
