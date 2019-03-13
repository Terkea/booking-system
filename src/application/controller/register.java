package application.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import java.io.IOException;

public class register {


    @FXML
    private ComboBox<String> titleComboBox;
    ObservableList<String> list = FXCollections.observableArrayList("Mr", "Miss");

    @FXML
    private Button submit;

    @FXML
    private void goToLogin(ActionEvent event) throws IOException {
        Parent loginParent = FXMLLoader.load(getClass().getResource("../view/login.fxml"));
        Scene loginScene = new Scene(loginParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.hide();
        window.setScene(loginScene);
        window.show();
    }

    public void register(){
        titleComboBox.getItems().add("Mr");
    }

}
