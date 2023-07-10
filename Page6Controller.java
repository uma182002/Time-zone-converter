package com.example.newfinal;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.fxml.FXML;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ResourceBundle;

public class Page6Controller implements Initializable {

    @FXML
    private ImageView designImageView;
    @FXML
    private Button exitButton;

    public void initialize(URL url, ResourceBundle resourceBundle) {
        File designFile = new File("ImageFolder/menu.png");
        Image designImage = new Image(designFile.toURI().toString());
        designImageView.setImage(designImage);
    }

    public void exitButtonOnAction(ActionEvent event){
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }

    public void updateButtonOnAction(ActionEvent event){
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

    public void viewButtonOnAction(ActionEvent event){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Page5.fxml"));
            Stage viewStage = new Stage();
            Scene scene = new Scene(fxmlLoader.load(), 555, 723);
            viewStage.setTitle("The Globe");
            viewStage.setScene(scene);
            viewStage.show();

        } catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }




}
