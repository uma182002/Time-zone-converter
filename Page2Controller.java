package com.example.newfinal;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ResourceBundle;

public class Page2Controller implements Initializable {

    @FXML
    private ImageView shieldImageView;
    @FXML
    private Button closeButton;
    @FXML
    private Label registrationMessage;
    @FXML
    private PasswordField passwordField;
    @FXML
    private PasswordField confirmPasswordField;
    @FXML
    private Label confirmPasswordMessage;
    @FXML
    private TextField firstnameTextField;
    @FXML
    private TextField lastnameTextField;
    @FXML
    private TextField usernameTextField;



    public void initialize(URL url, ResourceBundle resourceBundle) {

        File shieldFile = new File("ImageFolder/shield.png");
        Image shieldImage = new Image(shieldFile.toURI().toString());
        shieldImageView.setImage(shieldImage);
    }

    public void registerButtonOnAction(ActionEvent event){
        if(passwordField.getText().equals(confirmPasswordField.getText())){
            registerUser();
            confirmPasswordMessage.setText("");

        } else {
            confirmPasswordMessage.setText("Password does not match");
        }

    }

    public void closeButtonOnAction(ActionEvent event){
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();

    }

   public void registerUser(){
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String firstname= firstnameTextField.getText();
        String lastname= lastnameTextField.getText();
        String username= usernameTextField.getText();
        String password= passwordField.getText();

        String insertFields = "insert into sadak.user_account (firstname, lastname, username, password) values('";
        String insertValues = firstname + "', '" +lastname + "', '" + username + "', '" + password + "')";
        String insertToRegister = insertFields + insertValues;

        try{
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(insertToRegister);

            registrationMessage.setText("User registered successfully!");
        } catch (Exception e){

            e.printStackTrace();
            e.getCause();
        }
    }
}
