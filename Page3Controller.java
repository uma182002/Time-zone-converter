package com.example.newfinal;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.TimeZone;

public class Page3Controller implements Initializable {

    @FXML
    private Button backButton;
    @FXML
    private ImageView globeImageView;
    @FXML
    private ComboBox countriesComboBox;
    ObservableList<String> list= FXCollections.observableArrayList("india","nepal","america","pakistan","srilanka","australia","china","russian","japan","france","bangladesh","iraq","united kingdom","Hong Kong");

    @FXML
    private Label timeInitializeLabel;
    @FXML
    private Label timeResultLabel;

    private static final String dateFormat = "dd-M-yyyy      hh:mm:ss a";
    SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
    Date date;
    Date date1 = new Date();
    String dateInString = formatter.format(date1)+"";

    TimeZone tz = TimeZone.getDefault();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        File globeFile = new File("ImageFolder/globe1.png");
        Image globeImage = new Image(globeFile.toURI().toString());
        globeImageView.setImage(globeImage);

        countriesComboBox.setItems(list);
        try {
            date = formatter.parse(dateInString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        timeInitializeLabel.setText(formatter.format(date1));
    }

    public void timeDisplay(){
        String selectTimeZone= (String) countriesComboBox.getValue();
        String timeZone=getSelectTimeZone(selectTimeZone);
        SimpleDateFormat sdfIndia = new SimpleDateFormat(dateFormat);
        TimeZone tzInIndia = TimeZone.getTimeZone(timeZone);
        sdfIndia.setTimeZone(tzInIndia);
        String sDateInIndia = sdfIndia.format(date);
        Date dateInIndia = null;
        try {
            dateInIndia = formatter.parse(sDateInIndia);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        timeResultLabel.setText(formatter.format(dateInIndia)+"");
    }

    public void backButtonOnAction(ActionEvent event){
        Stage stage = (Stage) backButton.getScene().getWindow();
        stage.close();
    }

    private String getSelectTimeZone(String selectTimeZone) {
        switch (selectTimeZone) {
            case "india":
                return "Asia/Kolkata";
            case "nepal":
                return "Asia/Kathmandu";
            case "america":
                return "America/New_York";
            case "pakistan":
                return "Asia/Karachi";
            case "srilanka":
                return "Asia/Colombo";
            case "australia":
                return "Europe/Vienna";
            case "china":
                return "Asia/Shanghai";
            case "russian":
                return "Europe/Moscow";
            case "japan":
                return "Asia/Tokyo";
            case "france":
                return "Europe/Paris";
            case "bangladesh":
                return "Asia/Dhaka";
            case "iraq":
                return "Asia/Baghdad";
            case "united kingdom":
                return "Europe/London";
            case "Hong Kong":
                return "Asia/Hong_Kong";
            default:
                break;
        }
        return "Asia/Kolkata";
    }


}
