package application.controller;

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

public class Register {

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

    private boolean validation(TextField userInput, String errorMessage) {
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

    private boolean checkBooleanArray(boolean[] array) {
        for(boolean a : array){
            if (!a == true){
                return false;
            }
        }
        return true;
    }



    @FXML
    void doValidation(ActionEvent event) {
        //CHECK IF ALL REQUIRED FIELDS HAVE BEEN FILLED

        String error = "FIELD REQUIRED";
        boolean resultOverAll = false;

        /*
        private StringProperty title; 1
        private StringProperty first_name; 1
        private StringProperty last_name; 1
        private StringProperty gender; 1
        private StringProperty address_line; 1
        private StringProperty address_line2; // default null 1
        private StringProperty town; 1
        private StringProperty county; 1
        private StringProperty postcode; 1
        private StringProperty dob; 1
        private StringProperty contact_name; // default null 1
        private StringProperty contact_phone; // default null 1
        private StringProperty organization_name; // default null
        private StringProperty email_address; // unique 1
        private StringProperty mobile_no; 1
        private StringProperty website_address; // default null 1
        private StringProperty password; 1
        private StringProperty corporate_name; // default null 1
        private BooleanProperty is_admin; // default null
         */

        TextField fields[] = {firstNameText, lastNameText, address1Text, townText
                , countyText, postcodeText, emailText, phoneText}; // + title, gender, dob, password and password check
        //The result of the validation per field
        boolean[] validationResultsPerField = new boolean[fields.length];

        for (int i = 0; i < fields.length; i++){
            validationResultsPerField[i] = validation(fields[i], fields[i].getId() + " " + error);
        }

        if (checkBooleanArray(validationResultsPerField)){
            System.out.println("Validation PASSED");
        }

    }
}
