package com.javainuse.main;

import com.javainuse.main.ui.MainFrame;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    public static void main(String[] args) {
        System.out.println("IA");
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage = new MainFrame();
//        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("IA");
//        primaryStage.setScene(new Scene(root,300,300));

        primaryStage.show();
    }
}