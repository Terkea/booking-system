package application.controller;


import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;


import application.model.User;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
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


    @FXML
    private JFXTextField addressesAccountPaneTextField;

    @FXML
    private JFXTextField titleNameAccountPaneTextField = new JFXTextField();

    @FXML
    private JFXTextField townCountPostCodeAccountPaneTextField;

    @FXML
    private JFXTextField contactNamePhoneAccountPaneTextField;

    @FXML
    private JFXTextField emailAccountPaneTextField;

    @FXML
    private JFXTextField phoneAccountPaneTextField;

    @FXML
    private JFXTextField websiteAccountPaneTextField;

    @FXML
    private JFXTextField corporatOrganizationAccountPaneTextField;

    @FXML
    private JFXTextField dobAccountPaneTextField;


    public User ACTUALUSER = null;

    @Override
    public void initialize(URL url, ResourceBundle rs){
    }

    @FXML
    public void loadUser(User user){

        if (user != null){
            this.ACTUALUSER = user;
            welcomeLabel.setText(user.getTitle() + " " + user.getFirst_name() + " " + user.getLast_name());
            loadMyAcount();
        }
    }

    private void loadMyAcount(){
        titleNameAccountPaneTextField.setText(ACTUALUSER.getTitle() + " " + ACTUALUSER.getFirst_name() + " " + ACTUALUSER.getLast_name());
        dobAccountPaneTextField.setText(ACTUALUSER.getDob());
        addressesAccountPaneTextField.setText(ACTUALUSER.getAddress_line() + ", " + ACTUALUSER.getAddress_line2());
        townCountPostCodeAccountPaneTextField.setText(ACTUALUSER.getTown() + ", " + ACTUALUSER.getCounty() + ", " + ACTUALUSER.getPostcode());
        if (ACTUALUSER.getContact_name() != null){
            contactNamePhoneAccountPaneTextField.setText(ACTUALUSER.getContact_name() + ", " + ACTUALUSER.getContact_phone());
        }else{
            contactNamePhoneAccountPaneTextField.setVisible(false);
        }
        emailAccountPaneTextField.setText(ACTUALUSER.getEmail_address());
        phoneAccountPaneTextField.setText(ACTUALUSER.getMobile_no());
        if (ACTUALUSER.getContact_name() != null){
            websiteAccountPaneTextField.setText(ACTUALUSER.getContact_name());
        }else{
            websiteAccountPaneTextField.setVisible(false);
        }
        if (ACTUALUSER.getCorporate_name() != null){
            corporatOrganizationAccountPaneTextField.setText(ACTUALUSER.getCorporate_name());
        }else{
            corporatOrganizationAccountPaneTextField.setVisible(false);
        }
        if (ACTUALUSER.getOrganization_name() != null){
            corporatOrganizationAccountPaneTextField.appendText(", " + ACTUALUSER.getCorporate_name());
        }else{
            corporatOrganizationAccountPaneTextField.setVisible(false);
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
