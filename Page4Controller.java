package com.example.newfinal;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.fxml.FXML;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ResourceBundle;

public class Page4Controller implements Initializable {

    @FXML
    private Button exitButton;

    @FXML
    private ImageView plannerImageView;
    @FXML
    private TextField mondayLabel;
    @FXML
    private TextField tuesdayLabel;
    @FXML
    private TextField wednesdayLabel;
    @FXML
    private TextField thursdayLabel;
    @FXML
    private TextField fridayLabel;
    @FXML
    private TextField saturdayLabel;
    @FXML
    private TextField sundayLabel;
    @FXML
    private Label updateLabel;
    @FXML
    private TextField PlanUsernam;
    @FXML
    private TextField todo1;
    @FXML
    private TextField todo2;
    @FXML
    private TextField todo3;
    @FXML
    private TextField todo4;
    @FXML
    private TextField todo5;
    @FXML
    private TextField todo6;
    @FXML
    private TextField hhText;
    @FXML
    private TextField mmText;
    @FXML
    private TextField ampmText;
    @FXML
    private Button goButton;

    @FXML
    private ComboBox timeZoneComboBox;
    ObservableList<String> list1= FXCollections.observableArrayList("KST - Korean","NPT - Nepal","EST - Eastern","PKT - Pakistan","SLST - Srilanka","CST - China","JST - Japan","BST - Bangladesh","GMT - United Kingdom");

    @FXML
    private Label hhLabel;
    @FXML
    private Label mmLabel;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File planFile = new File("ImageFolder/planner.png");
        Image planImage = new Image(planFile.toURI().toString());
        plannerImageView.setImage(planImage);

