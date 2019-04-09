package application.controller;

import application.model.User;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class Application implements Initializable {

    @FXML
    private Label welcomeLabel;


    @FXML
    private Button editConcert;


    private User ACTUALUSER = null;

    @Override
    public void initialize(URL url, ResourceBundle rs){
    }

    @FXML
    public void loadUser(User user){

        if (user != null){
            this.ACTUALUSER = user;
            welcomeLabel.setText(user.getTitle() + " " + user.getFirst_name() + " " + user.getLast_name());
        }
    }

    public void test(){
        System.out.println(ACTUALUSER.toString());

    }

}
