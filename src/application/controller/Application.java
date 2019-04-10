package application.controller;


import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;


import application.model.User;
import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.scene.layout.Pane;
import javafx.scene.control.Label;

public class Application implements Initializable {


    @FXML
    private Label welcomeLabel;

    @FXML
    private JFXButton myAccountButton;

    @FXML
    private JFXButton viewConcertsFestivalsButton;

    @FXML
    private JFXButton viewBookingsButton;

    @FXML
    private Pane accountPane;

    @FXML
    private Pane viewConcertsPane;

    @FXML
    private Pane viewBookingsPane;


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

    @FXML
    void handleButtonAction(ActionEvent event) {
        if (event.getSource() == myAccountButton) {
            accountPane.toFront();
        }
        else if (event.getSource() == viewConcertsFestivalsButton){
            viewConcertsPane.toFront();
        }
        else if (event.getSource() == viewBookingsButton){
            viewBookingsPane.toFront();
        }
    }

}
