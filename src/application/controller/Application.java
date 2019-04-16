package application.controller;


import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;


import application.model.Event;
import application.model.EventDAO;
import application.model.User;
import application.model.UserDAO;
import application.system.Password;
import com.jfoenix.controls.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Application implements Initializable {


    @FXML
    private Label welcomeLabel;

    @FXML
    private JFXButton seeMoreButtonConcertPane;

    @FXML
    private Label errorLabelPasswordPane;

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
    private Pane editProfilePane;

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

    @FXML
    private JFXTextField firstNameUpdateProfileTextField;

    @FXML
    private JFXTextField lastNameUpdateProfileTextField;

    @FXML
    private JFXComboBox<String> titleEditProfileComboBox = new JFXComboBox<>();

    @FXML
    private JFXDatePicker dobUpdateProfileDatePicker = new JFXDatePicker();

    @FXML
    private JFXTextField addressUpdateProfileTextField;

    @FXML
    private JFXTextField address2UpdateProfileTextField;

    @FXML
    private JFXTextField townUpdateProfileTextField;

    @FXML
    private JFXTextField countyUpdateProfileTextField;

    @FXML
    private JFXTextField postcodeUpdateProfileTextField;

    @FXML
    private JFXTextField phoneUpdateProfileTextField;

    @FXML
    private JFXTextField websiteUpdateProfileTextField;

    @FXML
    private JFXTextField corporateNameUpdateProfileTextField;

    @FXML
    private JFXTextField contactNameUpdateProfileTextField;

    @FXML
    private JFXTextField contactPhoneUpdateProfileTextField;

    @FXML
    private JFXButton changePasswordButtonMyAccountPane;

    @FXML
    private JFXButton updateProfileButtonUpdatePane;

    @FXML
    private AnchorPane changeMyPasswordPane;

    @FXML
    private JFXPasswordField currentPasswordChangePasswordPane;

    @FXML
    private JFXPasswordField passwordChangePasswordPane;

    @FXML
    private JFXPasswordField confirmPasswordChangePasswordPane;

    @FXML
    private TableView<Event> concertsTableConcertsPane;

    @FXML
    private TableColumn<Event, String> nameColumnConcertsPane;

    @FXML
    private TableColumn<Event, String> dateColumnConcertsPane;

    @FXML
    private TableColumn<Event, String> locationColumnConcertsPane;

    @FXML
    private TableColumn<Event, Integer> ticketsColumnConcertsPane;

    @FXML
    private TableColumn<Event, Double> priceColumnConcertsPane;


    public User ACTUALUSER = null;

    @Override
    public void initialize(URL url, ResourceBundle rs) {
    }

    @FXML
    void handleButtonAction(ActionEvent event) {
        if (event.getSource() == myAccountButton) {
            accountPane.toFront();
        } else if (event.getSource() == viewConcertsFestivalsButton) {
            viewConcertsPane.toFront();
            loadEventsData();
        } else if (event.getSource() == viewBookingsButton) {
            viewBookingsPane.toFront();
        }
    }




    // ACCOUNT PANE
    @FXML
    public void loadUser(User user) {

        if (user != null) {
            this.ACTUALUSER = user;
            welcomeLabel.setText(user.getTitle() + " " + user.getFirst_name() + " " + user.getLast_name());
            loadMyAcount();
        }
    }

    private void loadMyAcount() {
        titleNameAccountPaneTextField.setText(ACTUALUSER.getTitle() + " " + ACTUALUSER.getFirst_name() + " " + ACTUALUSER.getLast_name());
        dobAccountPaneTextField.setText(ACTUALUSER.getDob());
        addressesAccountPaneTextField.setText(ACTUALUSER.getAddress_line() + ", " + ACTUALUSER.getAddress_line2());
        townCountPostCodeAccountPaneTextField.setText(ACTUALUSER.getTown() + ", " + ACTUALUSER.getCounty() + ", " + ACTUALUSER.getPostcode());
        if (ACTUALUSER.getContact_name() != null) {
            contactNamePhoneAccountPaneTextField.setText(ACTUALUSER.getContact_name() + ", " + ACTUALUSER.getContact_phone());
        } else {
            contactNamePhoneAccountPaneTextField.setVisible(false);
        }
        emailAccountPaneTextField.setText(ACTUALUSER.getEmail_address());
        phoneAccountPaneTextField.setText(ACTUALUSER.getMobile_no());
        if (ACTUALUSER.getContact_name() != null) {
            websiteAccountPaneTextField.setText(ACTUALUSER.getContact_name());
        } else {
            websiteAccountPaneTextField.setVisible(false);
        }
        if (ACTUALUSER.getCorporate_name() != null) {
            corporatOrganizationAccountPaneTextField.setText(ACTUALUSER.getCorporate_name());
        } else {
            corporatOrganizationAccountPaneTextField.setVisible(false);
        }
        if (ACTUALUSER.getOrganization_name() != null) {
            corporatOrganizationAccountPaneTextField.appendText(", " + ACTUALUSER.getCorporate_name());
        } else {
            corporatOrganizationAccountPaneTextField.setVisible(false);
        }
    }

    @FXML
    void editProfileAccountPane(ActionEvent event) {
        firstNameUpdateProfileTextField.setText(ACTUALUSER.getFirst_name());
        lastNameUpdateProfileTextField.setText(ACTUALUSER.getLast_name());
        addressUpdateProfileTextField.setText(ACTUALUSER.getAddress_line());
        address2UpdateProfileTextField.setText(ACTUALUSER.getAddress_line2());
        townUpdateProfileTextField.setText(ACTUALUSER.getTown());
        countyUpdateProfileTextField.setText(ACTUALUSER.getCounty());
        postcodeUpdateProfileTextField.setText(ACTUALUSER.getPostcode());
        phoneUpdateProfileTextField.setText(ACTUALUSER.getMobile_no());
        websiteUpdateProfileTextField.setText(ACTUALUSER.getWebsite_address());
        corporateNameUpdateProfileTextField.setText(ACTUALUSER.getCorporate_name());
        contactNameUpdateProfileTextField.setText(ACTUALUSER.getContact_name());
        contactPhoneUpdateProfileTextField.setText(ACTUALUSER.getContact_phone());
        titleEditProfileComboBox.setPromptText(ACTUALUSER.getTitle());
        dobUpdateProfileDatePicker.setPromptText(ACTUALUSER.getDob());

        editProfilePane.toFront();
    }

    @FXML
    void changeMyPassword(ActionEvent event) {
        changeMyPasswordPane.toFront();
    }

    @FXML
    void updatePasswordMyProfile(ActionEvent event) {
        if (currentPasswordChangePasswordPane.getText().equals("") || currentPasswordChangePasswordPane.getText().isEmpty()) {
            currentPasswordChangePasswordPane.setStyle("-fx-border-color: #ff0000;" +
                    "-fx-border-radius: 5");
        }
        if (passwordChangePasswordPane.getText().equals("") || passwordChangePasswordPane.getText().isEmpty()) {
            passwordChangePasswordPane.setStyle("-fx-border-color: #ff0000;" +
                    "-fx-border-radius: 5");
        }
        if (confirmPasswordChangePasswordPane.getText().equals("") || confirmPasswordChangePasswordPane.getText().isEmpty()) {
            confirmPasswordChangePasswordPane.setStyle("-fx-border-color: #ff0000;" +
                    "-fx-border-radius: 5");
        }

        Password password = new Password();
        if (password.verifyHash(currentPasswordChangePasswordPane.getText(), ACTUALUSER.getPassword())) {

            if (confirmPasswordChangePasswordPane.getText().equals("") || confirmPasswordChangePasswordPane.getText().isEmpty() ||
                    passwordChangePasswordPane.getText().isEmpty() || passwordChangePasswordPane.getText().equals("")) {

                errorLabelPasswordPane.setText("Fields cannot be empty");
            } else {
                if (passwordChangePasswordPane.getText().equals(confirmPasswordChangePasswordPane.getText()) && confirmPasswordChangePasswordPane.getText().equals(passwordChangePasswordPane.getText())) {
                    UserDAO update = new UserDAO();
                    update.updateUserPassword(ACTUALUSER.getId(), password.hash(passwordChangePasswordPane.getText()));

                    try {
                        Parent registerParent = FXMLLoader.load(getClass().getResource("../view/login.fxml"));
                        Scene registerScene = new Scene(registerParent);

                        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        window.hide();
                        window.setScene(registerScene);
                        window.show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    errorLabelPasswordPane.setText("Password and current password doesn't match");
                    passwordChangePasswordPane.setStyle("-fx-border-color: #ff0000;" +
                            "-fx-border-radius: 5");
                    confirmPasswordChangePasswordPane.setStyle("-fx-border-color: #ff0000;" +
                            "-fx-border-radius: 5");
                }
            }
        } else {
            errorLabelPasswordPane.setText("Current password doesn't match");
            currentPasswordChangePasswordPane.setStyle("-fx-border-color: #ff0000;" +
                    "-fx-border-radius: 5");
        }
    }


    @FXML
    void updateMyProfile(ActionEvent event) {
        User update = new User();
        update.setId(ACTUALUSER.getId());
        update.setTitle(titleEditProfileComboBox.getPromptText());
        update.setFirst_name(firstNameUpdateProfileTextField.getText());
        update.setLast_name(lastNameUpdateProfileTextField.getText());
        update.setAddress_line(addressUpdateProfileTextField.getText());
        update.setAddress_line2(address2UpdateProfileTextField.getText());
        update.setTown(townUpdateProfileTextField.getText());
        update.setCounty(countyUpdateProfileTextField.getText());
        update.setPostcode(postcodeUpdateProfileTextField.getText());
        update.setDob(dobUpdateProfileDatePicker.getAccessibleText());
        update.setContact_name(contactNameUpdateProfileTextField.getText());
        update.setContact_phone(contactPhoneUpdateProfileTextField.getText());
        update.setOrganization_name(corporateNameUpdateProfileTextField.getText());
        update.setMobile_no(phoneUpdateProfileTextField.getText());
        update.setWebsite_address(websiteUpdateProfileTextField.getText());

        UserDAO dao = new UserDAO();
        dao.updateUser(update);

        try {
            Parent registerParent = FXMLLoader.load(getClass().getResource("../view/login.fxml"));
            Scene registerScene = new Scene(registerParent);

            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.hide();
            window.setScene(registerScene);
            window.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    //EVENT PANE
    private void loadEventsData(){
        nameColumnConcertsPane.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        dateColumnConcertsPane.setCellValueFactory(cellData -> cellData.getValue().dateProperty());
        locationColumnConcertsPane.setCellValueFactory(cellData -> cellData.getValue().locationProperty());
        ticketsColumnConcertsPane.setCellValueFactory(cellData -> cellData.getValue().tickets_availableProperty().asObject());
        priceColumnConcertsPane.setCellValueFactory(cellData -> cellData.getValue().ticket_priceProperty().asObject());


        try{
            ObservableList<Event> eventData = EventDAO.getAllEvents();
            populateEvents(eventData);
        }catch(SQLException e){
            System.out.println("Error occured while getting employees information from DB " + e);
//            throw e;
        }catch (ClassNotFoundException e){
//            throw e;
        }
    }

    @FXML
    private void populateEvents (Event event) throws ClassNotFoundException{
        ObservableList<Event> eventData = FXCollections.observableArrayList();
        eventData.add(event);
        concertsTableConcertsPane.setItems(eventData);
    }

    @FXML
    private void populateEvents(ObservableList<Event> eventData) throws ClassNotFoundException{
        concertsTableConcertsPane.setItems(eventData);
    }


}