/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import Model.Team;
import Model.User;
import Services.ServiceTeam;
import Services.ServiceUser;
import static java.lang.System.exit;
import java.util.Scanner;

/**
 *
 * @author leith
 */
public class JavaApplication1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        ServiceUser serviceUser = new ServiceUser();
        ServiceTeam serviceTeam = new ServiceTeam();
        
        
        while(true){
            System.out.print("Veuillez saisir l'opération :");
            String operation = sc.nextLine();
            if(operation.equals("a")){
                System.out.print("vous allez saisir user ou team ?:");
                String type = sc.nextLine();
                    if(type.equals("user")){
                        System.out.print("saisir le mail :");
                        String email = sc.nextLine();
                        System.out.print("saisir le usesrname :");
                        String username = sc.nextLine();
                        System.out.print("saisir le password :");
                        String password = sc.nextLine();
                        User s =new User(email,username,"Role_USER",password);
                        serviceUser.ajouter(s);
                        System.out.print("saisir le password :");
                    }else if(type.equals("team")){
                        System.out.println("vous avez saisi team");
                    }else{
                        System.out.println("choix uncorrecte!");
                    }
            }else if(operation.equals("s")){
                System.out.println("vous avez choisi supprimer");
            }else if(operation.equals("m")){
                System.out.println("vous avez choisi modifier");
            }else{
                System.out.println("vous avez rien choisi");
                exit(-1);
            }
        }
        
//        User s1 =new User("lay@com","layth","Role_ADMIN","aaa");
//        User s2 =new User("hamza@com","hamza","Role_ADMIN","aaa");
//        User s3 =new User("jalel@com","jalel","Role_ADMIN","aaa");
//        User s4 =new User("manoubia@com","manoubia","Role_ADMIN","aaa");
//        Team t1 =new Team("team 1","sdfmqsfsdfm");
//        Team t2 =new Team("team 2","sdfmqsfsdfmQSq");
//        Team t3 =new Team("team 3","sdfmqsfsdfmqsds");
//        Team t4 =new Team("team 4","sdfmqsfsdfmqsQSDQ");
//           
//        ServiceUser serviceUser = new ServiceUser();
//        ServiceTeam serviceTeam = new ServiceTeam();
//        
//        serviceUser.ajouter(s1);
//        serviceUser.ajouter(s2);
//        serviceUser.ajouter(s3);
//        serviceUser.ajouter(s4);
//        
//        serviceTeam.ajouter(t1);
//        serviceTeam.ajouter(t2);
//        serviceTeam.ajouter(t3);
//        serviceTeam.ajouter(t4);
//        
        
//        serviceTeam.TruncateTable();
//        serviceUser.TruncateTable();
//        System.out.println(serviceUser.afficher().toString());
//        System.out.println(serviceTeam.afficher().toString());
//        System.out.println(t2.toString());
//        serviceTeam.supprimer(t2);
//        serviceUser.supprimer(s2);
//        System.out.println("aprés supprission");
//        System.out.println(serviceTeam.afficher().toString());
//        System.out.println(serviceUser.afficher().toString());
//        serviceUser.modifier(s1, s4);
//        System.out.println(serviceUser.afficher().toString());
//        System.out.print(serviceUser.login("manoubia@com","aaa"));
//        

        
    }
    
}
