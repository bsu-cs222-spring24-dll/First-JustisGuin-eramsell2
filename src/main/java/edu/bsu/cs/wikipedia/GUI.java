package edu.bsu.cs.wikipedia;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.Objects;

public class GUI extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("Interface.fxml")));
        primaryStage.setTitle("Wikipedia Revision Reader");
        primaryStage.setScene(new Scene(root, 400, 375));
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
