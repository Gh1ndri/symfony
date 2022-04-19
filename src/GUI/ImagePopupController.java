/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;

/**
 * FXML Controller class
 *
 * @author leith
 */
public class ImagePopupController implements Initializable {
    public static String imgurl;
     
    public void selectImage1(){
        imgurl="logo-1-1.png";
    }
    public void selectImage2(){
        imgurl="logo-1-2.png";
    }
    public void selectImage3(){
        imgurl="logo-1-3.png";
    }
    public void selectImage4(){
        imgurl="logo-1-4.png";
    }
    public void selectImage5(){
        imgurl="logo-1-5.png";
    }
    public void selectImage6(){
        imgurl="logo-1-6.png";
    }
    public void selectImage7(){
        imgurl="logo-1-7.png";
    }
    public void selectImage8(){
        imgurl="logo-1-8.png";
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
