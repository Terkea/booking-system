package application.controller;

import application.model.UserDAO;
import application.system.Password;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import application.model.User;

import java.io.IOException;
import java.sql.SQLException;

public class Login {

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
    private void login(ActionEvent event) throws IOException {

        UserDAO checkLogin = new UserDAO();
        try {
            if (email.getText().equals("") && password.getText().equals("")){
                errorLabel.setText("Fill the form");
            }else{
                User loginAttempt = UserDAO.searchUsersByEmail(email.getText());
                if (loginAttempt != null){
                    Password checkCredentials = new Password();
                    if (Password.verifyHash(password.getText(), loginAttempt.getPassword())){
                        System.out.println("password match");
                        //redirect

                        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/application.fxml"));
                        Parent root = loader.load();

                        Application appController = loader.getController();
                        appController.loadUser(loginAttempt);

                        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                        stage.hide();
                        stage.setScene(new Scene(root));
                        stage.setResizable(true);
                        stage.show();


                    }else{
                        errorLabel.setText("Oh snap! Double check the email or password");
                    }
                }
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
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
