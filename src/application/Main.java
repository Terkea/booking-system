package application;

import application.model.UserDAO;
import application.system.Password;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.SQLException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("view/login.fxml"));
        primaryStage.setTitle("Log In");
        primaryStage.setScene(new Scene(root, 360, 475));
        primaryStage.show();
        primaryStage.setResizable(false);
    }


    public static void main(String[] args) {
        launch(args);
        UserDAO ud = new UserDAO();


        System.out.println(ud.checkEmailUnique("terkeabt@gmail.co"));


    }
}