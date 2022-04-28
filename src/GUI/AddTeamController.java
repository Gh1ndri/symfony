/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import static GUI.ImagePopupController.imgurl;
import Model.Team;
import Model.User;
import Services.ServiceTeam;
import Services.ServiceUser;
import java.net.URL;
import java.util.ResourceBundle;
import static javafx.application.Platform.exit;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author leith
 */
public class AddTeamController implements Initializable {

    @FXML
    private TextArea desteam;
    @FXML
    private TextField temname;
    @FXML
    private Button addteam;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajouterTeam(ActionEvent event) {
        ServiceTeam sp = new ServiceTeam();
        Team s = new Team(temname.getText(),desteam.getText(),"Active");
        sp.ajouter(s);
    }
    
}
