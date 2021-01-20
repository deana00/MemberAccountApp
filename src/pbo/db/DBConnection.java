/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbo.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CIKA
 */
public class DBConnection {
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private static final String DB = "memberaccountapp";
    private static final String MYCONN = "jdbc:mysql://localhost/"+DB;
    
    public static Connection getConnection(String driver) throws SQLException {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
//            System.out.println("Library Exists!");
            conn = DriverManager.getConnection(MYCONN, USER, PASSWORD);
        } catch (ClassNotFoundException ex) {
            System.out.println("Library doesnt Exists!");
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }
}
