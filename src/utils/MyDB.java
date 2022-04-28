/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyDB{
    
    
    
//    InputStream is;
//    OutputStream os;
//    Properties p;
    final String URL ="jdbc:mysql://localhost:8889/geek";
    final  String LOGIN ="root";
    final  String PASSWORD ="root";
    static   private Connection cnx;
    static  private MyDB instance ;
    
   private MyDB(){
//       p=new Properties();
//       try{
//        os = new FileOutputStream("connexionData.properties");
//       }catch(FileNotFoundException ex){
//           System.out.print(ex);
//       }
//       p.setProperty("url","jdbc:mysql://localhost:8889/geek");
//       p.setProperty("login","root");
//       p.setProperty("password","root");      
//       try{
//        p.store(os, null);
//        
//       }catch(IOException ex){
//           System.out.print(ex);
//       }
       try{
//        this.is = new FileInputStream("connexionData.properties");
//        p.load(is);
//        System.out.println(p.getProperty("url"));
//       
//        String url=p.getProperty("url");
//        
//        String login=p.getProperty("login");
//        String password=p.getProperty("password");
//       
//       System.out.println(p.toString());

           //cnx = DriverManager.getConnection("jdbc:mysql://localhost:8889/geek",p);
           cnx = DriverManager.getConnection(URL,LOGIN,PASSWORD);
           System.out.println("Connexion reussie ......");
       } catch (Exception ex) {
           System.out.println("la classe mydb    hhhhh");
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
