package data;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionWorkbenchDB {
   public static Connection Conectar() {
       try {
           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection con = DriverManager.getConnection(
                   "jdbc:mysql://localhost:3306/universidad_harvard", 
                    "root",
                    "Bruselas2025.");
           return con;
       } catch(Exception ex) {
           return null;
       }
   }
}
