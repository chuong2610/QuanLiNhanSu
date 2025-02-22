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

/**
 *
 * @author ADMIN
 */
public class DBUltils {
     private static final String DB_Name="project_qlns";
    private static final String DB_Username="sa";
    private static final String DB_Password="12345"; 
    
    public static Connection Connection() throws ClassNotFoundException, SQLException{
        Connection c = null;
        
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url ="jdbc:sqlserver://localhost:1433;databaseName="+DB_Name;
        c=DriverManager.getConnection(url, DB_Username, DB_Password);
        return c;
        
    }
}
