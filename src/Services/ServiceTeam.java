/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Model.Team;
import Model.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utils.MyDB;

/**
 *
 * @author leith
 */
public class ServiceTeam implements Service<Team>{
    
    private Connection cnx = MyDB.getInstance().getCnx() ;

    @Override
    public void ajouter(Team t) {
        
        try {
        String querry= "INSERT INTO `Team`(`TeamName`, `Description`) VALUES ('"+t.getTeamName()+"','"+t.getDescription()+"')";
        Statement stm = cnx.createStatement();
    
        stm.executeUpdate(querry);

        } catch (SQLException ex) {
            System.out.println("service classe ajouter methode  ");
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Team> afficher() {
        
        List<Team> teams = new ArrayList();
        try {
       
        String querry ="SELECT * FROM `Team`";
        Statement stm = cnx.createStatement();
            ResultSet rs= stm.executeQuery(querry);
        while (rs.next()){
            Team p = new Team();
            
            p.setId(rs.getInt(1));
            p.setTeamName(rs.getString(2));
            p.setDescription(rs.getString(3)); 
            teams.add(p);
        }

        return teams;
        } catch (SQLException ex) {
            }
        return teams;
    }

    @Override
    public void modifier(String a,Team t) {
        
        try {
        String querry= "UPDATE `Team` SET `TeamName`='"+t.getTeamName()+"',`Description`='"+t.getDescription()+"' WHERE TeamName='"+a+"'";
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
        String querry= "DELETE FROM `Team` WHERE TeamName ='"+t+"'";
        Statement stm = cnx.createStatement();
        stm.executeUpdate(querry);
    
        } catch (SQLException ex) {
            System.out.println("service classe supprimer methode  ");
            System.out.println(ex.getMessage());
        }
    }

//    @Override
//    public void TruncateTable() {
//        
//        try {
//        String querry= "TRUNCATE TABLE `Team`";
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

    

    

    
}
