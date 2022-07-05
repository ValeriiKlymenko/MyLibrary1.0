package com.example.mylibrary1;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AddBookView {

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
    private Button ButtonToHome;

    @FXML
    private Button ButtonWhatToRead;

    @FXML
    private ChoiceBox<String> ChoiceBoxAddStatus;
    private String[] status = {"Почав читати", "Закінчив читати", "Хочу прочитати"};

    @FXML
    private ComboBox<String> ComboBoxAddNameAutor;
    private String[] autor = {"автор 1", "автор 2", "автор 3"};

    @FXML
    private RadioButton RadioButtonAddAudiobook;

    @FXML
    private RadioButton RadioButtonAddBook;

    @FXML
    private TextArea TextAreaAddNotes;

    @FXML
    private TextField TextFieldAddCategory;

    @FXML
    private TextField TextFieldAddNameBook;

    @FXML
    private TextField TextFieldAddPage;

    @FXML
    void initialize() {
        ChoiceBoxAddStatus.getItems().addAll(status);
        ComboBoxAddNameAutor.getItems().addAll(autor);

        ButtonAddBook.setOnAction(actionEvent -> {
            AddNewBook();
        });

    }
    private void AddNewBook() {
        DatabaseHandler dbHandler = new DatabaseHandler();

        String namebook = TextFieldAddNameBook.getText();
        String idautor = ComboBoxAddNameAutor.getValue();
        String categorybook = TextFieldAddCategory.getText();
        String idtype = "";
        if(RadioButtonAddBook.isSelected()){
            idtype = "1";
        }else
            idtype = "2";
        String idstatus = ChoiceBoxAddStatus.getValue();
        String pagebook = TextFieldAddPage.getText();
        String notesbook = TextAreaAddNotes.getText();

        Book book = new Book(namebook, categorybook, pagebook, notesbook, idstatus, idtype, idautor);
        try {
            dbHandler.AddNewBook(book);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
