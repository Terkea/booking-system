package application.controller;

import application.model.User;
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

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Register {

    @FXML
    private TextField corporateNameText;

    @FXML
    private TextField lastNameText;

    @FXML
    private ComboBox<String> titleComboBox = new ComboBox();

    @FXML
    private ComboBox<String> genderComboBox = new ComboBox();

    @FXML
    private DatePicker dobDatePicker = new DatePicker();

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
    private CheckBox termsCheckBox = new CheckBox();

    @FXML
    private TextField firstNameText;

    @FXML
    private Button submit;

    @FXML
    private Label requiredFieldsLabel;

    @FXML
    private Label passwordsMatch;

    @FXML
    public void initialize(){
        titleComboBox.getItems().addAll(
          "Mr.","Mrs.","Ms","Miss","Master","Maid","Madam"
        );

        genderComboBox.getItems().addAll(
          "Male", "Female"
        );
    }

    private boolean checkDOB(){
        if(dobDatePicker.getValue() == null){
            dobDatePicker.setStyle("-fx-border-color: #ff0000;" +
                    "-fx-border-radius: 5");
            return false;
        }else{
            dobDatePicker.setStyle(null);
            return true;
        }

    }

    private boolean validationForTextFields(TextField userInput) {
        if(userInput.getText().isEmpty()) {
            userInput.setStyle("-fx-border-color: #ff0000;" +
                    "-fx-border-radius: 5");
            return false;
        }else{
            userInput.setStyle(null);
            return true;
        }
    }

    private boolean validationForComboBox(ComboBox userInput) {
        if(userInput.getSelectionModel().isEmpty()) {
            userInput.setStyle("-fx-border-color: #ff0000;" +
                    "-fx-border-radius: 5");
            return false;
        }else{
            userInput.setStyle(null);
            return true;
        }
    }


    private boolean checkPasswordsMatch(PasswordField password, PasswordField password2) {
        if (password.getText().equals(password2.getText()) && password2.getText().equals(password.getText())){
            return true;
        }else{
            passwordsMatch.setText("Passwords doesn't match");
        }
        return false;
    }

    private boolean termsAndConditionsCheck(CheckBox cb){
        if (cb.isSelected()){
            return true;
        }else{
            cb.setStyle("-fx-border-color: #ff0000;" +
                    "-fx-border-radius: 5");
        }
        return false;
    }

    private boolean checkPasswords(PasswordField p1, PasswordField p2){
        if((p1.getText().equals("") || p1.getText().isEmpty()) && (p2.getText().equals("") || p2.getText().isEmpty())) {
            p1.setStyle("-fx-border-color: #ff0000;" +
                    "-fx-border-radius: 5");
            p2.setStyle("-fx-border-color: #ff0000;" +
                    "-fx-border-radius: 5");
            return false;
        }else{
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
    void doValidation(ActionEvent event) throws IOException {
        //CHECK IF ALL REQUIRED FIELDS HAVE BEEN FILLED

        String error = "FIELD REQUIRED";
        boolean resultOverAll = false;

        TextField[] fields = {firstNameText, lastNameText, address1Text, townText
                , countyText, postcodeText, emailText, phoneText}; // + title, gender, dob, password and password check
        ComboBox[] comboFields = {genderComboBox, titleComboBox};

        //The result of the validation per field
        boolean[] validationResultsPerField = new boolean[fields.length];
        boolean[] validationResultPerComboBox = new boolean[comboFields.length];

        for (int i = 0; i < fields.length; i++){
            validationResultsPerField[i] = validationForTextFields(fields[i]);
        }
        for (int i = 0; i < comboFields.length; i++){
            validationResultPerComboBox[i] = validationForComboBox(comboFields[i]);
        }
        checkDOB();


        if (checkBooleanArray(validationResultsPerField) && checkBooleanArray(validationResultPerComboBox)
                && checkPasswordsMatch(password, passwordCheck) && checkPasswords(password, passwordCheck)
                && termsAndConditionsCheck(termsCheckBox) && checkDOB()){
            UserDAO check = new UserDAO();
            if (UserDAO.checkEmailUnique(emailText.getText())){
                System.out.println("Validation PASSED");

                User user = new User();
                user.setTitle(titleComboBox.getValue());
                user.setFirst_name(firstNameText.getText());
                user.setLast_name(lastNameText.getText());
                user.setGender(genderComboBox.getValue());
                user.setAddress_line(address1Text.getText());
                user.setAddress_line2(address2Text.getText());
                user.setTown(townText.getText());
                user.setCounty(countyText.getText());
                user.setPostcode(postcodeText.getText());
                user.setDob(dobDatePicker.getValue().toString());
                user.setContact_name(contactNameText.getText());
                user.setContact_phone(contactNumberText.getText());
                user.setCorporate_organisation_name(corporateNameText.getText());
                user.setEmail_address(emailText.getText());
                user.setMobile_no(phoneText.getText());
                user.setWebsite_address(websiteText.getText());

                Password pwd = new Password();
                String hasshedPassword = Password.hash(password.getText());
                user.setPassword(hasshedPassword);

                user.setEvents_organiser_name(null);
                user.setIs_admin(false);


                UserDAO insert = new UserDAO();
                try {
                    UserDAO.insertUser(user.getTitle(), user.getFirst_name(), user.getLast_name(), user.getGender(), user.getAddress_line(), user.getAddress_line2(),
                            user.getTown(), user.getCounty(), user.getPostcode(), user.getDob(), user.getContact_name(), user.getContact_phone(),
                            user.getCorporate_organisation_name(), user.getEmail_address(), user.getMobile_no(), user.getWebsite_address(), user.getPassword(), user.getEvents_organiser_name(),
                            user.isIs_admin());



                    Parent registerParent = FXMLLoader.load(getClass().getResource("../view/login.fxml"));
                    Scene registerScene = new Scene(registerParent);

                    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                    window.hide();
                    window.setScene(registerScene);
                    window.show();
                } catch (SQLException e) {
                    e.printStackTrace();
                    System.err.println("SQL syntax error");
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                    System.err.println("Class not found error");
                }


            }else{
                System.err.println("The email address has to be unique");
                requiredFieldsLabel.setText("The email address has to be unique");
                emailText.setStyle("-fx-border-color: #ff0000;" +
                        "-fx-border-radius: 5");
            }


            //INSERT INTO USER TABLE
        }else{
            requiredFieldsLabel.setText("You have to fill the required fields");
        }

    }
}
