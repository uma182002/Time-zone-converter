package com.example.newfinal;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.fxml.FXML;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class Page5Controller implements Initializable{

    @FXML
    private ImageView planoImageView;
    @FXML
    private Label monText;
    @FXML
    private Label tuesText;
    @FXML
    private Label wednesText;
    @FXML
    private Label thursText;
    @FXML
    private Label friText;
    @FXML
    private Label saturText;
    @FXML
    private Label sunText;
    @FXML
    private Label goalText;
    @FXML
    private Label todo1Text;
    @FXML
    private Label todo2Text;
    @FXML
    private Label todo3Text;
    @FXML
    private Label todo4Text;
    @FXML
    private Label todo5Text;
    @FXML
    private Label todo6Text;
    @FXML
    private TextField usernameText;
    @FXML
    private Button exitButton;
    @FXML
    private Button updateButton;


    String user=null;

    public void initialize(URL url, ResourceBundle resourceBundle) {
        File planFile = new File("ImageFolder/neww.png");
        Image planImage = new Image(planFile.toURI().toString());
        planoImageView.setImage(planImage);


    }

    public void pressHereButtonOnAction(ActionEvent event){
        pressHere();
    }
    public void exitButtonOnAction(ActionEvent event){
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }
    public void updateButtonOnAction(ActionEvent event){
        Stage stage = (Stage) updateButton.getScene().getWindow();
        stage.close();
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Page4.fxml"));
            Stage updateStage = new Stage();
            Scene scene = new Scene(fxmlLoader.load(), 894, 710);
            updateStage.setTitle("The Globe");
            updateStage.setScene(scene);
            updateStage.show();

        } catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }



    public void pressHere() {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        user=usernameText.getText();
        String sql = "SELECT * FROM sadak.user_account WHERE username='" + user + "';";

        try {



            Statement statement = connectDB.createStatement();
            ResultSet rs=statement.executeQuery(sql);

            while(rs.next()){

                String mon=rs.getString("monday");
                monText.setText(mon);

                String tues=rs.getString("tuesday");
                tuesText.setText(tues);

                String wednes=rs.getString("wednesday");
                wednesText.setText(wednes);

                String thurs=rs.getString("thursday");
                thursText.setText(thurs);

                String fri=rs.getString("friday");
                friText.setText(fri);

                String satur=rs.getString("saturday");
                saturText.setText(satur);

                String sun=rs.getString("sunday");
                sunText.setText(sun);

                String goal=rs.getString("GOAL");
                goalText.setText(goal);

                String todo1=rs.getString("TODO1");
                todo1Text.setText(todo1);

                String todo2=rs.getString("TODO2");
                todo2Text.setText(todo2);

                String todo3=rs.getString("TODO3");
                todo3Text.setText(todo3);

                String todo4=rs.getString("TODO4");
                todo4Text.setText(todo4);

                String todo5 =rs.getString("TODO5");
                todo5Text.setText(todo5);

                String todo6=rs.getString("TODO6");
                todo6Text.setText(todo6);

            }

        } catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }

    }

    /* public void validateLogin(){
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

         user=usernameText.getText();

        String verifyLogin = "SELECT count(1) FROM sadak.user_account WHERE username = '" + user + "' ";

        try{
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);

            while(queryResult.next()){
                if(queryResult.getInt(1) == 1){
                    //loginMessage.setText("Congrats!");
                    pressHere();

                } else {
                    //loginMessage.setText("Invalid login. Try again.");
                }
            }
        } catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }*/


}
