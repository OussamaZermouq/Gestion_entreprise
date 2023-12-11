package org.example.Model;

import org.example.Model.DB_connection.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class User {
    public String name;
    public String last_name;
    public int age;
    public String email;
    public String username;
    public String password;
    public DB_connection db_connection;

    public User(){

    }

    public User(String username, String password, String name, String last_name, String email, int age, DB_connection db_connection) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.last_name = last_name;
        this.email = email;
        this.age = age;
        this.db_connection = db_connection;
    }

    public boolean login(String username, String password) throws SQLException {
        DB_connection db = new DB_connection();
        ResultSet login_result = db.execute_query("select count(*) as user_count from users where username = "+username+" and password = "+password);
        System.out.println(login_result.getInt("user_count"));

        return false;

    }
}
