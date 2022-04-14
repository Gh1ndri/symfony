
package Services;

import Model.User;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.util.List;
import java.util.prefs.Preferences;
import utils.MyDB;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.System.Logger;
import static java.time.zone.ZoneRulesProvider.refresh;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 *
 * @author leith
 */
public class ServiceUser implements Service<User> {
   
    private Connection cnx = MyDB.getInstance().getCnx() ;
    public static User user;
    ServiceTeam serviceTeam =new ServiceTeam();
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

//    @Override
//    public void TruncateTable() {
//        
//        try {
//        String querry= "TRUNCATE TABLE `User`";
//        Statement stm = cnx.createStatement();
//    
//        stm.executeUpdate(querry);
//    
//        } catch (SQLException ex) {
//            System.out.println("service classe vider table methode  ");
//            System.out.println(ex.getMessage());
//
//        }
//    }
    public boolean login(String email, String password){
        
        try {
           
        String querry ="SELECT * FROM `User` where email ='"+email+"' and password ='"+password+"'";
        Statement stm = cnx.createStatement();
        ResultSet rs= stm.executeQuery(querry);

        if(!rs.isBeforeFirst()){
            System.out.println("user not found !!!!");
            return false;
        }
        else{
            System.out.println("user is logged");
            while(rs.next()){
                LoginSession.UID=rs.getInt("id");
                LoginSession.Role=rs.getString("role");
                LoginSession.Username=rs.getString("username");
                LoginSession.Email=rs.getString("email");
                LoginSession.Password=rs.getString("password"); 
                LoginSession.IsLogged=true;
            }
            System.out.println(LoginSession.Username+" is connected");
            return true;
        }
        } catch (SQLException ex) {
            //System.out.println(ex);
        }
        return false;
    }  
    
    public void logout(){
        LoginSession.IsLogged=false;
    }
    
    public List<User> rechercherUser(String n){
        refresh();
        List<User> users = new ArrayList();
        try {
        String querry ="SELECT id,username,email,password,role FROM `User` where email like '%"+n+"%' or username like '%"+n+"%' or role like '%"+n+"%'";
        Statement stm = cnx.createStatement();
        ResultSet rs= stm.executeQuery(querry);
        System.out.println(querry);
        while (rs.next()){
            User p = new User();
            p.setId(rs.getInt(1));
            p.setUsername(rs.getString(2));
            p.setEmail(rs.getString(3));
            p.setRole(rs.getString(4));
            p.setPassword(rs.getString(5));
            users.add(p);
        }
        
        } catch (SQLException ex) {
            System.out.print(ex);
        }
        return users;
    }
    
    public TreeSet<User> tri(){
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
        TreeSet<User> userTri =users.stream().collect(Collectors.toCollection(()-> new TreeSet<User>((a,b)->a.getUsername().compareTo(b.getUsername()))));
        return userTri;
        } catch (SQLException ex) {
            System.out.print(ex);
        }
        return null;
    }
    
  
}

    

