/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Model.Team;
import Services.ServiceTeam;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author leith
 */
public class FrontController implements Initializable {

    @FXML
    private Button team;
    @FXML
    private ImageView signout;
    @FXML
    private ImageView profil;
    @FXML
    private VBox vboxTeam;
    public List<Team> list;
    /**
     * Initializes the controller class.
     */
    ServiceTeam serviceTeam =new ServiceTeam();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public void teamItems(){
        list=serviceTeam.afficher();
        for(Iterator it=list.iterator(); it.hasNext();){
            
        }
    }
    
}
