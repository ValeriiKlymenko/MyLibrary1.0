package com.example.mylibrary1;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.example.mylibrary1.animations.Shake;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Label;


public class LoginRegistView {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button ButtonLogin;

    @FXML
    private Button ButtonRegist;

    @FXML
    private PasswordField PasswordFieldLoginPassword;

    @FXML
    private PasswordField PasswordFieldRegistPassword;

    @FXML
    private TextField TextFieldLoginLogin;

    @FXML
    private TextField TextFieldRegistFirstName;

    @FXML
    private TextField TextFieldRegistLastName;

    @FXML
    private TextField TextFieldRegistLogin;

    @FXML
    private TextField TextFieldRegistMail;

    @FXML
    private Label lableLoginText;

    @FXML
    private Label lableRegistText;

    @FXML
    void initialize() {
        //8. виклик методу для реєстрації
        //9.створюємо class User
        ButtonRegist.setOnAction(actionEvent -> {
            registNewUser();
            lableRegistText.setText("Success!");
        });

        ButtonLogin.setOnAction(actionEvent -> {
            openNewScene("/com/example/mylibrary1/home-view.fxml");
        });
        //4.перевірка логіні та паролю при Вході на пустоту
        ButtonLogin.setOnAction(actionEvent -> {
            String Logintext = TextFieldLoginLogin.getText().trim();
            String LoginPassword = PasswordFieldLoginPassword.getText().trim();
            if(!Logintext.equals("") && !LoginPassword.equals("")){
                LoginUser (Logintext, LoginPassword);
                //5. LoginUser правою клавішею створюємо знизу...
            }else
                //lable який появляється коли поля пусті
                lableLoginText.setText("Login/password is empty/wrong!");
        });
        
    }
    // 16.авторизація. викликаний метод у перевірці паролю та логіна чи є у базі
    private void LoginUser(String logintext, String loginPassword) {
        DatabaseHandler dbHandler = new DatabaseHandler();
        User user = new User();
        user.setLoginusers(logintext);
        user.setPasswordusers(loginPassword);
        ResultSet resultSet = dbHandler.getUser(user);

        int counter = 0;

        try {
            while (resultSet.next()) {
                counter++;
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }

        if (counter >=1 ){
            openNewScene("/com/example/mylibrary1/home-view.fxml");
        }else {
            lableLoginText.setText("Login/password is empty/wrong!");
            // анімація трясіння кнопки
            //імпортуємо клас
            Shake loginloginAnim = new Shake(TextFieldLoginLogin);
            Shake loginPasswordAnim = new Shake(PasswordFieldLoginPassword);
            loginloginAnim.playAnim();
            loginPasswordAnim.playAnim();

        }
    }
    //13. метод у якому реалузуємо реєстрацію і запису поля у БД
    //на 13 закінчили з реєстрацією з 14 починаємо авторизовувати
     private void registNewUser() {
            DatabaseHandler dbHandler = new DatabaseHandler();

            String firstnameusers = TextFieldRegistFirstName.getText();
            String lastnameusers = TextFieldRegistLastName.getText();
            String loginusers = TextFieldRegistLogin.getText();
            String passwordusers = PasswordFieldRegistPassword.getText();
            String mailusers = TextFieldRegistMail.getText();

            User user = new User(firstnameusers, lastnameusers, loginusers, passwordusers, mailusers);
            try {
                dbHandler.singUpUser(user);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    //метод для навігації
        public void openNewScene(String window) {
            ButtonLogin.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(window));
            try {
                loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        }

}
