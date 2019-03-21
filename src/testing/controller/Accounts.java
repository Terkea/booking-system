package testing.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import testing.model.User;
import testing.model.UserDAO;

import java.sql.SQLException;

public class Accounts {
    @FXML
    private TableView userTable;

    @FXML
    private TableColumn<User, Integer> idTableColumn;

    @FXML
    private TableColumn<User, String> first_nameTableColumn;

    @FXML
    private TableColumn<User, String> last_nameTableColumn;

    @FXML
    private TableColumn<User, String> emailTableColumn;

    @FXML
    private TableColumn<User, String> genderTableColumn;

    @FXML
    private TableColumn<User, String> ip_addressTableColumn;

    @FXML
    private TableColumn<User, String> is_adminTableColumn;

    @FXML
    private TableColumn<User, String> cityTableColumn;

    @FXML
    private TableColumn<User, String> websiteTableColumn;

    @FXML
    private TableColumn<User, String> streetTableColumn;

    @FXML
    private Button searchButton;

    @FXML
    private Button deleteButton;

    @FXML
    private Button updateButton;

    @FXML
    private Button addNewButton;

    @FXML
    private TextField searchTextField;


    @FXML
    private void initialize()throws SQLException, ClassNotFoundException{
        idTableColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
        first_nameTableColumn.setCellValueFactory(cellData -> cellData.getValue().first_nameProperty());
        last_nameTableColumn.setCellValueFactory(cellData -> cellData.getValue().last_nameProperty());
        emailTableColumn.setCellValueFactory(cellData -> cellData.getValue().emailProperty());
        genderTableColumn.setCellValueFactory(cellData -> cellData.getValue().genderProperty());
        ip_addressTableColumn.setCellValueFactory(cellData -> cellData.getValue().ip_addressProperty());
        is_adminTableColumn.setCellValueFactory(cellData -> cellData.getValue().is_adminProperty());
        cityTableColumn.setCellValueFactory(cellData -> cellData.getValue().cityProperty());
        websiteTableColumn.setCellValueFactory(cellData -> cellData.getValue().websiteProperty());
        streetTableColumn.setCellValueFactory(cellData -> cellData.getValue().streetProperty());


        //INITIALIZE THE TABLE WITH DATA
        try{
            ObservableList<User> userData = UserDAO.getAllUsers();
            populateUsers(userData);
        }catch(SQLException e){
            System.out.println("Error occured while getting employees information from DB " + e);
            throw e;
        }
    }

    @FXML
    private void populateUser (User user) throws ClassNotFoundException{
        ObservableList<User> userData = FXCollections.observableArrayList();
        userData.add(user);
        userTable.setItems(userData);
    }

    @FXML
    private void populateUsers(ObservableList<User> userData) throws ClassNotFoundException{
        userTable.setItems(userData);
    }

    @FXML
    private void populateAndShowUser(User user) throws ClassNotFoundException{
        if (user != null){
            populateUser(user);
        }
    }

    @FXML
    private void searchUsers(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try{
            ObservableList<User> userData = UserDAO.searchUsers(searchTextField.getText());
            populateUsers(userData);
        }catch(SQLException e){
            System.out.println("Error occured while getting employees information from DB " + e);
            throw e;
        }
    }

    @FXML
    void addNewUser(ActionEvent event) {
        System.out.println("Button works");
    }

    @FXML
    void deleteUser(ActionEvent event) {
        System.out.println("Button works");
    }

    @FXML
    void updateUser(ActionEvent event) {
        System.out.println("Button works");
    }


}
