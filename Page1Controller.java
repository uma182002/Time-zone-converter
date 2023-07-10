package com.example.newfinal;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;

import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import java.net.URL;

public class Page1Controller implements Initializable {

    @FXML
    private Button cancelButton;

    @FXML
    private Label loginMessage;
    @FXML
    private ImageView brandingImageView;
    @FXML
    private ImageView lockImageView;
    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField passwordTextField;
    @FXML
    private Button createNewAccount;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        File brandingFile = new File("ImageFolder/imageblue.png");
        Image brandingImage = new Image(brandingFile.toURI().toString());
        brandingImageView.setImage(brandingImage);

        File lockFile = new File("ImageFolder/lock.png");
        Image lockImage = new Image(lockFile.toURI().toString());
        lockImageView.setImage(lockImage);
    }

    public void loginButtonOnAction(ActionEvent event){
        if(!usernameTextField.getText().isBlank() && !passwordTextField.getText().isBlank()){
            validateLogin();
        } else {
            loginMessage.setText("Please enter the username and password");

        }
    }

    public void createNewAccountOnAction(ActionEvent event){
        createAccountForm();
    }

    public void worldClockOnAction(ActionEvent event){
        worldClockForm();
    }

    public void cancelButtonOnAction(ActionEvent event) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    public void validateLogin(){
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String user=usernameTextField.getText();
        String pass=passwordTextField.getText();
        String verifyLogin = "SELECT count(1) FROM sadak.user_account WHERE username = '" + user + "' AND password = '" + pass +"'";

        try{
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);

            while(queryResult.next()){
                if(queryResult.getInt(1) == 1){
                    //loginMessage.setText("Congrats!");
                    loginForm(user,pass);

                } else {
                    loginMessage.setText("Invalid login. Try again.");
                }
            }
        } catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }

    public void createAccountForm(){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Page2.fxml"));
            Stage registerStage = new Stage();
            Scene scene = new Scene(fxmlLoader.load(), 600, 570);
            registerStage.setTitle("The Globe : Create new account");
            registerStage.setScene(scene);
            registerStage.show();

        } catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }

    public void worldClockForm(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Page3.fxml"));
            Stage worldStage = new Stage();
            Scene scene = new Scene(fxmlLoader.load(), 602, 537);
            worldStage.setTitle("The Globe");
            worldStage.setScene(scene);
            worldStage.show();

        } catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }

    public void loginForm(String usernam, String passwor){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Page6.fxml"));
            Stage loginStage = new Stage();
            Scene scene = new Scene(fxmlLoader.load(), 812, 514);
            loginStage.setTitle("The Globe");
            loginStage.setScene(scene);
            loginStage.show();

        } catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }

    }
}