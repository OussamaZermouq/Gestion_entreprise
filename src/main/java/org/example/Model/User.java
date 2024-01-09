package org.example.Model;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import org.example.Interfaces.MDIParent;
import org.example.Model.DB_connection.*;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class User {
    public int id;
    public static String name;
    public static String last_name;
    public static int age;
    public static String email;
    public String username;
    public static String password;


    //database connection to be used in functions
    static DB_connection db = new DB_connection();
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
    public static void modify_info(User user_info){
        //this function takes as an argument the same logged_in user but with modified info

        db = MDIParent.db_connection;
        name = user_info.name;
        last_name = user_info.last_name;
        email = user_info.email;
        age = user_info.age;
        password = user_info.password;
        db.execute_query_UD("update users set name = '"+name+"',last_name = '"+last_name+"',age = '"+age+"',email = '"+email+"',password = '"+password+"' where id="+user_info.id+"");
    }
}
