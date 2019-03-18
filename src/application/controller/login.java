package application.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import application.model.user;

import java.io.IOException;

public class login {

    //after the user logins we'll add the information
    public login(){
        user user = new user();
    }

    @FXML
    private Button loginBtn;

    @FXML
    private TextField email;

    @FXML
    private PasswordField password;

    @FXML
    private Label errorLabel;

    @FXML
    private Hyperlink register;

    @FXML
    private void login(ActionEvent event) {
        if (email.getText().equals("terkea")&& password.getText().equals("123")){
            System.out.println("text: " + email.getText());
        }else{
            System.out.println("text: " + email.getText());
            errorLabel.setText("Invalid e-mail or password");

        }

    }

    @FXML
    private void goToRegister(ActionEvent event) throws IOException {
        Parent registerParent = FXMLLoader.load(getClass().getResource("../view/register.fxml"));
        Scene registerScene = new Scene(registerParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.hide();
        window.setScene(registerScene);
        window.show();
    }

}
