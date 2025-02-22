/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ultils;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class DBUltils {
     private static final String DB_Name="quanlinhansu";
    private static final String DB_Username="sa";
    private static final String DB_Password="12345"; 
    
    public static Connection getConnection() throws ClassNotFoundException, SQLException{
        Connection c = null;
        
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url ="jdbc:sqlserver://localhost:1433;databaseName="+DB_Name;
        c=DriverManager.getConnection(url, DB_Username, DB_Password);
        return c;
        
    }
    public static void main(String[] args) {
        try {
            Connection c =  getConnection();
            System.out.println(c);    
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBUltils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBUltils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   

   
}
