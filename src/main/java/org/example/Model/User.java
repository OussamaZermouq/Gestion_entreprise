package org.example.Model;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import org.example.Model.DB_connection.*;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class User {
    public int id;
    public String name;
    public String last_name;
    public int age;
    public String email;
    public String username;
    public String password;


    //database connection to be used in functions
    DB_connection db = new DB_connection();


    public User(){

    }

    public User(int id,String name, String last_name, String email, int age, String username, String password) {
        this.id = id;
        this.name = name;
        this.last_name = last_name;
        this.email = email;
        this.age = age;
        this.username = username;
        this.password = password;
    }

    public boolean login(String username, String password) throws SQLException {

        String user = '"'+username+'"';
        String pass = '"'+password+'"';
        String sql = "select count(*) as user_count from users where username = "+user+" and password ="+pass;
        ResultSet login_result = db.execute_query(sql);
        if (login_result.getInt("user_count")==1){
            System.out.println("Successful login");
            return true;
        }
        return false;

    }

    public User get_info(String username, String password) throws SQLException {
        User user_logged = null;
        String user = '"'+username+'"';
        String pass = '"'+password+'"';
        if (login(username, password)){
            String sql_success_check = "select * from users where username = "+user+" and password ="+pass;
            ResultSet user_info = db.execute_query(sql_success_check);
            user_logged = new User(user_info.getInt("id"),
                    user_info.getString("name"),
                    user_info.getString("last_name"),
                    user_info.getString("email") ,
                    user_info.getInt("age"),
                    user_info.getString("username"),
                    user_info.getString("password"));
        }
        return user_logged;
    }


}
