package org.example.Model;

import java.sql.*;

public class DB_connection {
        public static String url = "jdbc:mysql://localhost";
        public static String port = "3306";
        public static String db_name = "gestion_entreprise";

        public static String user = "root";
        public static String password = "";
        public static java.sql.Connection connection = null;
        public static Connection connect_to_db(){
            try{
                connection = DriverManager.getConnection(url+":"+port+"/"+db_name, user, password);
                System.out.println("Connected to DB!");
                return connection;

            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
            //always check if the connection is null so that we know that there is an error in the connection
            return connection;
        }
        public ResultSet execute_query(String query){
            connection = connect_to_db();
            PreparedStatement preparedStatement = null;
            ResultSet resultSet = null;
            try{
                preparedStatement = connection.prepareStatement(query);
                resultSet = preparedStatement.executeQuery();
                resultSet.next();
                return resultSet;
            }
            catch (SQLException e){
                System.err.println(e.getMessage());
            }
            return null;
        }
        public int execute_query_UD(String query){
            connection = connect_to_db();
            PreparedStatement preparedStatement = null;
            ResultSet resultSet = null;
            try{
                preparedStatement = connection.prepareStatement(query);
                return preparedStatement.executeUpdate();
            }
            catch (SQLException e){
                System.err.println(e.getMessage());
            }
            return 0;
        }

    public static void main(String[] args) {

    }
}
