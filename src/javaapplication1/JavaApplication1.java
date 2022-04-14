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
import static java.time.zone.ZoneRulesProvider.refresh;
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
//        System.out.print("saisir :");
//        String operation=sc.nextLine();
//        System.out.println(serviceUser.rechercherUser(operation).toString());

            System.out.println(serviceUser.tri().toString());

//        while(true){
//            System.out.print("Veuillez saisir l'opération a/ajouter s/supprimer m/modifier A/afficher l/login: ");
//            String operation = sc.nextLine();
//            if(operation.equals("a")){
//                System.out.print("vous allez saisir user ou team ?:");
//                String type = sc.nextLine();
//                    if(type.equals("user")){
//                        System.out.print("saisir le mail :");
//                        String email = sc.nextLine();
//                        System.out.print("saisir le usesrname :");
//                        String username = sc.nextLine();
//                        System.out.print("saisir le password :");
//                        String password = sc.nextLine();
//                        User s =new User(email,username,"Role_USER",password);
//                        serviceUser.ajouter(s);
//                    }else if(type.equals("team")){
//                        System.out.print("saisir le teamname :");
//                        String teamname = sc.nextLine();
//                        System.out.print("saisir la description :");
//                        String description = sc.nextLine();
//                        Team t =new Team(teamname,description);
//                        serviceTeam.ajouter(t);
//                    }else{
//                        System.out.println("choix uncorrecte!");
//                    }
//            }else if(operation.equals("s")){
//                System.out.print("voulez vous supprimer un user ou un team ?:");
//                String type2 = sc.nextLine();
//                if(type2.equals("user")){
//                    System.out.println(serviceUser.afficher().toString());
//                    System.out.print("choisir l'email de l'utilisateur :");
//                    String email2 = sc.nextLine();
//                    serviceUser.supprimer(email2);
//                }else if(type2.equals("team")){
//                    System.out.println(serviceTeam.afficher().toString());
//                    System.out.print("choisir le teamname du team :");
//                    String teamname2 = sc.nextLine();
//                    serviceTeam.supprimer(teamname2);
//                }else{
//                    System.out.println("choix uncorrecte!");
//                }
//            }else if(operation.equals("m")){
//                 System.out.print("voulez vous modifier un user ou un team ?:");
//                 String type3 = sc.nextLine();
//                 if(type3.equals("user")){
//                    System.out.println(serviceUser.afficher().toString());
//                    System.out.print("choisir l'email de l'utilisateur :");
//                    String email3 = sc.nextLine();
//                     System.out.print("saisir le mail :");
//                        String email = sc.nextLine();
//                        System.out.print("saisir le usesrname :");
//                        String username = sc.nextLine();
//                        System.out.print("saisir le password :");
//                        String password = sc.nextLine();
//                        User s =new User(email,username,"Role_USER",password);
//                        serviceUser.modifier(email3,s);
//                }else if(type3.equals("team")){
//                    System.out.println(serviceTeam.afficher().toString());
//                    System.out.print("choisir le teamname du team :");
//                    String teamname3 = sc.nextLine();
//                    System.out.print("saisir le teamname :");
//                        String teamname = sc.nextLine();
//                        System.out.print("saisir le description :");
//                        String description = sc.nextLine();
//                        Team t =new Team(teamname,description);
//                        serviceTeam.modifier(teamname3,t);
//                }else{
//                    System.out.println("choix uncorrecte!");
//                }   
//            }else if(operation.equals("A")){
//                    System.out.print("voulez vous afficher users ou teams ?:");
//                    String type = sc.nextLine();
//                    if(type.equals("user")){
//                    System.out.println(serviceUser.afficher().toString());
//                    }else if(type.equals("team")){
//                    System.out.println(serviceTeam.afficher().toString());
//                    }
//            }else if(operation.equals("l")){
//                    System.out.print("saisissez votre email:");
//                    String email = sc.nextLine();
//                    System.out.print("saisissez votre password:");
//                    String password = sc.nextLine();
//                    serviceUser.login(email,password);
//            }else{
//            System.out.println("vous avez rien choisi");
//            exit(-1);
//            }
//        }
    }
}
