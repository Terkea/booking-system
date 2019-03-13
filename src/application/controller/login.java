package application.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class login {

    @FXML
    private Button loginBtn;

    @FXML
    private TextField email;

    @FXML
    private PasswordField password;

    @FXML
    private Hyperlink register;

    @FXML
    private void login(ActionEvent event) {
        if (email.getText().equals("Marian")){
            System.out.println("Yes");
        }else{
            System.out.println("No");
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
