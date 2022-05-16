/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Model.User;
import Services.LoginSession;
import Services.ServiceUser;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author leith
 */
public class ProfileController implements Initializable {

    @FXML
    private Button btnedit;

    @FXML
    private ImageView imgprof;

    @FXML
    private TextField labemail;

    @FXML
    private TextField labpassword;

    @FXML
    private TextField labusername;
public String urll;
private Stage stage;
    /**
     * Initializes the controller class.
     */
ServiceUser serviceUser =new ServiceUser();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            
        File file = new File("/Users/leith/personal/SandBox/JavaApplication1/src/Images/"+LoginSession.avatar);
           try {
               String localUrl = file.toURI().toURL().toString();
               imgprof.setFitHeight(150);
               imgprof.setFitWidth(150);
               Image image = new Image(localUrl);
               imgprof.setImage(image);
               
           } catch (MalformedURLException ex) {
               System.out.println(ex);;
           }
           
            labemail.setText(LoginSession.Email);
            labusername.setText(LoginSession.Username);
            labpassword.setText(LoginSession.Password);
    }    
    
    public void editprofile(Event e){
        User user=new User(labemail.getText(),labusername.getText(),"Role_USER",labpassword.getText());
        serviceUser.modifier(LoginSession.Email,user);
        LoginSession.Username=labusername.getText();
        LoginSession.Password=labpassword.getText();
        LoginSession.Email=labemail.getText();
        final Node source = (Node) e.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
        
    }
    
    
}
