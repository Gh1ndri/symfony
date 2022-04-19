/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import static GUI.ImagePopupController.imgurl;
import Model.User;
import Services.ServiceUser;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.PopupWindow;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


/**
 * FXML Controller class
 *
 * @author leith
 */
public class SignupInterfaceController implements Initializable{
    
    @FXML
    private TextField username;
    @FXML
    private TextField email;
    @FXML
    private TextField password;
    @FXML
    private TextField confirmpassword;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    
    @FXML
    public void switchImagePopup(ActionEvent event) throws IOException{
        FXMLLoader fxmlloader = new FXMLLoader (getClass().getResource("ImagePopup.fxml"));
        Parent root1= (Parent) fxmlloader.load();
        Stage stage = new Stage();
        stage.initStyle(StageStyle.DECORATED);
        stage.setTitle("choose avatar");
        stage.setScene(new Scene(root1));
        stage.show();
    }  
    
    @FXML
    private void ajouterUser(ActionEvent event) {
        String email2=email.getText();
        ServiceUser sp = new ServiceUser();
        System.out.print("dfgsdfg"+email2);
        User s = new User(email2,username.getText(),"Role_USER",password.getText(),imgurl);
        System.out.print(s.toString());
        sp.ajouter(s);
        System.out.print("dfgsdfg"+email.getText());
        
    }
      
    
}
