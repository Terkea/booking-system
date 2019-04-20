package application.controller;


import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;


import application.model.*;
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
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Application implements Initializable {


    @FXML
    private Label welcomeLabel;

    @FXML
    private Label errorPaymentFieldsNotFilled;

    @FXML
    private Label totalTicketPaymentPane;

    @FXML
    private JFXTextField searchTextFieldConcertsPane;

    @FXML
    private JFXButton searchButtonConcertsPane;

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
    private JFXComboBox<String> titleEditProfileComboBox = new JFXComboBox();

    @FXML
    private JFXDatePicker dobUpdateProfileDatePicker = new JFXDatePicker();

    @FXML
    private AnchorPane seeMoreEventPane;

    @FXML
    private AnchorPane ticketsPaymentPane;

    @FXML
    private JFXTextField addressUpdateProfileTextField;

    @FXML
    private JFXTextField address2UpdateProfileTextField;

    @FXML
    private JFXTextField townUpdateProfileTextField;

    @FXML
    private Label unitsNameTicketPaymentPane;

    @FXML
    private Label quantityPriceTicketsPaymentPane;

    @FXML
    private JFXTextField cardNameTicketPaymentPane;

    @FXML
    private JFXTextField cardNumberTicketPaymentPane;

    @FXML
    private JFXTextField yearTicketPaymentPane;

    @FXML
    private JFXTextField monthTicketPaymentPane;

    @FXML
    private JFXTextField securityCodeTicketPaymentPane;

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
    private JFXButton buyTicketsButtonMoreDetailsPane;

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

    @FXML
    private TableColumn<Event, String> typeColumnConcertsPane;

    @FXML
    private Label titleLabelMoreDetailsEventPane;

    @FXML
    private Label locationLabelMoreDetailsEventPane;

    @FXML
    private Label dateLabelMoreDetailsEventPane;

    @FXML
    private Label ticketsAvailableLabelMoreDetailsEventPane;

    @FXML
    private Label ticketPriceLabelMoreDetailsEventPane;

    @FXML
    private Label eventTypeLabelMoreDetailsEventPane;

    @FXML
    private Label descriptionLabelMoreDetailsEventPane;

    @FXML
    private JFXTextField howManyLabelMoreDetailsPane;


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
        titleEditProfileComboBox.getItems().addAll(
                "Mr.", "Mrs.", "Ms", "Miss", "Master", "Maid", "Madam"
        );
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
        update.setTitle(titleEditProfileComboBox.getValue());
        update.setFirst_name(firstNameUpdateProfileTextField.getText());
        update.setLast_name(lastNameUpdateProfileTextField.getText());
        update.setAddress_line(addressUpdateProfileTextField.getText());
        update.setAddress_line2(address2UpdateProfileTextField.getText());
        update.setTown(townUpdateProfileTextField.getText());
        update.setCounty(countyUpdateProfileTextField.getText());
        update.setPostcode(postcodeUpdateProfileTextField.getText());
        update.setDob(dobUpdateProfileDatePicker.getValue().toString());
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
    private void loadEventsData() {
        nameColumnConcertsPane.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        dateColumnConcertsPane.setCellValueFactory(cellData -> cellData.getValue().dateProperty());
        locationColumnConcertsPane.setCellValueFactory(cellData -> cellData.getValue().locationProperty());
        typeColumnConcertsPane.setCellValueFactory(cellData -> cellData.getValue().event_typeProperty());
        ticketsColumnConcertsPane.setCellValueFactory(cellData -> cellData.getValue().tickets_availableProperty().asObject());
        priceColumnConcertsPane.setCellValueFactory(cellData -> cellData.getValue().ticket_priceProperty().asObject());


        try {
            ObservableList<Event> eventData = EventDAO.getAllActiveEvents();
            populateEvents(eventData);
        } catch (SQLException e) {
            System.err.println("Error occured while getting event information from DB " + e);
        } catch (ClassNotFoundException e) {
            System.err.println("Error occured while getting event information from DB " + e);
        }
    }

    @FXML
    private void populateEvents(Event event) throws ClassNotFoundException {
        ObservableList<Event> eventData = FXCollections.observableArrayList();
        eventData.add(event);
        concertsTableConcertsPane.setItems(eventData);
    }

    @FXML
    private void populateEvents(ObservableList<Event> eventData) throws ClassNotFoundException {
        concertsTableConcertsPane.setItems(eventData);
    }

    @FXML
    void searchConcertsPane(ActionEvent event) {
        try {
            ObservableList<Event> eventData = EventDAO.searchActiveEvent(searchTextFieldConcertsPane.getText());
            populateEvents(eventData);
        } catch (SQLException e) {
            System.out.println("Error occured while getting event information from DB " + e);
        } catch (ClassNotFoundException e) {
            System.err.println("Error occured while getting event information from DB " + e);
        }
    }

    @FXML
    void seeMoreDetailsButtonConcertPane(ActionEvent event) {
        Event selectedEvent = null;
        try {
            selectedEvent = EventDAO.getEventByID(concertsTableConcertsPane.getSelectionModel().getSelectedItem().getId());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        //concertsTableConcertsPane.getSelectionModel().getSelectedItem().getId()
        seeMoreEventPane.toFront();
        titleLabelMoreDetailsEventPane.setText(selectedEvent.getName());
        locationLabelMoreDetailsEventPane.setText(selectedEvent.getLocation());
        dateLabelMoreDetailsEventPane.setText(selectedEvent.getDate());
        ticketsAvailableLabelMoreDetailsEventPane.setText(selectedEvent.getTickets_available() + "- tickets booked");
        ticketPriceLabelMoreDetailsEventPane.setText(selectedEvent.getTicket_price() + " GBP");
        eventTypeLabelMoreDetailsEventPane.setText(selectedEvent.getEvent_type());
        descriptionLabelMoreDetailsEventPane.setText(selectedEvent.getDescription());
        // NEED TO BE ADDED THE BANDS/ARTISTIS WHO ARE GONNA
    }

    @FXML
    void buyTickets(ActionEvent event) {
        ticketsPaymentPane.toFront();
        Event selectedEvent = null;
        try {
            selectedEvent = EventDAO.getEventByID(concertsTableConcertsPane.getSelectionModel().getSelectedItem().getId());
            unitsNameTicketPaymentPane.setText(howManyLabelMoreDetailsPane.getText() + "x " + selectedEvent.getName() + " " + selectedEvent.getEvent_type());
            quantityPriceTicketsPaymentPane.setText(selectedEvent.getTicket_price() + "GBP * " + howManyLabelMoreDetailsPane.getText());
            totalTicketPaymentPane.setText(Double.parseDouble(howManyLabelMoreDetailsPane.getText()) * (selectedEvent.getTicket_price()) + " GBP");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    private boolean validationForTextFields(JFXTextField userInput) {
        if (userInput.getText().isEmpty()) {
            userInput.setStyle("-fx-border-color: #ff0000;" +
                    "-fx-border-radius: 5");
            return false;
        } else {
            userInput.setStyle(null);
            return true;
        }
    }

    private boolean checkBooleanArray(boolean[] array) {
        for (boolean a : array) {
            if (!a == true) {
                return false;
            }
        }
        return true;
    }

    @FXML
        //BUY TICKETS PANE
    void pay(ActionEvent event) {

        JFXTextField requiredFields[] = {cardNameTicketPaymentPane, cardNumberTicketPaymentPane, monthTicketPaymentPane, yearTicketPaymentPane, securityCodeTicketPaymentPane};
        boolean[] checkResults = new boolean[requiredFields.length];
        Event selectedEvent = null;

        for (int i = 0; i < requiredFields.length; i++) {
            checkResults[i] = validationForTextFields(requiredFields[i]);
        }

        if (checkBooleanArray(checkResults)) {
            if (cardNumberTicketPaymentPane.getText().length() != 16) {
                errorPaymentFieldsNotFilled.setText("Invalid card number");
            } else {
                PaymentDAO entry = new PaymentDAO();

                try {
                    selectedEvent = EventDAO.getEventByID(concertsTableConcertsPane.getSelectionModel().getSelectedItem().getId());
                    PaymentDAO.insertPayment(Double.parseDouble(howManyLabelMoreDetailsPane.getText()) * (selectedEvent.getTicket_price()),
                            cardNumberTicketPaymentPane.getText(), monthTicketPaymentPane.getText() + "/" + yearTicketPaymentPane.getText(),
                            cardNameTicketPaymentPane.getText(), securityCodeTicketPaymentPane.getText(),
                            ACTUALUSER.getId(),
                            "'" + howManyLabelMoreDetailsPane.getText() + "x " + selectedEvent.getName() + " " + selectedEvent.getEvent_type() + " tickets", 1);

                    //DO THE BOOKING AFTERWARDS

                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        } else {
            errorPaymentFieldsNotFilled.setText("All fields are required");
        }


    }

}