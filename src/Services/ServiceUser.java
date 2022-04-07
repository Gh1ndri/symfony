/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Model.User;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.util.List;
import utils.MyDB;

/**
 *
 * @author leith
 */
public class ServiceUser implements Service<User> {
    
    private Connection cnx = MyDB.getInstance().getCnx() ;

    @Override
    public void ajouter(User t) {
        
        try {
        String querry= "INSERT INTO `User`(`email`, `username`, `role`, `password`) VALUES ('"+t.getEmail()+"','"+t.getUsername()+"','"+t.getRole()+"','"+t.getPassword()+"')";
        Statement stm = cnx.createStatement();
    
        stm.executeUpdate(querry);
    } catch (SQLException ex) {
        System.out.println("service classe ajouter methode  ");
        System.out.println(ex.getMessage());
    
    }
        
    }

    @Override
    public List<User> afficher() {
        
        List<User> users = new ArrayList();
        try {
       
        String querry ="SELECT * FROM `User`";
        Statement stm = cnx.createStatement();
        
            ResultSet rs= stm.executeQuery(querry);
            
        while (rs.next()){
            User p = new User();
            
            p.setId(rs.getInt(1));
            p.setUsername(rs.getString(3));
            p.setEmail(rs.getString(2));
            p.setRole(rs.getString(4));
            p.setPassword(rs.getString(5));
            
            users.add(p);
        }
        return users;
    } catch (SQLException ex) {
        System.out.print(ex);
        }
    return users;
    }

    @Override
    public void modifier(String t2,User t) {
       
        try {
        String querry= "UPDATE `User` SET `email`='"+t.getEmail()+"',`username`='"+t.getUsername()+"',`role`='"+t.getRole()+"',`password`='"+t.getPassword()+"' WHERE email='"+t2+"'";
        Statement stm = cnx.createStatement();
    
        stm.executeUpdate(querry);
        if(stm.executeUpdate(querry)==1){
            System.out.print("user modifier");
        }
    
        } catch (SQLException ex) {
            System.out.println("service classe modif methode  ");
            System.out.println(ex.getMessage());

        }
    }

    @Override
    public void supprimer(String t) {
        
        try {
        String querry= "DELETE FROM `User` WHERE email ='"+t+"'";
        Statement stm = cnx.createStatement();
    
        stm.executeUpdate(querry);
        if(stm.executeUpdate(querry)==1){
            System.out.print("user supprimer");
        }
        } catch (SQLException ex) {
            System.out.println("service classe supprimer methode  ");
            System.out.println(ex.getMessage());

        }
    }

    @Override
    public void TruncateTable() {
        
        try {
        String querry= "TRUNCATE TABLE `User`";
        Statement stm = cnx.createStatement();
    
        stm.executeUpdate(querry);
    
        } catch (SQLException ex) {
            System.out.println("service classe vider table methode  ");
            System.out.println(ex.getMessage());

        }
    }
//    public boolean login(String email, String password){
//        
//        List<User> users = new ArrayList();
//        try {
//        String querry ="SELECT * FROM `User` where email ='"+email+"' and password ='"+password+"'";
//        Statement stm = cnx.createStatement();
    //User u = n.....
//        ResultSet rs= stm.executeQuery(querry);
//    while (rs.next()){
//       
//        
//        p.setId(rs.getInt(1));
//        p.setUsername(rs.getString(1));
//        p.setEmail(rs.getString(1));
//        p.setRole(rs.getString(1));
//        p.setPassword(rs.getString(1));
//        System.out.print(p);
//        }re
//    
//    } catch (SQLException ex) {
//        System.out.print(ex);
//        }
//       return false;
//    }
//    
//    public boolean Existmail(String s){
//        List<User> users = new ArrayList();
//        try {
//       
//        String querry ="SELECT email FROM `User` where email="+s;
//        Statement stm = cnx.createStatement();
//        ResultSet rs= stm.executeQuery(querry);
//            
//        while (rs.next()){
//            User p = new User();
//            
//            p.setId(rs.getInt(1));
//            p.setUsername(rs.getString(3));
//            p.setEmail(rs.getString(2));
//            p.setRole(rs.getString(4));
//            p.setPassword(rs.getString(5));
//            
//            users.add(p);
//        }
//        } catch (SQLException ex) {
//            System.out.print(ex);
//        }
//        if(rs.getColumnCount()){
//            
//        }
//        return false;
//    }
//    
}
