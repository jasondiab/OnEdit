/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usersystem;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author Diabj
 */
public class Connect {
    
    static final String DB_URL = "jdbc:mysql://localhost:3308/logindb";
    static final String USER = "root";
    static final String PASS = "";
    
    public static Connection connectdb(){
        Connection conn = null;
        try{
            //register jdbc driver but isnt required for newer versions of jdk
            //Class.forName("com.mysql.cj.jdbc.Driver");
            //open a connection
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            return conn;
        }catch(SQLException ex){
            System.out.println("An error occured connecting to the database");
            return null;
        }
    }
}
