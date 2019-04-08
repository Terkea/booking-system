package application.controller;



import java.net.URL;
import java.util.ResourceBundle;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.scene.layout.Pane;

import javax.swing.*;


public class Application implements Initializable {
    @FXML
    private Pane pnl_ViewAccount, pnl_EditAccount, pnl_ViewCF,pnl_MakeBooking,pnl_ViewBookings,pnl_AddCF;

    @FXML
    private JButton btn_EditDetails;

    @FXML
    private Button btn_Account,btn_ViewCF,btn_MakeBooking,btn_Book,btn_ViewBookings,btn_AddCF;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        if (event.getSource() == btn_Account) {
            pnl_ViewAccount.toFront();

        } else if (event.getSource() == btn_EditDetails) {
            pnl_EditAccount.toFront();
        } else if (event.getSource() == btn_ViewCF) {
            pnl_ViewCF.toFront();
        } else if (event.getSource() == btn_Book) {
            pnl_MakeBooking.toFront();
        } else if (event.getSource() == btn_MakeBooking) {
            pnl_MakeBooking.toFront();
        } else if (event.getSource() == btn_ViewBookings) {
            pnl_ViewBookings.toFront();
        }
        else if (event.getSource() == btn_AddCF) {
            pnl_AddCF.toFront();
        }   }





    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //todo
    }
}


