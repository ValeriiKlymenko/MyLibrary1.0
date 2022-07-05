package com.example.mylibrary1;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class HomeView {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button ButtonAddBook;

    @FXML
    private Button ButtonExit;

    @FXML
    private Button ButtonMyLibrary;

    @FXML
    private Button ButtonSearchBook;

    @FXML
    private Button ButtonWhatToRead;

    @FXML
    void initialize() {
        ButtonExit.setOnAction(actionEvent -> {
            openNewScene("/com/example/mylibrary1/login-regist-view.fxml");
        });
        ButtonAddBook.setOnAction(actionEvent -> {
            openNewSceneAddBook("/com/example/mylibrary1/add-book-view.fxml");
        });

    }
        //метод для навігації
        public void openNewScene(String window){
            ButtonExit.getScene().getWindow().hide();

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
    public void openNewSceneAddBook(String window){
        ButtonAddBook.getScene().getWindow().hide();

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
