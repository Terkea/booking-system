package application.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class register {

    @FXML
    private TextField corporateNameText;

    @FXML
    private TextField lastNameText;

    @FXML
    private ComboBox<?> titleComboBox;

    @FXML
    private ComboBox<?> genderComboBox;

    @FXML
    private DatePicker dobDatePicker;

    @FXML
    private TextField address1Text;

    @FXML
    private TextField address2Text;

    @FXML
    private TextField townText;

    @FXML
    private TextField postcodeText;

    @FXML
    private TextField countyText;

    @FXML
    private TextField contactNumberText;

    @FXML
    private TextField contactNameText;

    @FXML
    private TextField emailText;

    @FXML
    private TextField phoneText;

    @FXML
    private TextField websiteText;

    @FXML
    private PasswordField password;

    @FXML
    private PasswordField passwordCheck;

    @FXML
    private CheckBox termaCheckBox;

    @FXML
    private TextField firstNameText;

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



}
