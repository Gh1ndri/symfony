/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Model.User;
import Services.ServiceUser;
import java.awt.print.Book;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import static java.time.zone.ZoneRulesProvider.refresh;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author leith
 */
public class DashboardController implements Initializable {

    @FXML
    private Button user;
    @FXML
    private Button team;
    @FXML
    private TextField search;
    @FXML
    private ImageView pdf;
    @FXML
    private ImageView delete;
    @FXML
    private ImageView refresh;
    @FXML
    private ChoiceBox<String> choiceBox;
    @FXML
    private Label time;
    @FXML
    private TableColumn<User, String> culumnEmail;
    @FXML
    private TableColumn<User, String> culumnIsActive;
    @FXML
    private TableColumn<User, String> culumnRole;
    @FXML
    private TableColumn<User, String> culumnUsername;
    @FXML
    private TableView<User> usersTable;
    
    ObservableList<User> listM;
//    @FXML
//    private ListView<String> list;
//    public List<String> list1;
//    public List<String> list2;
//    public List<String> list3;
//    private List<String> l;
    
    private volatile boolean stop=false;
    ServiceUser serviceUser =new ServiceUser();
    
    
    private Stage stage; 
    private Scene scene;
    private Parent root;
    @FXML
    private TableColumn<?, ?> culumnTeam;
    @FXML
    private ImageView frontgo;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        time();
        listM=serviceUser.afficher();
        culumnEmail.setCellValueFactory(new PropertyValueFactory<User,String>("email"));
        culumnUsername.setCellValueFactory(new PropertyValueFactory<User,String>("username"));
        culumnRole.setCellValueFactory(new PropertyValueFactory<User,String>("role"));
        culumnIsActive.setCellValueFactory(new PropertyValueFactory<User,String>("isactive"));
        usersTable.setItems(listM);
        
        choiceBox.getItems().add("Username");
        choiceBox.getItems().add("Email");
        choiceBox.getItems().add("Isactive");
        
        choiceBox.valueProperty().addListener((obs, oldItem, newItem) -> {
            if (newItem == "Username") {
                listM=serviceUser.triWithUsername();
                culumnEmail.setCellValueFactory(new PropertyValueFactory<User,String>("email"));
                culumnUsername.setCellValueFactory(new PropertyValueFactory<User,String>("username"));
                culumnRole.setCellValueFactory(new PropertyValueFactory<User,String>("role"));
                culumnIsActive.setCellValueFactory(new PropertyValueFactory<User,String>("isactive"));
                usersTable.setItems(listM);
            } else if(newItem == "Email"){
                listM=serviceUser.triWithEmail();
                culumnEmail.setCellValueFactory(new PropertyValueFactory<User,String>("email"));
                culumnUsername.setCellValueFactory(new PropertyValueFactory<User,String>("username"));
                culumnRole.setCellValueFactory(new PropertyValueFactory<User,String>("role"));
                culumnIsActive.setCellValueFactory(new PropertyValueFactory<User,String>("isactive"));
                usersTable.setItems(listM);
            }else if(newItem == "Isactive"){
                listM=serviceUser.triWithIsActive();
                culumnEmail.setCellValueFactory(new PropertyValueFactory<User,String>("email"));
                culumnUsername.setCellValueFactory(new PropertyValueFactory<User,String>("username"));
                culumnRole.setCellValueFactory(new PropertyValueFactory<User,String>("role"));
                culumnIsActive.setCellValueFactory(new PropertyValueFactory<User,String>("isactive"));
                usersTable.setItems(listM);
            }
        });
    }    

    @FXML
    public void supp(MouseEvent event){
        
            Alert alert= new Alert(AlertType.CONFIRMATION);
            alert.setTitle("confirmation Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure to delete ?");
            Optional <ButtonType> action =alert.showAndWait();
            if(action.get()==ButtonType.OK){
                    User user= new User();
                    user=usersTable.getSelectionModel().getSelectedItem();
                    serviceUser.supprimer(user);
                    listM.removeAll(listM);
                    listM=serviceUser.afficher();
                    culumnEmail.setCellValueFactory(new PropertyValueFactory<User,String>("email"));
                    culumnUsername.setCellValueFactory(new PropertyValueFactory<User,String>("username"));
                    culumnRole.setCellValueFactory(new PropertyValueFactory<User,String>("role"));
                    culumnIsActive.setCellValueFactory(new PropertyValueFactory<User,String>("isactive"));
                    usersTable.setItems(listM);
            }   
    }
    @FXML
    public void affiche(){
        refresh.setOnMouseClicked(e->{
            listM.removeAll(listM);
                listM=serviceUser.afficher();
                culumnEmail.setCellValueFactory(new PropertyValueFactory<User,String>("email"));
                culumnUsername.setCellValueFactory(new PropertyValueFactory<User,String>("username"));
                culumnRole.setCellValueFactory(new PropertyValueFactory<User,String>("role"));
                culumnIsActive.setCellValueFactory(new PropertyValueFactory<User,String>("isactive"));
                usersTable.setItems(listM);
        });
    }

    private void time(){
        Thread thread =new Thread(()->{
            SimpleDateFormat d= new SimpleDateFormat("yyyy-MM-dd/hh:mm:ss");
            while(!stop){
                try{
                    Thread.sleep(1000);
                }catch(Exception e){
                    System.err.print(e);
                }
                final String timenow =d.format(new Date());
                Platform.runLater(()->{
                    time.setText(timenow);
                });
            }
        });
        thread.start();
    }
    
    @FXML
    public void search(){
        User user= new User();
        listM.removeAll(listM);
        listM=serviceUser.rechercherUser(search.getText());
        culumnEmail.setCellValueFactory(new PropertyValueFactory<User,String>("email"));
        culumnUsername.setCellValueFactory(new PropertyValueFactory<User,String>("username"));
        culumnRole.setCellValueFactory(new PropertyValueFactory<User,String>("role"));
        culumnIsActive.setCellValueFactory(new PropertyValueFactory<User,String>("isactive"));
        usersTable.setItems(listM);
    }
    
    @FXML
    public void switchToTeam(ActionEvent event) throws IOException{
        
        root = FXMLLoader.load(getClass().getResource("TeamDashboard.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Team");
        stage.setScene(scene);
        stage.show();
                
    }  
    @FXML
    public void tree(MouseEvent event){

    }
     
     @FXML
    public void switchToFront(MouseEvent event){
              try {
                  root = FXMLLoader.load(getClass().getResource("Front.fxml"));
                    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                    scene = new Scene(root);
                    stage.setTitle("Team");
                    stage.setScene(scene);
                    stage.show();
                } catch (Exception ex) {
                  System.out.print(ex);
              }                
    } 
}
