package application.controller;


import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;


import application.model.*;
import application.system.Password;
import com.jfoenix.controls.*;
import javafx.beans.property.StringProperty;
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


    public User ACTUALUSER = null;
    @FXML
    private Label welcomeLabel;

    @FXML
    private TableView<Booking> allBookingsTableView;

    @FXML
    private TableColumn<Booking, String> eventNameColumnManageBookingsPane;

    @FXML
    private TableColumn<Booking, String> ticketsboughtColumnManageBookingsPane;

    @FXML
    private TableColumn<Booking, String> userFNColumnManageBookingsPane;

    @FXML
    private JFXTextField searchKeywordManageBookingsPane;

    @FXML
    private TableColumn<Booking, String> userLNColumnManageBookingsPane;

    @FXML
    private TableColumn<Booking, String> discountedColumnManageBookingsPane;

    @FXML
    private TableColumn<Booking, String> paidColumnManageBookingsPane;

    @FXML
    private AnchorPane manageBookingsPane;

    @FXML
    private JFXChipView<Event> performersChipViewCreateEventPane = new JFXChipView<>();

    @FXML
    private JFXTextField firstNameEditUserAccountPane;

    @FXML
    private JFXTextField lastNameEditUserAccountPane;

    @FXML
    private JFXTextField addressEditUserAccountPane;

    @FXML
    private JFXTextField searchKeywordManageEventsPane;

    @FXML
    private JFXButton manageEvents;

    @FXML
    private JFXTextField address2EditUserAccountPane;

    @FXML
    private JFXTextField townEditUserAccountPane;

    @FXML
    private JFXTextField countyEditUserAccountPane;

    @FXML
    private JFXTextField postcodeEditUserAccountPane;

    @FXML
    private JFXTextField phoneEditUserAccountPane;

    @FXML
    private JFXTextField websiteEditUserAccountPane;

    @FXML
    private JFXTextField corporateEditUserAccountPane;

    @FXML
    private JFXTextField contactEditUserAccountPane;
    @FXML
    private Label afterDiscountLabelPaymentPane;
    @FXML
    private Label errorCorporatePaymentFieldsNotFilled;
    @FXML
    private Label eventNameLabelMyBookingPane;
    @FXML
    private Label eventTypeLabelMyBookingPane;
    @FXML
    private JFXButton payPendingBookingsButton;
    @FXML
    private Label userIdLabelEditProfilePane;
    @FXML
    private Label fullPriceLabelPayPendingBookingsPane;
    @FXML
    private Label discountLabelPayPendingBookingsPane;
    @FXML
    private TableView<User> allUsersTableView;

    @FXML
    private TableColumn<User, String> firstNameColumnManageAccountsPane;

    @FXML
    private TableColumn<User, String> lastNameColumnManageAccountsPane;

    @FXML
    private TableColumn<User, String> emailColumnManageAccountsPane;

    @FXML
    private TableColumn<User, String> phoneColumnManageAccountsPane;
    @FXML
    private Label userRankLabel;
    @FXML
    private JFXTextField keywordTextFieldManageAccountsPane;
    @FXML
    private Label totalValueLabelPayPendingBookingsPane;
    @FXML
    private AnchorPane payPendingBookingsPane;
    @FXML
    private Label locationLabelMyBookingPane;
    @FXML
    private Label dateLabelMyBookingPane;
    @FXML
    private AnchorPane ticketsPaymentForCorporateOrganizationPane;
    @FXML
    private JFXTextArea descriptionLabelMyBookingPane;
    @FXML
    private AnchorPane editViewUserProfilePane;
    @FXML
    private AnchorPane cardPaymentAnchorPane;
    @FXML
    private JFXButton manageBookings;
    @FXML
    private JFXTextField cardNameTicketCorporatePaymentPane;
    @FXML
    private JFXButton manageAccountsButton;
    @FXML
    private JFXTextField cardNumberCorporateTicketPaymentPane;
    @FXML
    private JFXTextField yearCorporateTicketPaymentPane;
    @FXML
    private JFXTextField monthCorporateTicketPaymentPane;
    @FXML
    private JFXTextField securityCodeCorporateTicketPaymentPane;
    @FXML
    private Label paymentStatusLabelMyBookingPane;
    @FXML
    private JFXButton seeMoreButtonMyBookingsPane;
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
    private Label PayPendingBookingsPane;
    @FXML
    private JFXTextField cardNamePendingPaymentsPane;
    @FXML
    private JFXTextField cardNumberPendingPaymentsPane;
    @FXML
    private JFXTextField yearPendingPaymentsPane;
    @FXML
    private JFXTextField monthPendingPaymentsPane;
    @FXML
    private JFXTextField securityCodePendingPaymentsPane;
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
    private AnchorPane manageAccountsPane;
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
    private JFXButton corporatePay;
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
    private Label errorPayPendingBookingsPane;
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
    private Label totalLabelMakePaymentPane;
    @FXML
    private Label discountLabelPaymentPane;
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
    private AnchorPane payByCardOrganiserAnchorPane;
    @FXML
    private Label descriptionLabelMoreDetailsEventPane;
    @FXML
    private JFXTextField howManyLabelMoreDetailsPane;
    @FXML
    private TableView<Booking> myBookingsTable;
    @FXML
    private TableColumn<Booking, String> festivalNameColumnBookingsPane;
    @FXML
    private TableColumn<Booking, String> ticketsBoughtColumnBookingsPane;
    @FXML
    private TableColumn<Booking, String> dateColumnBookingsPane;
    @FXML
    private TableColumn<Booking, String> locationColumnBookingsPane;
    @FXML
    private JFXTextField keywordTextFieldMyBookindsPane;
    @FXML
    private JFXButton searchButtonMyBookings;
    @FXML
    private Label fullPriceLabelMakeOrganiserPaymentPane;
    @FXML
    private Label discountLabelMakeOrganiserPaymentPane;
    @FXML
    private Label totalValueLabelMakeOrganiserPaymentPane;
    @FXML
    private JFXCheckBox payMohtnlycheckBoxPaymentPane;
    @FXML
    private AnchorPane moreDetailsAboutMyBookingPane;
    @FXML
    private JFXButton makePaymentsButton;
    @FXML
    private AnchorPane makePaymentPane;
    @FXML
    private TableView<Booking> pendingPaymentsTableView;
    @FXML
    private TableColumn<Booking, String> eventNameColumnMakePaymentPane;
    @FXML
    private TableColumn<Booking, String> ammountColumnMakePaymentPane;
    @FXML
    private TableColumn<Booking, String> ticketsColumnMakePaymentPane;
    @FXML
    private AnchorPane manageEventsPane;
    @FXML
    private TableView<Event> manageEventsTableView;

    @FXML
    private TableColumn<Event, String> nameColumnManageEventsPane;

    @FXML
    private TableColumn<Event, String> typeColumnManageEventsPane;

    @FXML
    private TableColumn<Event, Integer> ticketsAvailableColumnManageEventsPane;

    @FXML
    private TableColumn<Event, Double> ticketPriceeColumnManageEventsPane;

    @FXML
    private TableColumn<Event, String> statusColumnManageEventsPane;

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
            loadMyBookingsData();
            viewBookingsPane.toFront();
        }else if (event.getSource() == makePaymentsButton){
            loadUnpaidBookings();
            makePaymentPane.toFront();
        }else if (event.getSource() == manageAccountsButton){
            loadAllAccounts();
            manageAccountsPane.toFront();
        }else if (event.getSource() == manageBookings){
            loadAllBookings();
            manageBookingsPane.toFront();
        }else if (event.getSource() == manageEvents){
            loadAllEvents();
            manageEventsPane.toFront();
        }
    }


    // ACCOUNT PANE
    @FXML
    public void loadUser(User user) {
//        makePaymentsButton.setVisible(false);
        if (user != null) {
            this.ACTUALUSER = user;


            if (UserDAO.checkCorporateOrganization(user.getId())){
                makePaymentsButton.setVisible(true);
            }else{
                makePaymentsButton.setVisible(false);
            }

            if (UserDAO.checkAdmin(user.getId())){
                manageAccountsButton.setVisible(true);
                manageBookings.setVisible(true);
                manageEvents.setVisible(true);
            }else{
                manageAccountsButton.setVisible(false);
                manageBookings.setVisible(false);
                manageEvents.setVisible(false);
            }


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
        if (ACTUALUSER.getCorporate_organisation_name() != null) {
            corporatOrganizationAccountPaneTextField.setText(ACTUALUSER.getCorporate_organisation_name());
        } else {
            corporatOrganizationAccountPaneTextField.setVisible(false);
        }
        if (ACTUALUSER.getEvents_organiser_name() != null) {
            corporatOrganizationAccountPaneTextField.appendText(", " + ACTUALUSER.getEvents_organiser_name());
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
        corporateNameUpdateProfileTextField.setText(ACTUALUSER.getCorporate_organisation_name());
        contactNameUpdateProfileTextField.setText(ACTUALUSER.getContact_name());
        contactPhoneUpdateProfileTextField.setText(ACTUALUSER.getContact_phone());
        titleEditProfileComboBox.setPromptText(ACTUALUSER.getTitle());

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
        if (Password.verifyHash(currentPasswordChangePasswordPane.getText(), ACTUALUSER.getPassword())) {

            if (confirmPasswordChangePasswordPane.getText().equals("") || confirmPasswordChangePasswordPane.getText().isEmpty() ||
                    passwordChangePasswordPane.getText().isEmpty() || passwordChangePasswordPane.getText().equals("")) {

                errorLabelPasswordPane.setText("Fields cannot be empty");
            } else {
                if (passwordChangePasswordPane.getText().equals(confirmPasswordChangePasswordPane.getText()) && confirmPasswordChangePasswordPane.getText().equals(passwordChangePasswordPane.getText())) {
                    UserDAO update = new UserDAO();
                    update.updateUserPassword(ACTUALUSER.getId(), Password.hash(passwordChangePasswordPane.getText()));

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
        update.setFirst_name(firstNameUpdateProfileTextField.getText());
        update.setLast_name(lastNameUpdateProfileTextField.getText());
        update.setAddress_line(addressUpdateProfileTextField.getText());
        update.setAddress_line2(address2UpdateProfileTextField.getText());
        update.setTown(townUpdateProfileTextField.getText());
        update.setCounty(countyUpdateProfileTextField.getText());
        update.setPostcode(postcodeUpdateProfileTextField.getText());
        update.setContact_name(contactNameUpdateProfileTextField.getText());
        update.setContact_phone(contactPhoneUpdateProfileTextField.getText());
        update.setCorporate_organisation_name(corporateNameUpdateProfileTextField.getText());
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
        Event selectedEvent = null;

        if (UserDAO.checkCorporateOrganization(ACTUALUSER.getId())){
            // if corporate
            ticketsPaymentForCorporateOrganizationPane.toFront();
            try {
                selectedEvent = EventDAO.getEventByID(concertsTableConcertsPane.getSelectionModel().getSelectedItem().getId());
                double discount = 20.0/100.0;

                fullPriceLabelMakeOrganiserPaymentPane.setText(howManyLabelMoreDetailsPane.getText() + " x " + selectedEvent.getTicket_price() + " = " +
                        Double.parseDouble(howManyLabelMoreDetailsPane.getText())*selectedEvent.getTicket_price() + " GBP");
                totalValueLabelMakeOrganiserPaymentPane.setText(Double.parseDouble(howManyLabelMoreDetailsPane.getText())*selectedEvent.getTicket_price()-
                        (Double.parseDouble(howManyLabelMoreDetailsPane.getText())*selectedEvent.getTicket_price()*discount) + "GBP"
                );
                discountLabelMakeOrganiserPaymentPane.setText(discount*Double.parseDouble(howManyLabelMoreDetailsPane.getText()) *
                        selectedEvent.getTicket_price() + "GBP");

                if (payMohtnlycheckBoxPaymentPane.isSelected()){
                    payByCardOrganiserAnchorPane.setVisible(false);
                }


            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }else{
            //if not corporate
            ticketsPaymentPane.toFront();
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

    //BUY TICKETS PANE
    @FXML
    void pay(ActionEvent event) {

        JFXTextField[] requiredFields = {cardNameTicketPaymentPane, cardNumberTicketPaymentPane, monthTicketPaymentPane, yearTicketPaymentPane, securityCodeTicketPaymentPane};
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
                            "'" + howManyLabelMoreDetailsPane.getText() + "x " + selectedEvent.getName() + " " + selectedEvent.getEvent_type() + " tickets", 1, 0);

                    //DO THE BOOKING AFTERWARDS
                    //PAYMENT ID has to be retrieved based on the last entry in payments for the user or at least that how I see it
                    Payment currentPayment = PaymentDAO.getLastPaymentByID(ACTUALUSER.getId());
                    BookingDAO.insertBooking(Integer.parseInt(howManyLabelMoreDetailsPane.getText()), selectedEvent.getId(), ACTUALUSER.getId(), currentPayment.getId());

                    viewBookingsPane.toFront();

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

    //BOOKINGS PANE
    private void loadMyBookingsData() {
        festivalNameColumnBookingsPane.setCellValueFactory(cellData -> cellData.getValue().event_nameProperty());
        ticketsBoughtColumnBookingsPane.setCellValueFactory(cellData -> cellData.getValue().number_of_ticketsProperty().asString());
        dateColumnBookingsPane.setCellValueFactory(cellData -> cellData.getValue().event_dateProperty());
        locationColumnBookingsPane.setCellValueFactory(cellData -> cellData.getValue().locationProperty());

        try {
            ObservableList<Booking> bookingData = BookingDAO.getBookingsByUserID(ACTUALUSER.getId());
            populatebookings(bookingData);
        } catch (SQLException e) {
            System.err.println("Error occured while getting event information from DB " + e);
        } catch (ClassNotFoundException e) {
            System.err.println("Error occured while getting event information from DB " + e);
        }
    }


    @FXML
    private void populateBooking(Booking booking) throws ClassNotFoundException {
        ObservableList<Booking> bookingData = FXCollections.observableArrayList();
        bookingData.add(booking);
        myBookingsTable.setItems(bookingData);
    }

    @FXML
    private void populatebookings(ObservableList<Booking> bookingData) throws ClassNotFoundException {
        myBookingsTable.setItems(bookingData);
    }

    @FXML
    private void searchBooking(ActionEvent event){
        try {
            ObservableList<Booking> bookingData = BookingDAO.searchMyBookings(keywordTextFieldMyBookindsPane.getText(), ACTUALUSER.getId());
            populatebookings(bookingData);
        } catch (SQLException e) {
            System.err.println("Error occured while getting event information from DB " + e);
        } catch (ClassNotFoundException e) {
            System.err.println("Error occured while getting event information from DB " + e);
        }
    }

    @FXML
    private void seeMoreDetailsAboutEvent(ActionEvent event){
        Booking selectedBooking = null;
        Event currentEvent = null;
        Payment currentPayment = null;
        try {
            selectedBooking = BookingDAO.getBookingBYID(myBookingsTable.getSelectionModel().getSelectedItem().getId());
            currentEvent = EventDAO.getEventByIDProperty(selectedBooking.event_idProperty());
            currentPayment = PaymentDAO.getPaymentByIdProperty(selectedBooking.payment_idProperty());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        moreDetailsAboutMyBookingPane.toFront();
        eventNameLabelMyBookingPane.setText(selectedBooking.getEvent_name());
        eventTypeLabelMyBookingPane.setText(currentEvent.getEvent_type());
        locationLabelMyBookingPane.setText(currentEvent.getLocation());
        dateLabelMyBookingPane.setText(currentEvent.getDate());
        descriptionLabelMyBookingPane.setText(currentEvent.getDescription());
        if (currentPayment.isStatus()){
            paymentStatusLabelMyBookingPane.setText("Paid");
        }else{
            paymentStatusLabelMyBookingPane.setText("Pending");
        }
    }


    //pay pending bookings pane
    @FXML
    private void makePendingPayments(ActionEvent event){
        JFXTextField[] requiredFields = {cardNamePendingPaymentsPane, cardNumberPendingPaymentsPane,
                monthPendingPaymentsPane, yearPendingPaymentsPane, securityCodePendingPaymentsPane};
        boolean[] checkResults = new boolean[requiredFields.length];

        for (int i = 0; i < requiredFields.length; i++) {
            checkResults[i] = validationForTextFields(requiredFields[i]);
        }

        if (checkBooleanArray(checkResults)) {
            if (cardNumberPendingPaymentsPane.getText().length() != 16) {
                errorPayPendingBookingsPane.setText("Invalid card number");
            } else {
                try {
                    ObservableList<Booking> bookingData = BookingDAO.getAllMyUnpaidBookings(ACTUALUSER.getId());
                    for (int i = 0; i<bookingData.size(); i++){
                        PaymentDAO.updatePendingPayments(bookingData.get(i).getPayment_id(), cardNumberPendingPaymentsPane.getText(),
                                monthPendingPaymentsPane.getText() + "/" + yearPendingPaymentsPane.getText(), cardNamePendingPaymentsPane.getText(),
                                securityCodePendingPaymentsPane.getText(), 1);
                    }
                    makePaymentPane.toFront();
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

            }
        } else {
            errorPayPendingBookingsPane.setText("All fields are required");
        }
    }

    //makePaymentPane
    @FXML
    private void moveToPayPendingBookings(ActionEvent event){
        payPendingBookingsPane.toFront();
        try {
            ObservableList<Booking> bookingData = BookingDAO.getAllMyUnpaidBookings(ACTUALUSER.getId());

            double sum = 0.0d;

            for (int i = 0; i<bookingData.size(); i++){
                sum += bookingData.get(i).getNumber_of_tickets() * bookingData.get(i).getTicket_price();
            }

            double discount = (sum * 20.0/100.0);

            fullPriceLabelPayPendingBookingsPane.setText(sum + " GBP");
//            System.out.println(discount);
            discountLabelPayPendingBookingsPane.setText(discount + " GBP");
            totalValueLabelPayPendingBookingsPane.setText(sum - discount + " GBP");

        } catch (SQLException e) {
            System.err.println("Error occured while getting event information from DB " + e);
        } catch (ClassNotFoundException e) {
            System.err.println("Error occured while getting event information from DB " + e);
        }

    }

    private void loadUnpaidBookings() {
        eventNameColumnMakePaymentPane.setCellValueFactory(cellData -> cellData.getValue().event_nameProperty());
        ticketsColumnMakePaymentPane.setCellValueFactory(cellData -> cellData.getValue().number_of_ticketsProperty().asString());
        ammountColumnMakePaymentPane.setCellValueFactory(cellData -> cellData.getValue().ticket_priceProperty().asString());



        try {
            ObservableList<Booking> bookingData = BookingDAO.getAllMyUnpaidBookings(ACTUALUSER.getId());

            double sum = 0.0d;

            for (int i = 0; i<bookingData.size(); i++){
                sum += bookingData.get(i).getNumber_of_tickets() * bookingData.get(i).getTicket_price();
            }

            double discount = (sum * 20.0/100.0);

            totalLabelMakePaymentPane.setText(sum + " GBP");
//            System.out.println(discount);
            discountLabelPaymentPane.setText(discount + " GBP");
            afterDiscountLabelPaymentPane.setText(sum - discount + " GBP");
            populateUnpaidBookings(bookingData);

        } catch (SQLException e) {
            System.err.println("Error occured while getting event information from DB " + e);
        } catch (ClassNotFoundException e) {
            System.err.println("Error occured while getting event information from DB " + e);
        }
    }


    @FXML
    private void populateUnpaidBooking(Booking booking){
        ObservableList<Booking> bookingData = FXCollections.observableArrayList();
        bookingData.add(booking);
        pendingPaymentsTableView.setItems(bookingData);
    }

    @FXML
    private void populateUnpaidBookings(ObservableList<Booking> bookingData){
        pendingPaymentsTableView.setItems(bookingData);
    }

    //Corporate Organization Pay


    @FXML
    void corporatePay(ActionEvent event) {
        Event selectedEvent = null;
        if (payMohtnlycheckBoxPaymentPane.isSelected()){
            try {
                double discount = 20.0/100.0;
                selectedEvent = EventDAO.getEventByID(concertsTableConcertsPane.getSelectionModel().getSelectedItem().getId());
                PaymentDAO.insertMonthlyPayment(Double.parseDouble(howManyLabelMoreDetailsPane.getText())*selectedEvent.getTicket_price()-
                                (Double.parseDouble(howManyLabelMoreDetailsPane.getText())*selectedEvent.getTicket_price()*discount), ACTUALUSER.getId(),
                        "'" + howManyLabelMoreDetailsPane.getText() + "x " + selectedEvent.getName() + " " + selectedEvent.getEvent_type() + " tickets",
                        0, 1);

                //DO THE BOOKING AFTERWARDS
                //PAYMENT ID has to be retrieved based on the last entry in payments for the user or at least that how I see it
                Payment currentPayment = PaymentDAO.getLastPaymentByID(ACTUALUSER.getId());
                BookingDAO.insertBooking(Integer.parseInt(howManyLabelMoreDetailsPane.getText()), selectedEvent.getId(), ACTUALUSER.getId(), currentPayment.getId());

                ticketsPaymentPane.toFront();

            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }




        }else{
            JFXTextField[] requiredFields = {cardNameTicketCorporatePaymentPane, cardNumberCorporateTicketPaymentPane,
                    monthCorporateTicketPaymentPane, yearCorporateTicketPaymentPane, securityCodeCorporateTicketPaymentPane};
            boolean[] checkResults = new boolean[requiredFields.length];


            for (int i = 0; i < requiredFields.length; i++) {
                checkResults[i] = validationForTextFields(requiredFields[i]);
            }

            if (checkBooleanArray(checkResults)) {
                if (cardNumberCorporateTicketPaymentPane.getText().length() != 16) {
                    errorCorporatePaymentFieldsNotFilled.setText("Invalid card number");
                } else {
                    PaymentDAO entry = new PaymentDAO();

                    try {
                        double discount = 20.0/100.0;
                        selectedEvent = EventDAO.getEventByID(concertsTableConcertsPane.getSelectionModel().getSelectedItem().getId());
                        PaymentDAO.insertPayment(Double.parseDouble(howManyLabelMoreDetailsPane.getText())*selectedEvent.getTicket_price()-
                                        (Double.parseDouble(howManyLabelMoreDetailsPane.getText())*selectedEvent.getTicket_price()*discount),
                                cardNumberCorporateTicketPaymentPane.getText(), monthCorporateTicketPaymentPane.getText() + "/" + yearCorporateTicketPaymentPane.getText(),
                                cardNameTicketCorporatePaymentPane.getText(), securityCodeCorporateTicketPaymentPane.getText(),
                                ACTUALUSER.getId(),
                                "'" + howManyLabelMoreDetailsPane.getText() + "x " + selectedEvent.getName() + " " + selectedEvent.getEvent_type() + " tickets", 1, 1);

                        //DO THE BOOKING AFTERWARDS
                        //PAYMENT ID has to be retrieved based on the last entry in payments for the user or at least that how I see it
                        Payment currentPayment = PaymentDAO.getLastPaymentByID(ACTUALUSER.getId());
                        BookingDAO.insertBooking(Integer.parseInt(howManyLabelMoreDetailsPane.getText()), selectedEvent.getId(), ACTUALUSER.getId(), currentPayment.getId());

                        viewBookingsPane.toFront();

                    } catch (SQLException e) {
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                errorCorporatePaymentFieldsNotFilled.setText("All fields are required");
            }
        }
    }

    //MANAGE ACCOUNTS PANE
    private void loadAllAccounts(){
        firstNameColumnManageAccountsPane.setCellValueFactory(cellData -> cellData.getValue().first_nameProperty());
        lastNameColumnManageAccountsPane.setCellValueFactory(cellData -> cellData.getValue().last_nameProperty());
        emailColumnManageAccountsPane.setCellValueFactory(cellData -> cellData.getValue().email_addressProperty());
        phoneColumnManageAccountsPane.setCellValueFactory(cellData -> cellData.getValue().email_addressProperty());

        try {
            ObservableList<User> userData = UserDAO.getAllUsers();
            populateAllUsers(userData);
        } catch (SQLException e) {
            System.err.println("Error occured while getting event information from DB " + e);
        } catch (ClassNotFoundException e) {
            System.err.println("Error occured while getting event information from DB " + e);
        }
    }

    @FXML
    private void getAllCorporates(){
        try {
            ObservableList<User> userData = UserDAO.getAllCorporateOrganisations();
            populateAllUsers(userData);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void getAllOrganisers(){
        try {
            ObservableList<User> userData = UserDAO.getAllEventOrganisers();
            populateAllUsers(userData);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void getAllCustomers(){
        try {
            ObservableList<User> userData = UserDAO.getAllCustomers();
            populateAllUsers(userData);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void getAllAgents(){
        try {
            ObservableList<User> userData = UserDAO.getAllAgents();
            populateAllUsers(userData);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void searchUser(){
        try {
            ObservableList<User> userData = UserDAO.searchUser(keywordTextFieldManageAccountsPane.getText());
            populateAllUsers(userData);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void pupulateAllUsers(User user){
        ObservableList<User> userData = FXCollections.observableArrayList();
        userData.add(user);
        allUsersTableView.setItems(userData);
    }

    @FXML
    private void populateAllUsers(ObservableList<User> userData) {
        allUsersTableView.setItems(userData);
    }


    //VIEW/EDIT USER PROFILE PANE
    @FXML
    private void viewEditUserAccount(){
        try {
            User selectedUser = UserDAO.searchUsersByID(allUsersTableView.getSelectionModel().getSelectedItem().getId());
            firstNameEditUserAccountPane.setText(selectedUser.getFirst_name());
            lastNameEditUserAccountPane.setText(selectedUser.getLast_name());
            phoneEditUserAccountPane.setText(selectedUser.getMobile_no());
            addressEditUserAccountPane.setText(selectedUser.getAddress_line());
            address2EditUserAccountPane.setText(selectedUser.getAddress_line2());
            websiteEditUserAccountPane.setText(selectedUser.getWebsite_address());
            townEditUserAccountPane.setText(selectedUser.getTown());
            countyEditUserAccountPane.setText(selectedUser.getCounty());
            postcodeEditUserAccountPane.setText(selectedUser.getPostcode());
            contactEditUserAccountPane.setText(selectedUser.getContact_phone());
            contactEditUserAccountPane.setText(selectedUser.getContact_phone());

            userIdLabelEditProfilePane.setText(Integer.toString(selectedUser.getId()));
            userIdLabelEditProfilePane.setVisible(false);

            if (UserDAO.checkAdmin(selectedUser.getId())){
                userRankLabel.setText("Admin");
            }
            if (UserDAO.checkCorporateOrganization(selectedUser.getId())){
                userRankLabel.setText("Corporate");
            }
            if (UserDAO.checkEventOrganiser(selectedUser.getId())){
                userRankLabel.setText("Organiser");
            }
            if (!UserDAO.checkAdmin(selectedUser.getId()) && !UserDAO.checkCorporateOrganization(selectedUser.getId())
                    && !UserDAO.checkEventOrganiser(selectedUser.getId())) {
                userRankLabel.setText("Customer");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        editViewUserProfilePane.toFront();
    }

    @FXML
    private void updateUserProfile(){
        User update = new User();
        update.setId(Integer.parseInt(userIdLabelEditProfilePane.getText()));
        update.setFirst_name(firstNameEditUserAccountPane.getText());
        update.setLast_name(lastNameEditUserAccountPane.getText());
        update.setMobile_no(phoneEditUserAccountPane.getText());
        update.setAddress_line(addressEditUserAccountPane.getText());
        update.setAddress_line2(address2EditUserAccountPane.getText());
        update.setWebsite_address(websiteEditUserAccountPane.getText());
        update.setTown(townEditUserAccountPane.getText());
        update.setCounty(countyEditUserAccountPane.getText());
        update.setPostcode(postcodeEditUserAccountPane.getText());
        update.setContact_name(contactEditUserAccountPane.getText());
        update.setContact_phone(contactEditUserAccountPane.getText());

        UserDAO.updateUser(update);
        manageAccountsPane.toFront();
    }

    //MANAGE BOOKINGS PANE
    @FXML
    private void loadAllBookings(){
        eventNameColumnManageBookingsPane.setCellValueFactory(cellData -> cellData.getValue().event_nameProperty());
        ticketsboughtColumnManageBookingsPane.setCellValueFactory(cellData -> cellData.getValue().number_of_ticketsProperty().asString());
        userFNColumnManageBookingsPane.setCellValueFactory(cellData -> cellData.getValue().user_first_nameProperty());
        userLNColumnManageBookingsPane.setCellValueFactory(cellData -> cellData.getValue().user_last_nameProperty());
        discountedColumnManageBookingsPane.setCellValueFactory(cellData -> cellData.getValue().discountedProperty());
        paidColumnManageBookingsPane.setCellValueFactory(cellData-> cellData.getValue().paidProperty());

        try {
            ObservableList<Booking> bookingData = BookingDAO.getAllBookings();
            populateAllBookings(bookingData);
        } catch (SQLException e) {
            System.err.println("Error occured while getting event information from DB " + e);
        } catch (ClassNotFoundException e) {
            System.err.println("Error occured while getting event information from DB " + e);
        }
    }

    @FXML
    private void populateAllBookings(Booking booking){
        ObservableList<Booking> bookingData = FXCollections.observableArrayList();
        bookingData.add(booking);
        allBookingsTableView.setItems(bookingData);
    }

    @FXML
    private void populateAllBookings(ObservableList<Booking> bookingData){
        allBookingsTableView.setItems(bookingData);
    }

    @FXML
    private void getAllUnpaidBookings(){
        try {
            ObservableList<Booking> bookingData = BookingDAO.getAllUnpaidBookings();
            populateAllBookings(bookingData);
        } catch (SQLException e) {
            System.err.println("Error occured while getting event information from DB " + e);
        } catch (ClassNotFoundException e) {
            System.err.println("Error occured while getting event information from DB " + e);
        }
    }

    @FXML
    private void getAllPaidBookings(){
        try {
            ObservableList<Booking> bookingData = BookingDAO.getAllPaidBookings();
            populateAllBookings(bookingData);
        } catch (SQLException e) {
            System.err.println("Error occured while getting event information from DB " + e);
        } catch (ClassNotFoundException e) {
            System.err.println("Error occured while getting event information from DB " + e);
        }
    }

    @FXML
    private void getAllDiscountedBookings(){
        try {
            ObservableList<Booking> bookingData = BookingDAO.getAllDiscountedBookings();
            populateAllBookings(bookingData);
        } catch (SQLException e) {
            System.err.println("Error occured while getting event information from DB " + e);
        } catch (ClassNotFoundException e) {
            System.err.println("Error occured while getting event information from DB " + e);
        }
    }

    @FXML
    private void searchAllBookings(){
        try {
            ObservableList<Booking> bookingData = BookingDAO.searchThroughAllBookings(searchKeywordManageBookingsPane.getText());
            populateAllBookings(bookingData);
        } catch (SQLException e) {
            System.err.println("Error occured while getting event information from DB " + e);
        } catch (ClassNotFoundException e) {
            System.err.println("Error occured while getting event information from DB " + e);
        }
    }

    @FXML
    private void paySelectedBooking(){
        PaymentDAO.pay(allBookingsTableView.getSelectionModel().getSelectedItem().getPayment_id());
        System.out.println(allBookingsTableView.getSelectionModel().getSelectedItem().getPayment_id());
        loadAllBookings();
    }

    @FXML
    private void deleteSelectedBooking(){
        try {
            BookingDAO.delete(allBookingsTableView.getSelectionModel().getSelectedItem().getId());
            PaymentDAO.delete(allBookingsTableView.getSelectionModel().getSelectedItem().getPayment_id());
            loadAllBookings();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // MANAGE EVENTS PANE
    @FXML
    private void loadAllEvents(){
        nameColumnManageEventsPane.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        typeColumnManageEventsPane.setCellValueFactory(cellData -> cellData.getValue().event_typeProperty());
        ticketsAvailableColumnManageEventsPane.setCellValueFactory(cellData -> cellData.getValue().tickets_availableProperty().asObject());
        ticketPriceeColumnManageEventsPane.setCellValueFactory(cellData -> cellData.getValue().ticket_priceProperty().asObject());
        statusColumnManageEventsPane.setCellValueFactory(cellData -> cellData.getValue().statusProperty().asString());

        try {
            ObservableList<Event> eventData = EventDAO.retrieveAllEvents();
            populateAllEvents(eventData);
        } catch (SQLException e) {
            System.err.println("Error occured while getting event information from DB " + e);
        } catch (ClassNotFoundException e) {
            System.err.println("Error occured while getting event information from DB " + e);
        }
    }

    @FXML
    private void populateAllEvents(Event event) throws ClassNotFoundException {
        ObservableList<Event> eventData = FXCollections.observableArrayList();
        eventData.add(event);
        manageEventsTableView.setItems(eventData);
    }

    @FXML
    private void populateAllEvents(ObservableList<Event> eventData) throws ClassNotFoundException {
        manageEventsTableView.setItems(eventData);
    }

    @FXML
    private void searchAllEvents(){
        try {
            ObservableList<Event> eventData = EventDAO.searchThroughAllEvents(searchKeywordManageEventsPane.getText());
            populateAllEvents(eventData);
        } catch (SQLException e) {
            System.out.println("Error occured while getting event information from DB " + e);
        } catch (ClassNotFoundException e) {
            System.err.println("Error occured while getting event information from DB " + e);
        }
    }

    @FXML
    private void setStatusOn(){
        EventDAO.setStatusOn(manageEventsTableView.getSelectionModel().getSelectedItem().getId());
        loadAllEvents();
    }

    @FXML
    private void setStatusOff(){
        EventDAO.setStatusOff(manageEventsTableView.getSelectionModel().getSelectedItem().getId());
        loadAllEvents();
    }
}