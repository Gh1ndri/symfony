/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyDB {
    
    final  String URL ="jdbc:mysql://localhost:8889/geek";
    final  String LOGIN ="root";
    final  String PASSWORD ="root";
    static   private Connection cnx;
    static  private MyDB instance ;
    
   private MyDB(){
       
       
       try {
           cnx = DriverManager.getConnection(URL, LOGIN, PASSWORD);
           System.out.println("Connexion reussie ......");
       
       } catch (SQLException ex) {
           System.out.print("la classe mydb    hhhhh");
           System.out.println(ex.getMessage());      
       
       }
      
   }
   
  static public MyDB getInstance(){
       if(instance==null)
       instance= new MyDB();
       
       return instance;//null
   }
  
  static public Connection getCnx (){
      return cnx;
  }
}
