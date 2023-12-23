package org.example.Model;

import java.sql.*;

public class DB_connection {
        public String url = "jdbc:mysql://localhost";
        public String port = "3306";
        public String db_name = "gestion_entreprise";

        public String user = "root";
        public String password = "";
        java.sql.Connection connection = null;
        public Connection connect_to_db(){
            try{
                connection = DriverManager.getConnection(url+":"+port+"/"+db_name, user, password);

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
}
