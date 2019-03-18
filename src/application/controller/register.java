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

public class register{

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

    public boolean validation(TextField userInput, String errorMessage) {
        if(userInput.getText().isEmpty() || userInput.getText().equals(errorMessage)) {
            userInput.setStyle("-fx-border-color: #ff0000;" +
                    "-fx-border-radius: 5");
            userInput.setText(errorMessage);
            return false;
        }else{
            userInput.setStyle(null);
            return true;
        }
    }

    @FXML
    void doValidation(ActionEvent event) {
        String error = "FIELD REQUIRED";

        //REQUIRED FIELDS
        TextField fields[] = {firstNameText, lastNameText, address1Text, address2Text, townText
                , countyText, postcodeText, emailText, phoneText, websiteText, corporateNameText};
        boolean[] validationResultsPerField = new boolean[fields.length];

        for (int i = 0; i < fields.length; i++){
            validationResultsPerField[i] = validation(fields[i], error);
        }
    }
}
