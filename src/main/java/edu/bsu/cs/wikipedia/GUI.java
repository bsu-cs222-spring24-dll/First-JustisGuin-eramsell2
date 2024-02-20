package edu.bsu.cs.wikipedia;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class GUI extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    private final Button searchButton = new Button("Search");
    private final TextField inputField = new TextField();
    private final TextField outputField = new TextField();

    @Override
    public void start(Stage primaryStage){
        outputField.setEditable(false);
        configure(primaryStage);
        configureSearchButton();
    }

    private void configure(Stage stage) {
        stage.setTitle("Wiki Search");
        stage.setScene(new Scene(createRoot()));
        stage.sizeToScene();
        stage.show();
    }
    private Pane createRoot() {
        VBox root = new VBox();
        root.getChildren().addAll(
                new Label("Input:"),
                inputField,
                searchButton,
                new Label("Output:"),
                outputField);
        return root;
    }
    private void configureSearchButton() {
        searchButton.setOnAction(event -> {
            try {
                searchWiki(inputField.getText());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });


    }
    private void searchWiki(String input) throws IOException {
        revisionParser run = new revisionParser();
        String output = String.valueOf(run.dateUserList(input));


        outputField.setText(output);
    }

}