        timeZoneComboBox.setItems(list1);
    }

    public void exitButtonOnAction(ActionEvent event){
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }

    public void saveButtonOnAction(ActionEvent event){
            saveDetails();
    }

    public void saveDetails() {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String usr = PlanUsernam.getText();
        String mon = mondayLabel.getText();
        String tues = tuesdayLabel.getText();
        String wed = wednesdayLabel.getText();
        String thurs = thursdayLabel.getText();
        String fri = fridayLabel.getText();
        String sat = saturdayLabel.getText();
        String sun = sundayLabel.getText();
        String to1 = todo1.getText();
        String to2 = todo2.getText();
        String to3 = todo3.getText();
        String to4 = todo4.getText();
        String to5 = todo5.getText();
        String to6 = todo6.getText();


        String insertFields = "update sadak.user_account set monday = '" + mon + "' where username = '" + usr + "' ;";
        String insertFields1 = "update sadak.user_account set tuesday = '" + tues + "' where username = '" + usr + "' ;";
        String insertFields2 = "update sadak.user_account set wednesday = '" + wed + "' where username = '" + usr + "' ;";
        String insertFields3 = "update sadak.user_account set thursday = '" + thurs + "' where username = '" + usr + "' ;";
        String insertFields4 = "update sadak.user_account set friday = '" + fri + "' where username = '" + usr + "' ;";
        String insertFields5 = "update sadak.user_account set saturday = '" + sat + "' where username = '" + usr + "' ;";
        String insertFields6 = "update sadak.user_account set sunday = '" + sun + "' where username = '" + usr + "' ;";
        String insertFields7 = "update sadak.user_account set TODO1 = '" + to1 + "' where username = '" + usr + "' ;";
        String insertFields8 = "update sadak.user_account set TODO2 = '" + to2 + "' where username = '" + usr + "' ;";
        String insertFields9 = "update sadak.user_account set TODO3 = '" + to3 + "' where username = '" + usr + "' ;";
        String insertFields10 = "update sadak.user_account set TODO4 = '" + to4 + "' where username = '" + usr + "' ;";
        String insertFields11 = "update sadak.user_account set TODO5 = '" + to5 + "' where username = '" + usr + "' ;";
        String insertFields12 = "update sadak.user_account set TODO6 = '" + to6 + "' where username = '" + usr + "' ;";

        try {
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(insertFields);
            statement.executeUpdate(insertFields1);
            statement.executeUpdate(insertFields2);
            statement.executeUpdate(insertFields3);
            statement.executeUpdate(insertFields4);
            statement.executeUpdate(insertFields5);
            statement.executeUpdate(insertFields6);
            statement.executeUpdate(insertFields7);
            statement.executeUpdate(insertFields8);
            statement.executeUpdate(insertFields9);
            statement.executeUpdate(insertFields10);
            statement.executeUpdate(insertFields11);
            statement.executeUpdate(insertFields12);

            updateLabel.setText("Updated successfully");
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }


        public void goButtonOnAction(ActionEvent event){
            int hh1 = Integer.parseInt(hhText.getText());
            int mm1 = Integer.parseInt(mmText.getText());
            //String ampm = ampmText.getText();

            String selectTimeZone= (String) timeZoneComboBox.getValue();
            int timeZone[];
            timeZone = getSelectTimeZone1(selectTimeZone, hh1, mm1);
            hhLabel.setText(String.valueOf(timeZone[0]));
            mmLabel.setText(String.valueOf(timeZone[1]));

        }

//"KST - Korean","NPT - Nepal","EST - Eastern","PKT - Pakistan","SLST - Srilanka",
// "CST - China","JST - Japan","BST - Bangladesh","GMT - United Kingdom"







    private int[] getSelectTimeZone1(String selectTimeZone, int hh1, int mm1) {
        switch (selectTimeZone) {
            case "KST - Korean":
                if(hh1==4){
                    hh1=hh1+1;
                }
                int hh2 = hh1 - 4;
                int mm2 = mm1 - 30;
                if (hh2 < 0) {
                    hh2 = hh2 + 24;
                }

                if (mm2 < 0) {
                    mm2 = mm2 + 60;
                    //hh2 = hh2 + 1;
                }
                int arr[] = {hh2, mm2};
                return (arr);
            case "NPT - Nepal":
                //int hh21 = hh1 + 3;
                //int mm21 = mm1 + 30;
                //if (hh21 >= 24) {
                  //  hh21 = hh21 - 24;
               // }
                //if (mm21 >= 60) {
                  //  mm21 = mm21 - mm1;
                    //hh21 = hh21 + 1;
                //}
                int arr1[] = {hh1, mm1};
                return (arr1);
            case "EST - Eastern":
                if(hh1==4){
                    hh1=hh1+1;
                }
                int hh22 = hh1 - 4;
                int mm22 = mm1 - 30;
                if (hh22 < 0) {
                    hh22 = hh22 + 24;
                }

                if (mm22 < 0) {
                    mm22 = mm22 + 60;
                    //hh2 = hh2 + 1;
                }
                int arr2[] = {hh22, mm22};
                return (arr2);
            case "PKT - Pakistan":
                int hh23 = hh1 + 3;
                int mm23 = mm1 + 30;
                if (hh23 >= 24) {
                    hh23 = hh23 - 24;
                }
                if (mm23 >= 60) {
                    mm23 = mm23 - mm1;
                    hh23 = hh23 + 1;
                }
                int arr3[] = {hh23, mm23};
                return (arr3);
            case "SLST - Srilanka":
                int hh24 = hh1 + 3;
                int mm24 = mm1 + 30;
                if (hh24 >= 24) {
                    hh24 = hh24 - 24;
                }
                if (mm24 >= 60) {
                    mm24 = mm24 - mm1;
                    hh24 = hh24 + 1;
                }
                int arr4[] = {hh24, mm24};
                return (arr4);
            case "CST - China":
                int hh25 = hh1 + 3;
                int mm25 = mm1 + 30;
                if (hh25 >= 24) {
                    hh25 = hh25 - 24;
                }
                if (mm25 >= 60) {
                    mm25 = mm25 - mm1;
                    hh25 = hh25 + 1;
                }
                int arr5[] = {hh25, mm25};
                return (arr5);
            case "JST - Japan":
                int hh26 = hh1 + 3;
                int mm26 = mm1 + 30;
                if (hh26 >= 24) {
                    hh26 = hh26 - 24;
                }
                if (mm26 >= 60) {
                    mm26 = mm26 - mm1;
                    hh26 = hh26 + 1;
                }
                int arr6[] = {hh26, mm26};
                return (arr6);
            case "BST - Bangladesh":
                int hh27 = hh1 + 3;
                int mm27 = mm1 + 30;
                if (hh27 >= 24) {
                    hh27 = hh27 - 24;
                }
                if (mm27 >= 60) {
                    mm27 = mm27 - mm1;
                    hh27 = hh27 + 1;
                }
                int arr7[] = {hh27, mm27};
                return (arr7);
            case "GMT - United Kingdom":
                int hh28 = hh1 + 3;
                int mm28 = mm1 + 30;
                if (hh28 >= 24) {
                    hh28 = hh28 - 24;
                }
                if (mm28 >= 60) {
                    mm28 = mm28 - mm1;
                    hh28 = hh28 + 1;
                }
                int arr8[] = {hh28, mm28};
                return (arr8);

        }
        return new int[0];

    }


}
